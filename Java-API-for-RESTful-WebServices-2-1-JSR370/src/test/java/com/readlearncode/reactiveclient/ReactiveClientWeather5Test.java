package com.readlearncode.reactiveclient;

import com.readlearncode.reactiveclient.BodyReaders.LocationMessageBodyReader;
import com.readlearncode.reactiveclient.BodyReaders.WeatherMessageBodyReader;
import com.readlearncode.reactiveclient.resource.CityData;
import com.readlearncode.reactiveclient.resource.Location;
import com.readlearncode.reactiveclient.resource.Weather;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * Creates re
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ReactiveClientWeather5Test {

    private WebTarget weather;
    private WebTarget location;

    @Before
    public void initClient() {
        location = ClientBuilder.newClient()
                .register(LocationMessageBodyReader.class)
                .target("https://www.metaweather.com/api/location/search/?query={city}");

        weather = ClientBuilder.newClient()
                .register(WeatherMessageBodyReader.class)
                .target("https://www.metaweather.com/api/location/{woeid}/"); // woeid is city id
    }

    @Test
    public void reactive() throws InterruptedException {

        // Stream of cities
        Stream.of("London", "Paris", "New York", "Tokyo")
                // Retrieve a list of city ids (woeid) for each city
                .map(city -> location.resolveTemplate("city", city).request().rx().get(Location.class))
                .forEach(locationStage -> locationStage.thenCompose(location -> {

                    // Then for each city id retrieve the weather forecast
                    CompletionStage<Weather> weatherResult =
                            weather.resolveTemplate("woeid", location.getWoeid()).request().rx().get(Weather.class);

                    // Compose the weather data for that city
                    //noinspection unchecked
                    return CompletableFuture
                            .completedFuture(new CityData(location))
                            .thenCombine(weatherResult, CityData::weather);

                    // After each completion print to the console city and weather data
                }).whenComplete((cityData, throwable) ->
                        System.out.println(
                                cityData.getLocation().getTitle() + " " +
                                        cityData.getWeather().getConsolidated_weather()[0].getMax_temp()
                        )));

        // Sleep to allow calls to REST endpoints to complete.
        Thread.sleep(5000);
    }
}
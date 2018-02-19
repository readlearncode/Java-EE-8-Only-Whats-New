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

/**
 * Creates re
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ReactiveClientWeather3Test {

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

        // Stage that retrieves the city id
        CompletionStage<Location> locationStage = location.resolveTemplate("city", "london").request().rx().get(Location.class)
                .exceptionally(throwable -> {
                    System.out.println("Error: " + throwable.getMessage());
                    return null;
                });

        // Stage that retrieves weather for city
        CompletionStage<CityData> weatherStage = locationStage.thenCompose(local -> {
            final CompletionStage<Weather> weatherResult =
                    weather.resolveTemplate("woeid", local.getWoeid()).request().rx().get(Weather.class);

            //noinspection unchecked
            return CompletableFuture.completedFuture(new CityData(local))
                    .thenCombine(weatherResult, CityData::weather);
        });

        weatherStage.whenComplete((cityData, throwable) ->
                System.out.println(
                        cityData.getLocation().getTitle() + " " +
                                cityData.getWeather().getConsolidated_weather()[0].getMax_temp()
                ));


        Thread.sleep(5000);

    }
}
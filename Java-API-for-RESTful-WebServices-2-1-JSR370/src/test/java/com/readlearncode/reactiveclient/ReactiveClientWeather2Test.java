package com.readlearncode.reactiveclient;

import com.readlearncode.reactiveclient.BodyReaders.WeatherMessageBodyReader;
import com.readlearncode.reactiveclient.resource.Weather;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ReactiveClientWeather2Test {

    private WebTarget webTarget;

    @Before
    public void initClient() {
        webTarget = ClientBuilder.newClient()
                .register(WeatherMessageBodyReader.class)
                .target("https://www.metaweather.com/api/location/44418/");
    }

    @Test
    public void reactive() throws InterruptedException {

        CompletionStage<Response> stage = webTarget.request().rx().get()
                .exceptionally(throwable -> {
                    System.out.println("Error: " + throwable.getMessage());
                    return null;
                });

         stage.thenApply(response -> response.readEntity(Weather.class))
                .thenAccept(weather -> System.out.println(weather.getTime()));



        Thread.sleep(5000);

    }
}
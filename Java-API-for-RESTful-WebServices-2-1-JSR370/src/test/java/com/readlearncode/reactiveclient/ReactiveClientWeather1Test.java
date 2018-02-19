package com.readlearncode.reactiveclient;

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
public class ReactiveClientWeather1Test {

    private WebTarget webTarget;

    @Before
    public void initClient() {
        webTarget = ClientBuilder.newClient().target("https://www.metaweather.com/api/location/44418/");
    }

    @Test
    public void reactive() throws InterruptedException {
        CompletionStage<Response> stage = webTarget.request().rx().get();

        stage.thenApply(req -> req.readEntity(String.class))
                .thenAccept(System.out::println);

        Thread.sleep(3000);
    }
}
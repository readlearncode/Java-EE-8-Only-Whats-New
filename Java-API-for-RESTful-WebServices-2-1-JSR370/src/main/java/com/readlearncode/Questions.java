package com.readlearncode;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.sse.SseEventSink;
import java.util.concurrent.CompletionStage;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Questions {

    @Context
    private SseEventSink eventSink;

    public static void main(String... args) {

        /*
        1. What type is returned by the following call chain ClientBuilder.newClient().target("/").request().rx().get(String.class);
        */
        CompletionStage<String> completionStage = ClientBuilder.newClient().target("/").request().rx().get(String.class);

        /*
        2. Which of the following code snippets retrieves the SseEventSink instance?
        @Context SseEventSink eventSink;
        */


    }
}
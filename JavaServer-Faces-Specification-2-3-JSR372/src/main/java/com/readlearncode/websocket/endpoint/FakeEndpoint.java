package com.readlearncode.websocket.endpoint;


import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

public class FakeEndpoint extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig config) {
    }
}

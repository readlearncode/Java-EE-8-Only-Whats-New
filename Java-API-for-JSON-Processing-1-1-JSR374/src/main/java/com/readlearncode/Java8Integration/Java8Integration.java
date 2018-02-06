package com.readlearncode.Java8Integration;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.stream.JsonCollectors;
import java.io.StringReader;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Java8Integration {

    public static void main(String... args) {

        String jsonData = "{\"tags\":[\"JAX-RS\",\"JSF\",\"Security\",\"JSP\",\"EJB\",\"JMS\",\"Bean Validation\",\"Websocket\",\"JPA\"]}";
        JsonObject jsonObject = Json.createReader(new StringReader(jsonData)).readObject();

        JsonArray tags = jsonObject.getJsonArray("tags").stream()
                .filter(jsonValue -> ((JsonString) jsonValue).getString().startsWith("J"))
                .collect(JsonCollectors.toJsonArray());

        System.out.println(tags);

    }

}
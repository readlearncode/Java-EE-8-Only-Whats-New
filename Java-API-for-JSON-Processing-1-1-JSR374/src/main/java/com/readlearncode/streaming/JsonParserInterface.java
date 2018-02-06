package com.readlearncode.streaming;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonParserInterface {

    public static void main(String... args) throws FileNotFoundException {

        String jsonData = JsonParserInterface.class.getClassLoader().getResource("all-json-structure.json").getFile();
        JsonParser parser = Json.createParser(new FileReader(jsonData));

        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch (event) {
                case START_OBJECT:
                case END_OBJECT:
                case START_ARRAY:
                case END_ARRAY:
                case VALUE_FALSE:
                case VALUE_NULL:
                case VALUE_TRUE:
                    System.out.println(event.toString());
                    break;
                case KEY_NAME:
                    System.out.print(event.toString() + " " + parser.getString() + " - ");
                    break;
                case VALUE_STRING:
                case VALUE_NUMBER:
                    System.out.println(event.toString() + " " + parser.getString());
                    break;
            }
        }


    }
}
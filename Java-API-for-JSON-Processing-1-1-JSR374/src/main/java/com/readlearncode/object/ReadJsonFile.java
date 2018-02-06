package com.readlearncode.object;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ReadJsonFile {

    public static void main(String... args) throws FileNotFoundException {

        String jsonData = ReadJsonFile.class.getClassLoader().getResource("all-json-structure.json").getFile();

        JsonReader reader = Json.createReader(new FileReader(jsonData));
        JsonObject jsonObject = reader.readObject();

        System.out.println(jsonObject.get("title"));
        System.out.println(jsonObject.getJsonArray("chapters").get(1));
        System.out.println(jsonObject.getBoolean("released"));
    }

}
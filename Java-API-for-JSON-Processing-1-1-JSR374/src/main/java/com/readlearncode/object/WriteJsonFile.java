package com.readlearncode.object;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import java.io.*;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class WriteJsonFile {

    public static void main(String... args) throws IOException {

        String jsonData = WriteJsonFile.class.getClassLoader().getResource("all-json-structure.json").getFile();
        JsonReader reader = Json.createReader(new FileReader(jsonData));
        JsonObject jsonObject = reader.readObject();

        String resourceLocation = WriteJsonFile.class.getClassLoader().getResource("").getFile();
        FileWriter fileWriter = new FileWriter(resourceLocation + "out.json");
        JsonWriter jsonWriter = Json.createWriter(fileWriter);

        jsonWriter.writeObject(jsonObject);
        jsonWriter.close();
    }
}
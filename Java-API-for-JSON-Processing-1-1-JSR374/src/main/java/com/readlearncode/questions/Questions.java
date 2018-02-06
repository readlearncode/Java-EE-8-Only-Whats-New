package com.readlearncode.questions;

import com.readlearncode.object.ReadJsonFile;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPointer;
import javax.json.JsonValue;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Questions {

    public static void main(String... args) throws IOException {

        String jsonData = ReadJsonFile.class.getClassLoader().getResource("all-json-structure.json").getFile();
        JsonObject jsonObject = Json.createReader(new FileReader(jsonData)).readObject();

        /*
            {
              "title": "Java EE: Only What's New",
              "author": "Alex Theedom",
              "chapters": [
                "Chapter 1: Java EE 8 What’s New Overview",
                "Chapter 2: Java API for JSON Binding 1.0 (JSR 367)",
                "Chapter 3: Java EE Security API 1.0 (JSR 375)"
              ],
              "released": true,
              "pages": 300,
              "sourceCode": {
                "repositoryName": "Java-EE-8-Only-Whats-New",
                "url": "github.com/readlearncode/"
              },
              "otherBooks": [
                {
                  "title": "Professional Java EE Design Patterns",
                  "length": 350
                }
              ]
            }
         */

        JsonValue jsonValue;

        /* Q1. Which JSON Pointer expression retrieves the value of the 'author' key?

            1. /author
            2. author
            3. /author/
            4. \author
            5. \author\

            Answer: 1

         */
        jsonValue = Json.createPointer("/author").getValue(jsonObject);
        System.out.println(jsonValue);

        /* Q2. Which JSON Pointer expression retrieves the value of the 'length' key?

            1. /otherBooks/1/length
            2. otherBooks/0/length
            3. /otherBooks/length
            4. /otherBooks/0/length
            5. otherBooks/1/length

            Answer: 4
         */
        jsonValue = Json.createPointer("/otherBooks/0/length").getValue(jsonObject);
        System.out.println(jsonValue);



        /* Q3. Which JSON Pointer expression adds a value to the 'otherBooks' array

            1. /otherBooks/
            2. otherBooks/0/
            3. /otherBooks/0
            4. /otherBooks/1/
            5. otherBooks/1/

            Answer: 3
         */
        JsonPointer pointer = Json.createPointer("/otherBooks/0");
        Map<String, Object> h = new HashMap<String, Object>() {{
            put("title", "Fun with Java");
            put("length", 540);
        }};
        JsonObject newJsonObject = pointer.add(jsonObject, Json.createObjectBuilder(h).build());
        System.out.println(newJsonObject);



        /* Q4. Which of the following code snippets adds a new chapter to the `chapters` array?

            1. .insert("/chapters/3", "Chapter 4: Servlets 4.0")
            2. .add("Chapter 4: Servlets 4.0", "/chapters/3")
            3. .addElement("Chapter 4: Servlets 4.0", "/chapters/3")
            4. .add("/chapters/3").value("Chapter 4: Servlets 4.0")
            5. .add("/chapters/3", "Chapter 4: Servlets 4.0")

            Answer: 5
         */
        newJsonObject = Json.createPatchBuilder()
                .add("/chapters/3", "Chapter 4: Servlets 4.0")
                .build()
                .apply(jsonObject);
        System.out.println(newJsonObject);



        /* Q5. Which JSON document is the output of the following merge patch operation?

        Json.createMergePatch(Json.createValue("{\"speed\":\"fast\"}"))
            .apply(Json.createValue("{\"speed\":\"slow\"}"));

            1. {"speed":"slow"}
            2. {"fast":"speed"}
            3. {"speed":"fast"}
            4. {"slow":"speed"}
            5. throws an exception

            Answer: 3
         */
        jsonValue = Json.createMergePatch(Json.createValue("{\"speed\":\"fast\"}"))
                .apply(Json.createValue("{\"speed\":\"slow\"}"));

        System.out.println(jsonValue);



    }

}
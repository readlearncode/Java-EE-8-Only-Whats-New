package com.readlearncode.patch;

import com.readlearncode.object.ReadJsonFile;

import javax.json.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonPatchExamples {

    public static void main(String... args) throws FileNotFoundException {

        String jsonData = ReadJsonFile.class.getClassLoader().getResource("all-json-structure.json").getFile();
        JsonObject jsonObject = Json.createReader(new FileReader(jsonData)).readObject();

        // Replace a value
        JsonPatchBuilder builder = Json.createPatchBuilder();
        JsonPatch jsonPatch = builder.replace("/chapters/0", "Chapter 1: Introduction").build();
        JsonObject newJsonObject = jsonPatch.apply(jsonObject);
        System.out.println(newJsonObject);

        // Add and Remove values
        builder = Json.createPatchBuilder();
        jsonPatch = builder
                .add("/chapters/3", "Chapter 4: Servlets 4.0")
                .remove("/released")
                .build();
        newJsonObject = jsonPatch.apply(jsonObject);
        System.out.println(newJsonObject);

        newJsonObject = Json.createPatchBuilder()
                .add("/chapters/3", "Chapter 4: Servlets 4.0")
                .remove("/released")
                .build()
                .apply(jsonObject);
        System.out.println(newJsonObject);


        /*
            {
              "title": "Java EE: Only What's New",
              "author": "Alex Theedom",
              "chapters": [
                "Chapter 1: Java EE 8 What’s New Overview",
                "Chapter 2: Java API for JSON Binding 1.0 (JSR 367)",
                "Chapter 3: Java EE Security API 1.0 (JSR 375)",
                "Chapter 4: Servlets 4.0"
              ],
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

        // Move and copy values
        builder = Json.createPatchBuilder();
        jsonPatch = builder
                .move("/chapters/0", "/chapters/2") // destination, source
                .move("/chapters/2", "/chapters/1") // destination, source
                .copy("/otherBooks/0/length", "/pages") // destination, source
                .build();
        newJsonObject = jsonPatch.apply(jsonObject);
        System.out.println(newJsonObject);

        /*
            {
              "title": "Java EE: Only What's New",
              "author": "Alex Theedom",
              "chapters": [
                "Chapter 3: Java EE Security API 1.0 (JSR 375)",
                "Chapter 2: Java API for JSON Binding 1.0 (JSR 367)",
                "Chapter 1: Java EE 8 What’s New Overview"
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
                  "length": 300
                }
              ]
            }
         */

        // Test a value
        builder = Json.createPatchBuilder();
        jsonPatch = builder
                .test("/pages", 45345)
                .copy("/otherBooks/0/length", "/pages") // destination, source
                .build();
        newJsonObject = jsonPatch.apply(jsonObject);
        System.out.println(newJsonObject);


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
              "length": 300
            }
          ]
        }


     */


    }

}
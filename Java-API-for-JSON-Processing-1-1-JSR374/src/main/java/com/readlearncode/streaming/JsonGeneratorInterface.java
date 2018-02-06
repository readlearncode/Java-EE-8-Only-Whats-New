package com.readlearncode.streaming;

import javax.json.Json;
import javax.json.JsonValue;
import javax.json.stream.JsonGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class JsonGeneratorInterface {

    public static void main(String... args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(new File("all-json-structure.json"));

        JsonGenerator generator = Json.createGenerator(fileOutputStream);
        generator.writeStartObject()
                .write("title", "Java EE: Only What's New")
                .writeStartArray("chapters")
                .write("Chapter 1: Java EE 8 What’s New Overview")
                .write("Chapter 2: Java API for JSON Binding 1.0 (JSR 367)")
                .write("Chapter 3: Java EE Security API 1.0 (JSR 375)")
                .writeEnd()
                .write("released", JsonValue.TRUE)
                .write("length", 300)
                .writeStartObject("sourceCode")
                .write("repositoryName", "Java-EE-8-Only-Whats-New")
                .write("url", "github.com/readlearncode/")
                .writeEnd()
                .writeStartArray("otherBooks")
                .writeStartObject()
                .write("title", "Professional Java EE Design Patterns")
                .write("length", 350)
                .writeEnd()
                .writeEnd()
                .writeEnd();
        generator.close();

        // Flush and close file output streams
        fileOutputStream.flush();
        fileOutputStream.close();

    }


}
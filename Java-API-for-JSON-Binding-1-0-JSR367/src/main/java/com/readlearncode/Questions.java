package com.readlearncode;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;
import java.io.FileNotFoundException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Questions {

    public static void main(String... args) throws FileNotFoundException {


        JsonbConfig jsonbConfig = new JsonbConfig()
                .withPropertyNamingStrategy(
                        PropertyNamingStrategy.LOWER_CASE_WITH_DASHES)
                .withNullValues(true)
                .withFormatting(true);

        Jsonb jsonb = JsonbBuilder.create(jsonbConfig);



        /*

        `fromJson(new FileReader("book.json"), Book.class)`
        `fromJson("{}", String.class)`
        `fromJson(new FileInputStream("book.json"), Object.class)`
        `fromJson(new FileReader("book.json"))`
        `fromJson("{}", Book.class)`


        String json = "{\"author\":\"Alex Theedom\",\"id\":\"SHDUJ-4532\",\"title\":\"Fun with Java\"}";
        Book book = JsonbBuilder.create().fromJson(new FileReader("book.json"), Book.class);
        book = JsonbBuilder.create().fromJson("{}", String.class);
        book = JsonbBuilder.create().fromJson(new FileInputStream("book.json"), Object.class);
        book = JsonbBuilder.create().fromJson(new FileReader("book.json"));
        book = JsonbBuilder.create().fromJson("{}", Book.class);

        */

    }
}
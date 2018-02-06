package com.readlearncode.pointer;

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
public class JsonPointerExamples {

    public static void main(String... args) throws FileNotFoundException {

        String jsonData = ReadJsonFile.class.getClassLoader().getResource("all-json-structure.json").getFile();

        JsonObject jsonObject = Json.createReader(new FileReader(jsonData)).readObject();
        JsonPointer pointer;

        // Test if a value exists
        pointer = Json.createPointer("/doesNotExist");
        Boolean containsValue = pointer.containsValue(jsonObject);
        System.out.println(containsValue);

        // Retrieving Values

        // Retrieves the value of a key:value pair
        pointer = Json.createPointer("/title");
        JsonValue jsonValue = pointer.getValue(jsonObject);
        System.out.println(jsonValue);

        jsonValue = Json.createPointer("/title").getValue(jsonObject);

        // Retrieves the String value of a key:value pair
        pointer = Json.createPointer("/title");
        JsonString jsonString = (JsonString) pointer.getValue(jsonObject);
        System.out.println(jsonString.getString());

        // Retrieves the 2nd value of a Json array
        pointer = Json.createPointer("/chapters/1");
        jsonString = (JsonString) pointer.getValue(jsonObject);
        System.out.println(jsonString.getString());

        // Retrieves a boolean value
        pointer = Json.createPointer("/released");
        jsonValue = pointer.getValue(jsonObject);
        System.out.println(jsonValue);

        // Retrieves a number value
        pointer = Json.createPointer("/pages");
        JsonNumber jsonNumber = (JsonNumber) pointer.getValue(jsonObject);
        System.out.println(jsonNumber.intValue());

        // Retrieves a JSON object
        pointer = Json.createPointer("/sourceCode");
        JsonObject jsonObj = (JsonObject) pointer.getValue(jsonObject);
        System.out.println(jsonObj);

        // Retrieves a value of key in a JSON object
        pointer = Json.createPointer("/sourceCode/repositoryName");
        jsonString = (JsonString) pointer.getValue(jsonObject);
        System.out.println(jsonString.getString());

        // The equivalent of the above JSONPointer
        String string = jsonObject.getJsonObject("sourceCode").getString("repositoryName");
        System.out.println(string);

        // Retrieves a value from a JSON object in 1st element in an array
        pointer = Json.createPointer("/otherBooks/0/length");
        jsonNumber = (JsonNumber) pointer.getValue(jsonObject);
        System.out.println(jsonNumber.intValue());

        jsonNumber = (JsonNumber) Json.createPointer("/otherBooks/0/length").getValue(jsonObject);
        System.out.println(jsonNumber.intValue());

        jsonValue = Json.createPointer("/otherBooks/0/length").getValue(jsonObject);
        System.out.println(jsonValue);


        // Add values //

        // Add a key:value pair at the root
        // Adds "category": "Programming" to the root
        pointer = Json.createPointer("/category");
        JsonObject newJsonObject = pointer.add(jsonObject, Json.createValue("Programming"));
        System.out.println(newJsonObject);

        // Add a value to an array
        // Adds "Chapter 4: Servlet 4.0" into the 4th element in the array
        pointer = Json.createPointer("/chapters/3");
        newJsonObject = pointer.add(jsonObject, Json.createValue("Chapter 4: Servlet 4.0"));
        System.out.println(newJsonObject);

        // Add a JSON object to the root
        // Adds "ratings":{"stars":5,"score":10} to the root with name "ratings"
        pointer = Json.createPointer("/ratings");
        newJsonObject = pointer.add(jsonObject, Json.createObjectBuilder().add("stars", 5).add("score", 10).build());
        System.out.println(newJsonObject);

        // Add a JSON object to array
        // Adds {"title":"Fun with Java EE","length":"200"} to the object array
        pointer = Json.createPointer("/otherBooks/1");
        newJsonObject = pointer.add(jsonObject, Json.createObjectBuilder().add("title", "Fun with Java EE").add("length", "200").build());
        System.out.println(newJsonObject);

        // Remove values //

        // Remove the "title" key and value
        pointer = Json.createPointer("/title");
        JsonStructure jsonStructure = pointer.remove(jsonObject);
        System.out.println(jsonStructure);

        // Returns the transformed JSON after removal
        // JSON pointer expression is the same as for retrieval

        // ...

        // Remove the 2nd element of a Json array
        pointer = Json.createPointer("/chapters/1");
        jsonStructure = pointer.remove(jsonObject);
        System.out.println(jsonStructure);

        // Replace //
        // Replace the "title" value with "Java EE 8"
        pointer = Json.createPointer("/title");
        jsonStructure = pointer.replace(jsonObject, Json.createValue("Java EE 8"));
        System.out.println(jsonStructure);

        // Returns the transformed JSON after removal
        // JSON pointer expression is the same as for retrieval

        // Replace the 2nd element of a Json array
        pointer = Json.createPointer("/chapters/1");
        jsonStructure = pointer.replace(jsonObject, Json.createValue("Chapter 2: JSON Processing"));
        System.out.println(jsonStructure);

    }


}
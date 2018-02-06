package com.readlearncode.mergepatch;

import javax.json.Json;
import javax.json.JsonMergePatch;
import javax.json.JsonValue;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MergePatchRFC7396 {

    public static void main(String... args) {

        JsonValue source = Json.createValue("{\"title\":\"Goodbye!\",\"author\":{\"givenName\":\"John\",\"familyName\":\"Doe\"},\"tags\":[\"example\",\"sample\"],\"content\":\"This will be unchanged\"}");
        JsonValue patch = Json.createValue("{\"title\":\"Hello!\",\"phoneNumber\":\"+01-123-456-7890\",\"author\":{\"familyName\":null},\"tags\":[\"example\"]}");

        JsonMergePatch jsonMergePatch = Json.createMergePatch(patch);
        JsonValue jsonValue = jsonMergePatch.apply(source);
        System.out.println(jsonValue);

        /*

        {
          "title": "Hello!",
          "phoneNumber": "+01-123-456-7890",
          "author": {
            "familyName": null
          },
          "tags": [
            "example"
          ]
        }

        Should be:

       {
         "title": "Hello!",
         "author" : {
           "givenName" : "John"
         },
         "tags": [ "example" ],
         "content": "This will be unchanged",
         "phoneNumber": "+01-123-456-7890"
       }

         */

    }


}
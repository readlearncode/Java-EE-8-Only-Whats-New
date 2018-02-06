package com.readlearncode.mergepatch;

import javax.json.*;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class MergePatchExample {

    public static void main(String... args) {

        JsonValue source;
        JsonValue patch;
        JsonMergePatch jsonMergePatch;
        JsonValue jsonValue;

        // Change Value
        source = Json.createValue("{\"colour\":\"blue\"}");
        patch = Json.createValue("{\"colour\":\"red\"}");
        jsonMergePatch = Json.createMergePatch(patch);
        jsonValue = jsonMergePatch.apply(source);
        System.out.println(jsonValue);
        // Result {\"colour\":\"red\"}

        // Add Value
        source = Json.createValue("{\"colour\":\"blue\"}");
        patch = Json.createValue("{\"blue\":\"light\"}");
        jsonMergePatch = Json.createMergePatch(patch);
        jsonValue = jsonMergePatch.apply(source);
        System.out.println(jsonValue);
        // Result {\"blue\":\"light\"}

        // Delete Value
        source = Json.createValue("{\"colour\":\"blue\",\"key\":\"value\"}");
        patch = Json.createValue("{\"colour\":null}");
        jsonMergePatch = Json.createMergePatch(patch);
        jsonValue = jsonMergePatch.apply(source);
        System.out.println(jsonValue);
        // Result {\"colour\":null}


        // Merge Diff
        source = Json.createValue("{\"colour\":\"blue\"}");
        JsonValue target = Json.createValue("{\"colour\":\"red\"}");
        jsonMergePatch = Json.createMergeDiff(source, target);
        System.out.println(jsonMergePatch.toJsonValue());


        // Create Diff
        JsonStructure source1 = Json.createObjectBuilder().add("colour","blue").build();
        JsonStructure target1 = Json.createObjectBuilder().add("colour","red").build();
        JsonPatch jsonPatch = Json.createDiff(source1, target1);
        System.out.println(jsonPatch.toJsonArray());



    }


}
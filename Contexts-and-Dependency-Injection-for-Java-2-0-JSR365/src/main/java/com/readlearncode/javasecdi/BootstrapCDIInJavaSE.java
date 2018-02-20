package com.readlearncode.javasecdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class BootstrapCDIInJavaSE {

    public static void main(String... args) {
        try (SeContainer seContainer = SeContainerInitializer.newInstance().initialize()) {
            Greeting greeting = seContainer.select(Greeting.class).get();
            greeting.printMessage("Hello World");
        }

        SeContainer seContainer = SeContainerInitializer.newInstance().initialize();
        Greeting greeting = seContainer.select(Greeting.class).get();
        greeting.printMessage("Hello World");
        seContainer.close();

    }

}
package com.readlearncode.javasecdi;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Main {

    public static void main(String... args) {

        SeContainer seContainer = SeContainerInitializer.newInstance()
                .addPackages(true, Greeting.class)
                .disableDiscovery()
                .initialize();

       seContainer.close();

    }

}
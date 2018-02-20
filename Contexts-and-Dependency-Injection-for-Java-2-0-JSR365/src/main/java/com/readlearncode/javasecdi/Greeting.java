package com.readlearncode.javasecdi;

import javax.enterprise.context.control.ActivateRequestContext;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@ActivateRequestContext
public class Greeting {
    public void printMessage(String message) {
        System.out.println(message);
    }
}
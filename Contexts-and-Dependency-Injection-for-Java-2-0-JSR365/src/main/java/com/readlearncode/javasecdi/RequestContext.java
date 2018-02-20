package com.readlearncode.javasecdi;

import javax.enterprise.context.control.RequestContextController;
import javax.inject.Inject;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class RequestContext {

    @Inject
    private RequestContextController requestContextController;

    public void process(){
        requestContextController.activate();
        // do work
        requestContextController.deactivate();
    }

}
package com.readlearncode.pushbuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

/**
 * A simple POC use of the Server Push feature.
 * <p>
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebServlet("/duke")
public class SimplestExample2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {

        PushBuilder pushBuilder = request.newPushBuilder();
        pushBuilder.path("images/header.png").push();
        pushBuilder.path("css/menu.css").push();
        pushBuilder.path("js/ajax.js").push();

        // Do some processing and return JSP
        // that requires these resources
    }

}
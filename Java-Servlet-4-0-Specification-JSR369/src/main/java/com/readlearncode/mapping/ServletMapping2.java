package com.readlearncode.mapping;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebServlet({"/location/*", "*.ext"})
public class ServletMapping2 extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        HttpServletMapping mapping = request.getHttpServletMapping();
        String mappingName = mapping.getMappingMatch().name();
        String value = mapping.getMatchValue();
        String pattern = mapping.getPattern();
        String servletName = mapping.getServletName();
    }
}
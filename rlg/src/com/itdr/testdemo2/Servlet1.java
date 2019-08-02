package com.itdr.testdemo2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1",value = "/s1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        System.out.println(request.getRequestedSessionId());
        System.out.println(request.getRemoteUser());
        System.out.println(request.getQueryString());
        System.out.println(request.getPathTranslated());
        System.out.println(request.getPathInfo());
        System.out.println(request.getAuthType());
        System.out.println(request.getMethod());
        System.out.println(request.getContextPath());
    }
}

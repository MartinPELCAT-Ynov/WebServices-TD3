package com.example.j2ee.td3;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("user");
        request.setAttribute("userToGreet", user);
        getServletContext().getRequestDispatcher("/WEB-INF/helloservlet.jsp").forward(request, response);
    }

}
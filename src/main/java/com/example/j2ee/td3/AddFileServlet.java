package com.example.j2ee.td3;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/file/add")
@MultipartConfig()
public class AddFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/addFile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part file = req.getPart("file");
        Files.copy(file.getInputStream(),
                new File(getServletContext().getRealPath("/") + file.getSubmittedFileName())
                        .toPath());
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.sendRedirect("/file/add");
    }
}

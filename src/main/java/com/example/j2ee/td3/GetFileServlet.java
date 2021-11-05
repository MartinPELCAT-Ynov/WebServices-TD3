package com.example.j2ee.td3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/file/get")
public class GetFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");

        File file = new File(getServletContext().getRealPath("/") + fileName);

        boolean fileExist = Files.exists(file.toPath());
        if (!fileExist) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        String mimeType = Files.probeContentType(file.toPath());
        resp.setContentType(mimeType);
        resp.setContentLength((int) file.length());
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), resp.getOutputStream());
    }
}

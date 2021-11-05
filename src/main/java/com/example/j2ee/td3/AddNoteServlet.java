package com.example.j2ee.td3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/note/add")
public class AddNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String note = req.getParameter("note");
        List<String> notes = (List<String>) session.getAttribute("notes");
        if (notes == null) {
            notes = new ArrayList<>();
        }
        notes.add(note);

        session.setAttribute("notes", notes);
        resp.sendRedirect("/notes");
    }
}

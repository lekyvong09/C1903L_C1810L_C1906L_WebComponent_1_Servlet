package com.ray.citymanager.servlets;

import com.ray.citymanager.sessionlisteners.ActiveUserTracking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowActiveSessionCount", value = "/ShowActiveSessionCount")
public class ShowActiveSessionCount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int activeUsers = ActiveUserTracking.getActiveUsers();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Active users: " + activeUsers + "</h1>");
        out.println("</body></html>");
    }
}

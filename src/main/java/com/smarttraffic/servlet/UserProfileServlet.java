package com.smarttraffic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch user data from the database (using DAO)
        // User user = userDao.getUserById(userId);

        request.setAttribute("username", "John Doe"); // Placeholder data
        request.setAttribute("email", "john.doe@example.com");
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}

package com.example.smarttraffic.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Logic to save user to database (using DAO)
        // UserDAO userDao = new UserDAO();
        // userDao.save(new User(username, email, password));

        request.setAttribute("message", "User registered successfully!");
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}

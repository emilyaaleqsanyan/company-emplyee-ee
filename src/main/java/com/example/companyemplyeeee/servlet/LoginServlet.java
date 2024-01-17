package com.example.companyemplyeeee.servlet;


import com.example.companyemplyeeee.manager.UserManager;
import com.example.companyemplyeeee.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HomeServlet{


    private UserManager userManager = new UserManager();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User userByEmail = userManager.getUserByEmail(email);
        if(userByEmail != null && password.equals(userByEmail.getPassword())){
            req.getSession().setAttribute("user", userByEmail);
            req.getSession().setAttribute("user", userByEmail);
            resp.sendRedirect("/home");
        }else {
            req.getSession().setAttribute("msg", "invalid email or password");
            resp.sendRedirect("/");
        }
    }
}

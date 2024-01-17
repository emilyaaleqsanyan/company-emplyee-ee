package com.example.companyemplyeeee.servlet;

import com.example.companyemplyeeee.manager.EmployeeManager;
import com.example.companyemplyeeee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/employees")
public class EmployeesServlet extends HttpServlet {

    private EmployeeManager employeeManager = new EmployeeManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeManager.getAll();
        req.setAttribute("employees", employees);

        req.getRequestDispatcher("/WEB-INF/employees.jsp").forward(req, resp);
    }
}

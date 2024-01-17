package com.example.companyemplyeeee.servlet;

import com.example.companyemplyeeee.manager.CompanyManager;
import com.example.companyemplyeeee.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateCompany")
public class UpdateCompanyServlet extends HttpServlet {


    private CompanyManager companyManager = new CompanyManager();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Company company = companyManager.getCompanyById(id);
        req.setAttribute("company",company);
        req.getRequestDispatcher("/WEB-INF/updateCompany.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("companyId"));
        String companyName = req.getParameter("companyName");
        String companyAddress = req.getParameter("companyAddress");
        companyManager.update(Company.builder()
                        .id(id)
                        .name(companyName)
                        .address(companyAddress)
                .build());
        resp.sendRedirect("/companies");
    }
}

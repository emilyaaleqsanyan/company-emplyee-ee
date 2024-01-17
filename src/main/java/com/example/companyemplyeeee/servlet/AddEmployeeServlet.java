package com.example.companyemplyeeee.servlet;

import com.example.companyemplyeeee.manager.CompanyManager;
import com.example.companyemplyeeee.manager.EmployeeManager;
import com.example.companyemplyeeee.model.Company;
import com.example.companyemplyeeee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/addEmployee")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5, //5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024 * 1
)
public class AddEmployeeServlet extends HttpServlet {


    private final CompanyManager companyManager = new CompanyManager();
    private final EmployeeManager employeeManager = new EmployeeManager();
    private final String UPLOAD_DIRECTORY = "C:\\Users\\Lenovo\\ee\\company-emplyee-ee\\uploadDirectory";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = companyManager.getCompanies();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int companyId = Integer.parseInt(req.getParameter("companyId"));

        Part picture = req.getPart("picture");
        String pictureName = null;
        if (picture != null && picture.getSize() > 0) {
            pictureName = System.currentTimeMillis() + "_" + picture.getSubmittedFileName();
            picture.write(UPLOAD_DIRECTORY + File.separator + pictureName);

        }
        employeeManager.add(Employee.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .picName(pictureName)
                .company(companyManager.getCompanyById(companyId))
                .build());
        resp.sendRedirect("/employees");
    }
}

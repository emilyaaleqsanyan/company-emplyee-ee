<%@ page import="java.util.List" %>
<%@ page import="com.example.companyemplyeeee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11.01.2024
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<% List<Company> companies = (List<Company>) request.getAttribute("companies");%>

Add Employee <br>
<form method="post" action="/addEmployee" enctype="multipart/form-data">
    Name:<input type="text" name="name"><br>
    Surname:<input type="text" name="surname"><br>
    Email:<input type="text" name="email"><br>

    <select name="companyId">
        <%
            for (Company company : companies) { %>
        <option value="<%=company.getId()%>"><%=company.getName()%></option>
        <% }%>

    </select> <br>
    <input type="file" name="picture" d> <br>
    <input type="submit" value="add">
</form>
</body>
</html>

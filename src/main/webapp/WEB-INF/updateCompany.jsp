<%@ page import="com.example.companyemplyeeee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 15.01.2024
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Company</title>
</head>
<body>
<%Company company = (Company) request.getAttribute("company"); %>
Update Company <br>
<form method="post" action="updateCompany">
    <input type="hidden" name="companyId" value="<%=company.getId()%>" > <br>
    Company Name:<input type="text" name="companyName" value="<%=company.getName()%>"><br>
    Company Address:<input type="text" name="companyAddress" value="<%=company.getAddress()%>" ><br>
    <input type="submit" value="update">
</form>
</body>
</html>

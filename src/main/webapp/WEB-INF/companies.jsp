<%@ page import="java.util.List" %>
<%@ page import="com.example.companyemplyeeee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 08.01.2024
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Companies</title>
</head>
<body>

<%
    List<Company> companies = (List<Company>) request.getAttribute("companies");
%>


Companies | <a href="/addCompany">Add Company</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Delete</th>
        <th>Update</th>
    </tr>
    <%
        if (!companies.isEmpty()) {
            for (Company company : companies) { %>
    <tr>
        <td><%=company.getId()%></td>
        <td><a href="/singleCompany?id=<%=company.getId()%>"> <%=company.getName()%></a></td>
        <td><%=company.getAddress()%></td>
        <td><a href="/deleteCompany?id=<%=company.getId()%>">delete</a></td>
        <td><a href="/updateCompany?id=<%=company.getId()%>">update</a> </td>
    </tr>
    <% }
}
        %>

</table>
</body>
</html>

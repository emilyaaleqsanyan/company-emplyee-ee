<%@ page import="java.util.List" %>
<%@ page import="com.example.companyemplyeeee.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11.01.2024
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<%
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>

Employees | <a href="/addEmployee">Add Employee</a>

<%
    if (employees != null && !employees.isEmpty()) {%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Picture</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Company Name</th>
        <th>Company Address</th>
        <th>Delete</th>
    </tr>
    <%
        for (Employee employee : employees) { %>
    <tr>
        <td><%=employee.getId()%>
        </td>
        <td>
            <% if (employee.getPicName() != null) {%>
            <img src="/downloadImage?imageName=<%=employee.getPicName()%>" width="50"></img>
            <%} else {%>
            <span> No Picture</span>
            <%}%>
        </td>
        <td><%=employee.getName()%>
        </td>
        <td><%=employee.getSurname()%>
        </td>
        <td><%=employee.getEmail()%>
        </td>
        <td><%=employee.getCompany().getName()%>
        </td>
        <td><%=employee.getCompany().getAddress()%>
        </td>
        <td><a href="/deleteEmployee?id=<%=employee.getId()%>">delete</a></td>
    </tr>
    <%
        }
    %>
</table>
<%}%>
</body>
</html>

<%@ page import="com.education.User" %><%--
  Created by IntelliJ IDEA.
  User: sbiliaiev
  Date: 07.01.2022
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/users/update" method="post">

    <%
        User user = (User) request.getAttribute("user");
    %>

    <table>
        <tr>
            <td>
                <label for="id">ID</label>
            </td>
            <td>
                <input type="text" id="id" name="id" value="<%=user.getId()%>" disabled/>
            </td>
            <td>
                <label for="name">Name</label>
            </td>
            <td>
                <input type="text" id="name" name="name" value="<%=user.getName()%>"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="email">Email</label>
            </td>
            <td>
                <input type="text" id="email" name="email" value="<%=user.getEmail()%>"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Submit">
            </td>
            <td>
                <input type="reset" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

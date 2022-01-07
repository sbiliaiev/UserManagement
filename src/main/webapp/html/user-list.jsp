<%@ page import="com.education.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (User user : (List<User>) request.getAttribute("users")) {
    %>

    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td>
            <a href="/users/read?id=<%=user.getId()%>">Read</a>
        </td>
        <td>
            <a href="/users/update?id=<%=user.getId()%>">Update</a>
        </td>
        <td>
            <a href="/users/delete?id=<%=user.getId()%>">Delete</a>
        </td>
    </tr>

    <%
        }
    %>

</table>
</body>
</html>

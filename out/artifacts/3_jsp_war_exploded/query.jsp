<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String author = request.getParameter("author");
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test");
    PreparedStatement ps = connection.prepareStatement("SELECT title,press FROM test.books WHERE author=?");
    ps.setString(1, author);
    ResultSet rs = ps.executeQuery();
%>
<h1>The books written by <%=author%>></h1>
<hr>
<%
    if (!rs.wasNull()) {
%>
<table>
    <tr>
        <th>Title</th>
        <th>Press</th>
    </tr>
    <%}%>

    <%
        while (rs.next()) {
            String title = rs.getString("title");
            String press = rs.getString("press");
    %>
    <tr>
        <td><%=title%>
        </td>
        <td><%=press%>
        </td>
    </tr>

    <%}%>

</table>
</body>
</html>

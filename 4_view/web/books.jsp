<%@ page import="com.alpha.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    String author=request.getParameter("author");
%>
<h1>The books written by <%=author%></h1>
<hr>
<%
    if (!books.isEmpty()) {
%>
<table>
    <tr>
        <th>Title</th>
        <th>Press</th>
    </tr>
    <%}%>
    <%
        int size = books.size();
        for (int i = 0; i < size; i++) {
            Book book = books.get(i);
    %>
    <tr>
        <td><%=book.getTitle()%>
        </td>
        <td><%=book.getPress()%>
        </td>
    </tr>
    <%}%>

</table>
</body>
</html>

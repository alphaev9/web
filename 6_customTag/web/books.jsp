<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="alpha" uri="http://alpha.com" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>The books written by ${param.author}</h1>
<hr>

<alpha:myTable items="books" var="book" heads="heads">
    <tr>
        <td>${book.title}</td>
        <td>${book.press}</td>
    </tr>
</alpha:myTable>

</body>
</html>

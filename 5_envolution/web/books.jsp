<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<h1>The books written by ${param.author}</h1>
<hr>

<c:if test="${!books.isEmpty()}">
    <table>
        <tr>
            <th>Title</th>
            <th>Press</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.press}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>

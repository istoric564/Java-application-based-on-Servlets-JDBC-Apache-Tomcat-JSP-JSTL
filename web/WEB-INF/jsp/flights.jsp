<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 09.05.2021
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список перелетов</title>
</head>
<body>
<h1>Список перелетов: </h1>
<ul>
    <c:forEach var="flight" items="${requestScope.flights}">
        <li>
            <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">
                    ${flight.description}
            </a>
        </li>
    </c:forEach>
</ul>

</body>
</html>

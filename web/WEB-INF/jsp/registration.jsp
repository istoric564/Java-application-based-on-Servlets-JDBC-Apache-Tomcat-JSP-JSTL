<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 10.05.2021
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <label for="userId">Name:
        <input type="text" name="userName" id="userId">
    </label>
    <br>
    <label for="birthdayId">Birthday:
        <input type="date" name="birthday" id="birthdayId">
    </label>
    <br>
    <label for="emailId">Email:
        <input type="email" name="email" id="emailId">
    </label>
    <br>
    <label for="passwordId">Password:
        <input type="password" name="password" id="passwordId">
    </label>
    <br>
    <select name="role" id="roleId">
        <c:forEach var="role" items="${requestScope.roles}">
            <option value="${role}">${role}</option>
        </c:forEach>
    </select>
    <br>
    <c:forEach var="gender" items="${requestScope.gender}">
        <input type="radio" name="gender" value="${gender}"> ${gender}
        <br>
    </c:forEach>
    <button type="submit">Send</button>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: red">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
            </c:forEach>
        </div>
    </c:if>

</form>
</body>
</html>

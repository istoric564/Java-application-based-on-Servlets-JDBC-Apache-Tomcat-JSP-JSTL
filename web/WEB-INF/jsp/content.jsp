<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 09.05.2021
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="header.jsp" %>
<div>
    <span>Content. Русский</span>>
    <p>Size: ${requestScope.flight.size()}</p>
    <p>id: ${requestScope.flight.get(0).id}</p>
    <p>id2: ${requestScope.flight[1].id}</p>
    <p>Map id2: ${sessionScope.flightMap[1]}</p>
    <p>JSESSION ID: ${cookie["JSESSIONID"]}, unique identifier</p>
    <p>Header: ${header["cookie"]}</p>
    <p>Param id: ${param.id}</p>
    <p>Param test: ${param.test}</p>
</div>
<%@include file="footer.jsp" %>
</body>
</html>

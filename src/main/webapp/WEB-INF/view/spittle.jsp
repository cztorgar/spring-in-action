<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spittle <c:out value="${spittle.id}"/></title>
</head>
<body>
<div><c:out value="${spittle.message}"/></div>
<div>
    <span><c:out value="${spittle.time}"/></span>
    <span>(<c:out value="${spittle.latitude}"/>,
          <c:out value="${spittle.longitude}"/>)
    </span>
</div>
</body>
</html>

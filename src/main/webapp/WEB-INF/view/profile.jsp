<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spitter</title>
</head>
<body>
<div>Welcome <c:out value="${spitter.username}"/></div>
<div>
    <span><c:out value="${spitter.firstName}"/> <c:out value="${spitter.lastName}"/></span>
    <span><c:out value="${spitter.id}"/></span>
</div>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jai shree ram from access denied page</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>Jai shree ram from access denied page</h2>
<br>
<p>You do not have access to view this page</p>
<br>
<hr>
<a href="${contextPath}/security-system">Go Back to home page</a>
</body>
</html>
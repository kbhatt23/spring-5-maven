<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security System</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
jai shree ram from home page.

<br>

<!-- get do not work for logout only post works
hence adding form -->
<%-- <form:form action="${contextPath}/logout" method="post">
<input type="submit" value="logout">
</form:form> --%>
<hr>
User Name : <security:authentication property="principal.username"/>
<br>
User Role : <security:authentication property="principal.authorities"/>

<hr>
<br>
<security:authorize access="hasRole('MANAGER')">
	<!-- section only for managers -->
	<a href="${contextPath}/security-system/managers">Manager's Section</a>
	<br>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
	<a href="${contextPath}/security-system/admins">Administrator's Section</a>
	<br>
</security:authorize>

<form action="${contextPath}/logout" method="post">
<input type="submit" value="logout">
<!-- mannually adding csrf token otheriwse for normal form form will not authorize -->

<input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</body>
</html>
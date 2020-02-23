<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>jai shree ram from login page</title>
<style type="text/css">
	.errorDiv{
	 	color: red;
	}
</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
jai shree ram from login page
<br>
<form:form action="${contextPath}/validateUser" method="post">
<c:if test="${param.error != null}">
<i class="errorDiv">Invalid Username/Password</i>
<br>
</c:if>
<c:if test="${param.logout != null}">
<i>You have been succesfully logged out</i>
</c:if>
<p>
Username : <input type="text" name="username" id="username"></p>
 <br>
 <p>
Password : <input type="password" name="password" id="password"></p>
<br>
<input type="submit" value="validate">

</form:form>

</body>
</html>
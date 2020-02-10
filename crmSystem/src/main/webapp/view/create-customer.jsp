<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- importing form tag so that post data goesin body and not in param whihc 
happens in normal form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create CRM Customer</title>
</head>
<body>
jai shree ram from customer create page
<br>
Pleae fill below form:
<br>
<form:form action="saveCustomer" modelAttribute="customerAttribute" method="POST">

First Name : <form:input path="firstName"/>
<br>
Last Name : <form:input path="lastName"/>
<br>
Email : <form:input path="email"/>

<input type="submit" value="Save Customer">
</form:form>

</body>
</html>
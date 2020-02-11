<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update the custiomer below</title>
</head>
<body>

ja shree ram from update customer page
<br>

<form:form action="updateCustomer" method="POST" modelAttribute="customerAttribute">

<!-- this hidden proeprty calls getID on load and on submission calls setID
This maintains data not to be lost -->
<form:hidden path="id"/>
First Name : <form:input path="firstName"/>
<br>
Last Name : <form:input path="lastName"/>
<br>
Email : <form:input path="email"/>

<input type="submit" value="Update Customer">
</form:form>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
</head>
<body>
jai shree ram from customer list

<div id="search-box">
<!-- //using sinmple form -->
Search the customer: 
<form action="search" method="get">

<input type="text" id="searchString" name="searchString">
<input type="submit" value="search">
</form>

</div>
<br>
<br>
<div id="cusotomer-tables">
	<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<br>
		<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Update Customer</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customerList}">
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td><a href="showUpdateCustomer?customerId=${tempCustomer.id}">Update</a>
							|
							<a href="deleteCustomer?customerId=${tempCustomer.id}" 
							onclick="return confirm('Are you sure you want to delete this item?');"
							>Delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
</div>
</body>

</html>
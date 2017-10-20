<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person-Physcal list</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>
				<form action="PersonController">
					<input type="submit" name="btn_new" 
					value="New" />
				</form>
			</th>
			<th>ID</th>
			<th>Blood</th>
			<th>Height</th>
			<th>Weight</th>
		</tr>
		<c:forEach var="person" items="${persons}">
			<tr>
				<td>
					<form action="PersonController">
						<input type="hidden" name="id" value="${person.id}">
						<input type="submit" name="btn_edit"
						value="Edit" />
						<input type="submit" name="btn_delete"
						value="Delete" />
					</form>
				</td>
				<td>${person.id}</td>
				<td>${person.blood }</td>
				<td>${person.height }</td>
				<td>${person.weight }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
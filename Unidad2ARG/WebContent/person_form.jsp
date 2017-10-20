<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Form</title>
</head>
<body>
	<form action="PersonController">
		<label>Blood:</label><br />
		<input type="text" name="blood" value="${person.blood}" /><br />
		<label>Height:</label><br />
		<input type="text" name="height" value="${person.height}" /><br />
		<label>Weight:</label><br />
		<input type="text" name="weight" value="${person.weight}" /><br />
		<input type="submit" name="btn_save" value="Save" />
	</form>
</body>
</html>
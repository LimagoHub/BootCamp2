<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="form" class="de.forms.EingabeForm" scope="request"/>
	
	Hallo <jsp:getProperty property="name" name="form"/>
	
</body>
</html>
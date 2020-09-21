<%@page import="java.util.Date"%>
<html>
	<%Date date = new Date() ;%>
	<body>Hallo Tomcat. Heute ist der <% out.println(date.toString()); %></body>
	
	<form action="gruss" method="get" >
		Ihr Name <input type="text" name="name" /><br>
		<input type="submit" value="Drück mich">
	</form>
	
</html>
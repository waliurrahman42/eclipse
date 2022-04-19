<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>contact</title>
</head>
<body>
		<h1>this is contact page </h1>
		<p>wellcome </p>
		
		<% 
			String name=(String)request.getAttribute("name");
						String mob=(String)request.getAttribute("contact");
		%>
			<h1>name = <%=name %></h1>
			<h2>contact = <%=mob %></h2>
</body>
</html>
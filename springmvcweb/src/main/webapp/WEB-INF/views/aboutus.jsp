<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>about us</title>
</head>
<body>
	<h1>this is about us page </h1>
			<p>wellcome </p>
			
			
			<%
				List<String> getList=(List<String>) request.getAttribute("listtype");
				
					for(String s:getList)
					out.println(s);
			%>
			
</body>
</html>
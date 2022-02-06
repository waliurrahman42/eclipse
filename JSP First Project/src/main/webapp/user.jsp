<%@page import="dao.DbService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>

	<div style="width:100% height:500px;background-color:#b2eef7">
	<%
		int id=Integer.parseInt(request.getParameter("sid").trim());
		String pass=request.getParameter("spass");
		String name=request.getParameter("sname");
		String dept=request.getParameter("sdept");
		
		int i =DbService.inserData(id, name, pass, dept);
		if(i>0){%>
			<%="signup successfull" %>
	<%  }
		else{
			response.sendRedirect("login.jsp");
		}
	%>
	
	</div>
	
	
	
</body>
</html>
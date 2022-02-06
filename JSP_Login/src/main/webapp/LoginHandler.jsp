<%@page import="dao.LoginDao"%>
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
	
	<jsp:useBean id="LoginBean" class="mybeans.LoginBean" scope="session"/>
	<jsp:setProperty  name="LoginBean" property="*"/>
	
	<%
	
		String result=LoginDao.stdlogin(LoginBean);
		
		if(result.equals("true")){
			
			session.setAttribute("user", LoginBean.getName());
			session.setAttribute("pass", LoginBean.getPassword());
			response.sendRedirect("ViewStudent.jsp");
		}
		else{
			response.sendRedirect("index.jsp?status=false");
		}
	
	%>

</body>
</html>
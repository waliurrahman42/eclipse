
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
	<%
	int id=(int)(session.getAttribute("uid"));
	String name =request.getParameter("uname");
	String pass =request.getParameter("upass");
	String dept =request.getParameter("udept");
	int status =Integer.parseInt(request.getParameter("ustatus"));
	
	int res=DbService.updateData(id, name, pass, dept, status);
	if(res>0) {%>
		<jsp:forward page="ViewStudent.jsp" >  
			<jsp:param name="UpdMsg" value="Data Updated " />  
		</jsp:forward>  
	<%}
	else{%>
		<jsp:forward page="ViewStudent.jsp">  
			<jsp:param name="UpdMsgErr" value="Data Updated  failed" />  
		</jsp:forward>  
	<%}
	
	
	%>

</body>
</html>
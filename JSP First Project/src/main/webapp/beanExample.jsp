<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="studentObj" class="mybeans.Student" scope="application"/>
	<%
		String data=studentObj.studentDetails(1, "wali", "123", "cse");
		out.println(data);
	%>
</body>
</html>
<%@page import="java.sql.ResultSet"%>
<%@page import="state.StateDbservice"%>
<%@page import="mybeans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view user</title>
<style>
	table {
	  border-collapse: collapse;
	  width: 100%;
	}
	th{
		text-transform:uppercase;
	}
	th, td {
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #D6EEEE;
	}
	tr:hover {background-color: #f5c842;}
</style>
</head>
<body>
	<jsp:useBean id="userObj" class="mybeans.UserBean" scope="application"/>
	<jsp:setProperty  name="userObj" property="*"/>
	
	<%@include file="header.jsp" %>
	<div style="width:100%; height:500px;">
	<%
		int insert=StateDbservice.insertdata(userObj);
		
		if(insert!=0) {%>
			
			<h3 style="color:green;text-align: center;">data inserted</h3>
	<%	}
		else {%>
			<h3 style="color:red;text-align: center;">data insertion failed</h3>
		<%}
		
		
		ResultSet rs=StateDbservice.fetchUserDetail();
		if(rs!=null){%>
			<table>
				<tr>
					<th>FULL NAME</th>
					<th>USERNAME</th>
					<th>STATE</th>
					<th>CITY</th>
				</tr>
			<%while(rs.next()){%>
				<tr>
					<td><%=rs.getString(1) %></td>
					<td><%=rs.getString(2) %></td>
					<td><%=rs.getString(3) %></td>
					<td><%=rs.getString(4) %></td> 
				</tr>
		   <%}%>
		   </table>
	<%	}
	%>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>
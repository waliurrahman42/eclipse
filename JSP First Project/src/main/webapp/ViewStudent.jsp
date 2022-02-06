<%@page import="dao.DbService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<%
	if (request.getSession()!=null) {%>
	
		<%@include file="header.jsp" %>
		
		<%	
			String rmvMsg=(String)request.getAttribute("msg2");
			String UpdMsg=request.getParameter("UpdMsg");
			String UpdMsgErr=request.getParameter("UpdMsgErr");
			if(UpdMsg!=null){%>
				
				<h3 style="color:green;text-align: center;"><%=UpdMsg %></h3>
		<%	}
			if(UpdMsgErr!=null){%>
			
			<h3 style="color:red;text-align: center;"><%=UpdMsgErr %></h3>
	<%	}
			if(rmvMsg!=null){%>
				<h3 style="color:red;text-align: center;"> <%= rmvMsg %> </h3>
		<%	}%>
		
		
		<div style="width:100%; height:500px;">
		<table >
		<tr>
			<th>roll no</th>
			<th>student name</th>
			<th>student password</th>
			<th>student dept</th>
			<th>update student </th>
			<th>delete student </th>
		</tr>
		<%
			ResultSet rs=DbService.fetchData();
			while(rs.next()){
				
				int rno=rs.getInt(1);
				String n=rs.getString(2);
				String p=rs.getString(3);
				String d=rs.getString(4);%>
				
				<tr>
					<td><%=rno %></td>
					<td><%=n %></td>
					<td><%= p%></td>
					<td><%=d %></td>
					
					
					<td><a href="RemoveStudent?id=<%=rno %>">Delete</a></td>
					<td><a href="updateform.jsp?id=<%=rno %>">Update</a></td>
					
				</tr>
		<%	}
			%>
		
		
		
			
		
		
		
		
			</table>
		</div>
		<%@include file="footer.jsp" %>
		
	<%	}
	else{%>
		<jsp:forward page="login.jsp">  
			<jsp:param name="timedOutMsg" value="timed Out login again" />  
		</jsp:forward>  
	<%}
	%>
</body>
</html>
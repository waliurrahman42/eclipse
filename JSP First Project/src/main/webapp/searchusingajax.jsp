<%@page import="java.sql.ResultSet"%>
<%@page import="state.StateDbservice"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
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
				String name=request.getParameter("aname");
				String uname=request.getParameter("auname");
				String ustate=request.getParameter("astate");
				String ucity=request.getParameter("acity");
				
				out.print(name);
				out.print(uname);
				out.print(ustate);
				out.print(ucity);
				
				ResultSet rs=null;
				
				if(name!=null){
					 rs=StateDbservice.fetchUsingName(name);
				}
				if(uname!=null){
					 rs=StateDbservice.fetchUsingUserName(uname);
				}
				if(ustate!=null){
					 rs=StateDbservice.fetchUsingState(ustate);
				}
				if(ucity!=null){
					 rs=StateDbservice.fetchUsingCity(ucity);
				}
				if(ucity==null && uname==null && name==null && ustate==null){
					 rs=StateDbservice.fetchUserDetail();
				}
				
				
				if(rs!=null){
					out.print("<table>");
							out.print("<tr><th>FULL NAME</th><th>USERNAME</th><th>STATE</th><th>CITY</th></tr>");
						while(rs.next()){
								out.print("<tr><td>"+rs.getString(1)+" </td><td>"+rs.getString(2) +"</td><td>"+rs.getString(3)+ "</td><td>"+rs.getString(4)+" </td></tr>");					
											
					   }
					out.print("</table>");
				}
				
		%>
			
</body>
</html>
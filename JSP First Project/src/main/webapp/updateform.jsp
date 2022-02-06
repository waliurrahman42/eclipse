<%@page import="com.mysql.cj.Session"%>
<%@page import="dao.DbService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	form {
	    width:100%;
	    text-align:center;
	    top:25%; 
	}
	input[type=text] {
	  width: 50%; 
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	.selectoption{
	  width: 50%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  text-align:center;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	input[type=password]{
	  width: 50%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	}
	input[type=submit] {
	  width: 20%;
	  background-color: #4CAF50;
	  color: white;
	  padding: 14px 20px;
	  margin: 8px 0;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	
	input[type=submit]:hover {
	  background-color: #45a049;
	}
	
</style>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div >
	<% 	int id =Integer.parseInt(request.getParameter("id")) ;
		session.setAttribute("uid", id);

		ResultSet rs=DbService.searchByid(id);
		
		while(rs.next()){%>
		<h2 style="text-align: center; color:blue">UPDATING ID <%=rs.getString(1)%></h2>
		<form action="updateProfile.jsp" method="post">
			 
			user name: <input type="text" name="uname" value="<%=rs.getString(2)%>"><br/>
			user password : <input type="password" name="upass"  value="<%=rs.getString(3)%>"><br/>
			<div class="selectoption" >
				user department :	<select id="udept" name="udept"  class="form-control" Style="">
	                                            <option value="<%=rs.getString(4)%>"><%=rs.getString(4)%></option>
	                                            <option value="cs">cs</option>
	                                            <option value="it">it</option>
	                                            <option value="eee">eee</option>
	                                            <option value="me">me</option>
	                                    </select>
			</div>
			<br/>user status : <input type="text" name="ustatus"  value="<%=rs.getString(5)%>"><br/>
					
						<input type="submit" value="update">
		</form>
	<%}
		%>
	</div>	
	<%@include file="footer.jsp" %>	
</body>
</html>
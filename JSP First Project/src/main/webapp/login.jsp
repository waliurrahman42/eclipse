<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	input[type=text]{
	  width: 50%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
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
	#form {
	    
	    width:100%;
	    text-align:center;
	    top:25%; 
	}
</style>
</head>
<body>
	
	<%@include file="header.jsp" %>

	<div id="form">

	<%! %>
	
	<%
			String username="",password="";
			Cookie[] cookies = request.getCookies(); 
	
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals("username")) {
					username = c.getValue();
				}
				if (c.getName().equals("password")) {
					password = c.getValue();
				}
			}
	%>
	
		<form method="post" action="LoginServlet">
			user name : <input type="text" name="user" value="<%=username %>" ></br>
			password : 	<input type="password" name="pass" value="<%=password%>" ></br>
			<input type="checkbox"  name="remember"> Remember me</br>
						<input type="submit" value="login"></br>
		</form>
	
	<%
		String timedOutMsg=(String)request.getAttribute("timedOutMsg");
		String msgLgt=(String)request.getAttribute("msgLgt");
		String message=(String)request.getAttribute("msg");
		if(timedOutMsg!=null){%>
			<h3 style="color:red"><%=timedOutMsg %></h3>
	<%	}
		if(msgLgt!=null){%>
			<h3 style="color:red"><%=msgLgt %></h3>
	<%	}
		if(message!=null){%>
			<h3 style="color:red"><%=message %></h3>
	<%	}
	    %>
	
	</div>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>
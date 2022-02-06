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
        String uname=(String)session.getAttribute("user");
        
        //redirect user to home page if already logged in
        if(uname!=null){
            response.sendRedirect("ViewStudent.jsp");
        }
        
        String status=request.getParameter("status");
        
        if(status!=null){
         if(status.equals("false")){
            out.print("Incorrect login details!");           
         }
        }
        %>

	<form  action="LoginHandler.jsp">
			user name : <input type="text" name="name"  ></br>
			password : 	<input type="password" name="password"  ></br>
			<input type="checkbox"  name="remember"> Remember me</br>
			<input type="submit" value="login"></br>
	</form>

</body>
</html>
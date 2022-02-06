<%@page import="java.sql.ResultSet"%>
<%@page import="state.StateDbservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		span{
		 color:red;
		}
		
	</style>
	<script type="text/javascript">
		
		function city(){
			 var ajax=new XMLHttpRequest();
			 var id=document.getElementById("ddlState").value;
			 var url="AjaxservletForCity?state="+id;
			
			 ajax.onreadystatechange=function(){
				 if(ajax.readyState==4){   
					 document.getElementById("ddlCity").innerHTML=ajax.responseText;
				 }
			 }; 
			 ajax.open("Post",url,true);
			 ajax.send(null);    	
		}
		
		function reset_err(){
			document.getElementById("cpss_err").innerText = ""
			document.getElementById("name_err").innerText=""
		}
		
		function pswdConfirm(){
			var pass=document.getElementById("pass").value;
			var cpass=document.getElementById("cpass").value;
			if(pass!=cpass){
				document.getElementById("cpss_err").innerText="Password not matched"
			}
		}
		
		function namevalid(){
			var name=document.getElementById("name").value;
			if(isNaN(name)==false){
				document.getElementById("name_err").innerText="enter vaild name"
			}
		}

		     
	</script>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<form method="get" action="userSignupFrom.jsp">
		
		Name : <input type="text" name="fullname" id="name" required onblur="namevalid()" oninput="reset_err()"> 
		<span id="name_err"></span></br>
		User Name : <input type="text" name="username" required></br> 
		Password : <input type="password" name="password" id="pass" required></br>
		Confirm Password : <input type="password" name="cpass" id="cpass" onblur="pswdConfirm()" oninput="reset_err() " required>
		<span id="cpss_err" ></span>
		
		 
			</br>State :<select	name="ddlState" id="ddlState" onchange="city()">
							<option value="-1">--Select State</option>
						   	<%  ResultSet rs=StateDbservice.fetchStateData();
								while(rs.next()){ %>
									<option value=<%=rs.getString(1)%>><%= rs.getString(2)%></option>
							<%	}%>
					    </select> 
			 City : <select name="ddlCity" id="ddlCity">
							 <option value="-1">---Select City---</option>
					</select>
		
		 
		 </br><input type="submit" value="submit"></br>
		 
	</form>
	<%@include file="footer.jsp" %>
</body>
</html>
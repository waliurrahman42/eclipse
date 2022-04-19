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
	<script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>
	<script type="text/javascript">
	
	var inpname="";
	var inpuname="";
	var inpstate="";
	var inpcity="";
	
	

			function search(){
				var ajax=new XMLHttpRequest();
				
				inpname=document.getElementById("name").value;
				inpuname=document.getElementById("username").value;
				inpstate=document.getElementById("state").value;
				inpcity=document.getElementById("city").value;
				//var url="searchusingajax.jsp?aname="+inpname+"&auname="+inpuname+"&astate="+inpstate+"&acity="+inpcity;
				if(inpname!=""){var url="searchusingajax.jsp?aname="+inpname;}
				if(inpuname!=""){var url="searchusingajax.jsp?auname="+inpuname;}
				if(inpstate!=""){var url="searchusingajax.jsp?astate="+inpstate;}
				if(inpcity!=""){var url="searchusingajax.jsp?acity="+inpcity;}
				if(inpcity==""  &&  inpstate=="" && inpuname=="" && inpname=="") { var url="searchusingajax.jsp";}
				ajax.onreadystatechange=function(){
					 if(ajax.readyState==4){ 
						 document.getElementById("trajax").innerHTML=ajax.responseText;
					 }
				 }; 
				 ajax.open("Post",url,true);
				 ajax.send(null);    	
			}
		 
	</script>
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
	#searchform{
		 width:100%;
		    text-align:center;
		    top:25%; 
	}
		input[type=text] {
		  width: 24%; 
		  padding: 12px 20px;
		  margin: 8px 0;
		  border: 1px solid #ccc;
		  border-radius: 4px;
		  box-sizing: border-box;
		}
		
		
		
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
	%>
	<div id="searchform">
				<input type="text" name="fullname" id="name"  onkeyup="search() " placeholder=" Search by name"> 
				<input type="text" name="username"  id="username" placeholder=" Search by username" onkeyup="search()"> 
				<input type="text" name="state"  id="state" placeholder=" Search by state" onkeyup="search()">		
			    <input type="text" name="city" id="city" placeholder=" Search by city" onkeyup="search()">		 
	</div>
	<span id="trajax"></span>
	
	
	
	</div>
	
			
	
	
	<%@include file="footer.jsp" %>
	
</body>
</html>
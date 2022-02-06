<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h1> Hello JSP </h1>
  <ul>
    <li>Faster Deployment</li>
    <li>Easy To Maintain</li>
    <li>Extension Of Servlet</li>
    
    <%! int i =10; %>
  
    
    <%
       if(i%2==0){ 
       
     %>
    	<h1>  <%="even" %>  </h1>
      <%  }
      else{ 
    	  
        %>
    	   <%="odd" %>
      <% 
      }  
      %>
    
   
    
   
   
   </ul>
   
  <h2>prime number</h2>
  <%! int x, y, count=0; %>
  
  <% for(x=2;x<=100;x++){ 
	  for(y=1;y<=x;y++){
		  if(x%y==0){
			  count++;
		  }
		  if(count==2){%>
			  <%=x %>
		   <%  count=0;
		  }
	} 
  }%>
  
  
  
  


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%> 
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% String name=(String)request.getAttribute("name"); 
		String email=(String)request.getAttribute("email");
	
	%>
<%--	
	name:<%=name %>	</br>
	email: <%=email %>	   --%>
	
	hello
	name: ${name }
	email: ${email }	
   
    ${name eq email }
    
    
    
    <c:set var="x" value="10"/>
 	
 	<c:if test="${x>=10 }">
 	
 		<h4>
 			<c:out value ="value of x is ${x}"></c:out>
 		</h4>	
 		</h4>
 	
 	 </c:if> 
 	 
 	 
 	 <c:forEach begin="1" end="10" step="2" var="i">
 	 	<c:out  value="${ i}"/>   </br> 
 	 </c:forEach>
 	 
 	 
 	 
 	 <c:set value="12" var="age"/>
 	 <c:choose>
 	 	<c:when test="${age>=18 }">
 	 		<c:out value="u can vote"></c:out>
 	 	</c:when>
 	 	
 	 	<c:when test="${age<18 }">
 	 		<c:out value="nandan bakal"></c:out>
 	 	</c:when>
 	 	<c:otherwise>
 	 		<c:out value="you are in other universe"></c:out>
 	 	</c:otherwise>
 	 
 	 </c:choose>
 	 
 	 
 	 
 	 <c:set var="name" value="jetha laal"/>
	<c:set var="Lname" value="motwani"/>
	<c:if test="${fn:endsWith(name,'laal') }">		<br>
			<c:out value="end with mo"></c:out>		<br>
			${fn:length(name)}						<br>
	</c:if> 
	
		<c:set var="tax" value="30000.6789"/>
		<fmt:parseNumber integerOnly="true" type="number" value="${tax}" var="t"></fmt:parseNumber>	 
 	 	tax is ${t}	<br>
 	 
 	 <c:set var="tdate" value="02-09-2022"></c:set>	
 	 <fmt:parseDate value="${tdate }" var="parseddate" pattern="dd-mm-yyyy"/>
 	 Date is ${parseddate}<br>
 	 
 	 
 	 <c:set var="today" value="<%=new Date() %>" ></c:set>
 	 <fmt:formatDate value="${today}" type="time" var="tt"/>
 	 <fmt:formatDate value="${today}" type="date" var="dt"/>
 	 <fmt:formatDate value="${today}" type="time" var="stt" timeStyle="short"/>
 	 <fmt:formatDate value="${today}" type="date" var="mtt" dateStyle="medium"/>
 	 <fmt:formatDate value="${today}" type="both" var="ndt" dateStyle="short" timeStyle="medium"/> 
   		
 	 <br>
 	   time is  ${tt}  <br>
	   date is  ${dt}  <br>
	   short time is   ${stt} <br>
	   medium date is  ${mtt}     <br>
	   date and time both is ${ndt}  <br>
 	 
 	  
 	 
</body>
</html>
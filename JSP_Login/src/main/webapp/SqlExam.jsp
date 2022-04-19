<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

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

	<sql:setDataSource var="con" driver="com.mysql.cj.jdbc.Driver"
   url="jdbc:mysql://localhost:3306/cdac"
   user="root"
   password="Waliur#12"/>
   

 
   <c:if test="${con==null}">
     <c:out value="connection done"></c:out>
     
      <sql:update dataSource="${con }" sql="insert into student values(524,'xyz','1234','cs',1)" var="i"></sql:update>
       	<c:if test="${i>0}">
         	<c:out value="data is inserted done"></c:out>
      	</c:if> 
   </c:if>
   
   <sql:update dataSource="${con }" var="i" sql="update student set sname='abcd', spass='123', sdept='eee', status=0  WHERE sid=890"></sql:update>
   		<c:if test="${i>0}">
         	<c:out value="data is updated done"></c:out>
         	<c:remove var="i"/>
      	</c:if>
      	
      	
      	
      	
      	</br>
      	 
   <sql:update dataSource="${con}"  var="i" sql="DELETE FROM student where sid=43424"></sql:update>
   		<c:if test="${i>0}">
         	<c:out value="data is deleted"></c:out>
         	<c:remove var="i"/>
      	</c:if>
   
   
   
   
   
   
   
   
     <sql:query var="rs" dataSource="${con}" sql="select * from student"></sql:query>
     	<div>
     	<table >
     					<tr>
     						<th>id</th><th>name</th><th>dept</th>
     					</tr>
     			
		     <c:forEach var="row" items="${rs.rows}">
		        	<tr>
		        		<td><c:out value="${row.sid}"/></td>
		        		<td><c:out value="${row.sname}"/></td>
		        		<td><c:out value="${row.sdept}"/></td>
		        	</tr>
		     </c:forEach>
	     </table>
	     </div>

</body>
</html>
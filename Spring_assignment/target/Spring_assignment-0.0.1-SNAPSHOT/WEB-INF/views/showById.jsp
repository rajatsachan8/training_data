<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show By ID</title>
<style>
table {
    width:25%;
    display: inline;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
</head>
<body>
	
<c:if test="${not empty user}">
<h1> User Available</h1>
<table id="t01">

  <tr>
    <th>Employee Data</th>
    
  </tr>
  <c:forEach var="useridValue" items="${user}">
  <tr>
   <td>${useridValue}</td>
  </tr>
</c:forEach>
</table>
	</c:if>
 <c:if test="${empty user }">
     <h1>User Not found!!</h1>
 </c:if>
	
</body>
</html>
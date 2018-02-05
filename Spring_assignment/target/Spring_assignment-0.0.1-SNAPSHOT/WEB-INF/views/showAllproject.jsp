<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Project</title>
</head>
<body>
<h1>All Project Available</h1>
<c:if test="${not empty projectname}">
<h2>
    <ul>
			<c:forEach var="listValue" items="${projectname}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>
</h2>
		

	</c:if>

</body>
</html>
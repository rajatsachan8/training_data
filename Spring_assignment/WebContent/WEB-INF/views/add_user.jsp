 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add User</title>
<style>
   .header{
   text-align:center;
   }
   .abc{
   padding-left:200px;
   }
  
</style>

</head>
<body>
	<div class="row">
	<div class="col-sm-12 header">
		<h1>Add User</h1>
	</div>
	<br>
	<div class="row">
		<div class="col-sm-12 header"><h4>Enter the User Details</h4></div>
	</div>
	<br>
	
	<form action="register" method="get" >
<div class="row">
	<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">ID:</div>
	<div class="col-sm-5"><input type="text" name="id" required >${msg1}</div>
</div>	
<br>
<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">UserName:</div>
	<div class="col-sm-5"><input type="text" name="username" id="name" required>${msg2 }</div>
</div>
<br>
	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Password:</div>
	<div class="col-sm-5"><input type="password" name="password" required></div>
</div>
<br>
     	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Date of Joining:</div>
	<div class="col-sm-5"><input type="date" name="doj" required></div>
</div>
<br>
     	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Email:</div>
	<div class="col-sm-5"><input type="email" name="email" required></div>
</div>
<br>
     	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Role:</div>
	<div class="col-sm-5"><input type="text" name="role" required></div>
</div>
<br>
     	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Project ID:</div>
	<div class="col-sm-5"><input type="text" name="projectid" required></div>
</div>
<br>
<div class="row">
   <div class="col-sm-6"></div>
   <div class="col-sm-6"><input type="submit" onclick="run()" Value="Add User"></div>

</div>
   </form>
</div>	

</body>
</html>

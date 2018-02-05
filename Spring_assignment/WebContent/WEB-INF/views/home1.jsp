<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login</title>
<style>
.header {
    color:white;
    height:50px;
    background-color:#283593;
    border:1px solid #CCC;
    width:100%;
    margin:0px auto;
    text-align: center;
    height:120px;
    padding: 20px;
    text-transform: uppercase;
}
body{
    background-color:#fafafa;
}
h2{
text-align:center;
}
</style>
<script>
function myFunction() {
    document.getElementById("myForm").reset();
}
</script>
</head>
<body>
	
<div class="row">
          <div class="col-sm-12 header">
              <h1>Welcome To Trainee Project Allocation System</h1>
            </div>
      </div>
     <h2>${message}</h2>
  <div class="row">
  	   <form action="admin" method="post" id="myForm">
  	   <div class="row">
  	       <div class="col-sm-4"></div>
  	   		<div class="col-sm-2">
  	   		     <h4><b>User ID:</b></h4>
  	   		</div>
  	   		<div class="col-sm-6">
  	   		    <input type="text" name="userName"><br>
  	   		</div>
  	   		</div>
  	   		<div class="row">
  	   		<div class="col-sm-4"></div>
  	   		<div class="col-sm-2">
  	   		     <h4><b>Password:</b></h4>
  	   		</div>
  	   		<div class="col-sm-6">
  	   		    <input type="password" name="password"><br>
  	   		</div>
  	   		</div>
  	   		  <div class="row">
  	   		  <div class="col-sm-5"></div>
  	   		  <div class="col-sm-1">
  	   		        <input type="submit" value="Login">
  	   		  </div>
  	   		  <div class="col-sm-6">
  	   		  			<input type="button" onclick="myFunction()" value="Clear">
  	   		  </div>
  	   		  </div> 
  	   		
  	   
	</form>
  </div>
  
	
		
</body>
</html>
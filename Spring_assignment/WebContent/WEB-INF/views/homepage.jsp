<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Project Allocation</title>
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
.admincss{
	padding-top:150px;
	padding-left:400px;
}
.usercss{
padding-top:150px;
}
</style>

</head>
<body>
<div class="row">
          <div class="col-sm-12 header">
              <h1>Welcome To Trainee Project Allocation System</h1>
            </div>
      </div>
  <div class="row">
      <div class="col-sm-6 admincss">
         <h2>Admin Access</h2>
          <form action="home1" method="post" name="ref1">
	 <input type="submit" value="Admin" name="hello" >
	</form>
      </div>
      <div class="col-sm-6 usercss">
         <h2>User Access</h2>
          <form action="home2" method="post" name="ref2">
	 <input type="submit" value="User" name="hello">
	</form>
      </div>
      </div>
      
</body>
</html>
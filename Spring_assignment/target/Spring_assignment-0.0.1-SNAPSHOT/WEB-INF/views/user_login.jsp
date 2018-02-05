<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User Home Page</title>
<style>
     .header {
    color:black;
    height:50px;
    background-color:white;
    border:1px solid #CCC;
    width:100%;
    margin:0px auto;
    text-align: center;
    height:120px;
    padding-right:155px;
    padding-top:25px;
    text-transform: uppercase;
}
body {
    background-color:#fafafa;
}
.shift{
padding-left:110px;
}
</style>
</head>
<body>
<h3>Hi ${userName}</h3>
<h4> ${msg} </h4>
<div class="row">
	<div class="col-sm-12 header">
		<h1>User Page</h1>
	</div>
</div>
     <div class="row shift">
     	<div class="col-sm-4"></div>
     	<div class="col-sm-8"><h3><a href="change_password">Change Password</a></h3></div>
     </div>

      <div class="row shift">
     	<div class="col-sm-4"></div>
     	<div class="col-sm-8"><h3><a href="view_all_projects">View All Project</a></h3></div>
     </div>
     <div class="row shift">
     	<div class="col-sm-4"></div>
     	<div class="col-sm-8"><h3><a href="">View Team Members</a></h3></div>
     </div>
     
</body>
</html>
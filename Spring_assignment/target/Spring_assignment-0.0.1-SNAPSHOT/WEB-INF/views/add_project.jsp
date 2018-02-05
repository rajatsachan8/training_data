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
<title>Add Project</title>
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
		<h1>Add Project</h1>
	</div>
	<br>
	<div class="row">
		<div class="col-sm-12 header"><h4>Enter the Project Details</h4></div>
	</div>
	<br>
	<form action="project" method="post" >
<div class="row">
	<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Project ID :</div>
	<div class="col-sm-5"><input type="text" name="pid" ></div>
</div>	
<br>
<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Project Name :</div>
	<div class="col-sm-5"><input type="text" name="p_name"></div>
</div>
<br>
	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Description :</div>
	<div class="col-sm-5"><input type="text" name="description"></div>
</div>
<br>
     	<div class="row">
		<div class="col-sm-3">	</div>
	<div class="col-sm-4 abc">Estimated Work Hours :</div>
	<div class="col-sm-5"><input type="text" name="estimated_time"></div>
</div>
<br>
     	
<div class="row">
   <div class="col-sm-6"></div>
   <div class="col-sm-6"><input type="submit" Value="Add Project"></div>

</div>
   </form>
</div>	
 		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    background-image: url("images/apple-orchards.jpg");
}
.detail{
background-color:#fafafa;
}
.select{
padding-left:100px;
}
.button1{
padding-left:100px;
}
.detail{
padding-top:10px;
}
</style> 
<title>Mindtree Orchard</title>
</head>
<body>
 <div class="row">
          <div class="col-sm-12 header">
              <h1><b>Mindtree Orchard</b></h1>
            </div>
          </div>
  <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-3 detail">
      			<form method="post" action="ViewDetails">
               <div class="row">
               		<div class="col-sm-3 ">User Name</div>
               		<div class="col-sm-9 select"><input type="text" name="username"></div>
               </div>
               <br>
                <div class="row">
               		<div class="col-sm-3 ">Password</div>
               		<div class="col-sm-9 select"><input type="password" name="password"></div>
               </div>
               <br>
               <div class="row">
               		<div class="col-sm-3 ">Designation</div>
               		<div class="col-sm-9 select"><select name="designation">
               		                        <option value="Trainee">Trainee</option>
               		                        <option value="Admin">Admin</option>
               		                        </select>
               		</div>
               </div>
               <br>
               <div class="row">
  <div class="col-sm-6 button1"><button type="submit" value="Submit">Submit</button></div>
  <div class="col-sm-6 button2"><a href="index.html"><button type="button">Cancel</button></a></div>
     *All the fields are mandatory
  </div>
        
</form>
      </div>
      <div class="col-sm-5"></div>
  </div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Enter Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
    .header {
    color:white;
    background-color:#ec407a;
    border:1px solid #CCC;
    text-align: center;
    height:120px;
    padding: 20px;
    text-transform: uppercase;
}
body{
    background-color:#f5f5f5;
}
.name{
text-align:center;
}
.select{
padding-top:10px;
}
</style>
</head>
<body>
 <% ServletContext context=getServletContext();%>
 <div class="row">
   <div class="col-sm-12 header">
    	<h1>Personal Details</h1>
   </div>
 </div>
 <div class="row">
    <div class="col-sm-12 name">
         <h2> Hi
           <%=(String)context.getAttribute("firstName")%>
         </h2>
         <h4>We need some additional details about you.</h4>
    </div>
 </div>
 <br>
 <div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-5 detail">
  <form method="post" action="Details">
  <div class="row">
  <div class="col-sm-3"><h4>Mindtree ID :</h4> </div>
  <div class="col-sm-9 select"><input type="text" name="mindtreeid" required /></div>
  </div>
  <div class="row">
   <div class="col-sm-3"><h4>Age : </h4> </div>
  <div class="col-sm-9 select"><input type="number" name="age" min=1 max=50 required /> </div>
  </div>
     <div class="row">
   <div class="col-sm-3"><h4>City : </h4> </div>
  <div class="col-sm-9 select"><input type="text" name="city" required/> </div>
  </div>
      <div class="row">
      	<div class="col-sm-3"><h4>Batch</h4></div>
      	<div class="col-sm-9 select"><select name="batch" required>
      	                        
      	                        <option value="AEM">AEM</option> 
      	                        <option value="EAI&BPM">EAI & BPM</option>
      	                        <option value="DataAnalytics">Data Analysis</option>
      	                        <option value="SAP">SAP</option> 
      	                        <option value="SiteCore">SiteCore</option>
      	                        <option value="java">Java</option>
      	                        <option value="SDET">SDET</option> 
      	                          </select>   </div>
      </div>
      <br>
    <div class="row">
  <div class="col-sm-3 button1"><button type="submit" value="next">Next</button></div>
  <div class="col-sm-9 button2"><a href="index.html"><button type="button">Cancel</button></a></div>
     *All the fields are mandatory
  </div>
        </form></div>
   <div class="col-sm-3">     
</div></div>
</body>
</html>
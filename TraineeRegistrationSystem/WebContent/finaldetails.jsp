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
<title>Final Details</title>
<style>
    .header {
    color:white;
    background-color:#e65100;
    border:1px solid #CCC;
    text-align: center;
    height:120px;
    padding: 20px;
    text-transform: uppercase;
}
body{
    background-color:#f5f5f5;
}
.ins{
text-align:center;
}
p {
    display: inline;
    
}
</style>
<script>
function hello(){
	var name=document.getElementById("name").innerHTML;
	alert("The trainee "+name+" has been registered successfully");
}
</script>
</head>
<body>
       <% ServletContext context=getServletContext();%>
        <div class="row header">
    <div class="col-sm-12 name">
         <h2> Hello
           <%=(String)context.getAttribute("firstName")%>
         </h2></div>
    </div>
     <div class="row ins">
    <div class="col-sm-12 name">
         <h3> Kindly Verify your details
         </h3>
    </div></div>
        <div class="row">
        <div class="col-sm-5"></div>
    <div class="col-sm-7">
       <form method="post" action="FinalDetails">
          <h4>
          FirstName : <p id="name"><%=(String)context.getAttribute("firstName")%></p>
          <br>
           <br>
          LastName : <%=(String)context.getAttribute("lastName") %><br>
          <br>
          Email : <%=(String)context.getAttribute("email") %><br>
          <br>
          UserName : <%= (String)context.getAttribute("username") %><br>
          <br>
          Mindtree ID : <%=(String)context.getAttribute("mid") %><br>
          <br>
          Age : <%=(String)context.getAttribute("age") %><br>
          <br>
          City : <%=(String)context.getAttribute("city") %><br>
          <br>
          Batch : <%=(String)context.getAttribute("batch") %>
          </h4> 
          <button type="submit" OnClick="hello()">OK</button>
          </form>
         </div>
    
 </div>
</body>
</html>
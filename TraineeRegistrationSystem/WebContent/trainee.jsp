<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .header {
    color:white;
    background-color:#424242;
    border:1px solid #CCC;
    text-align: center;
    height:120px;
    padding: 20px;
    text-transform: uppercase;
}
body{
    background-color:#f5f5f5;
}
.detail{
padding-top:50px;
}
#mail{
padding-left:20px:
}
.button1{
padding-top:40px;
padding-left:100px;
}
.button2{
padding-top:40px;
padding-right:50px;

}

  </style>
  <script>
  function checkExist(){
      var xmlhttp = new XMLHttpRequest();
      var username = document.forms["regF"]["userName"].value;
      var url = "exists.jsp?username=" + username;
      xmlhttp.onreadystatechange = function(){
          if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
              if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
                  document.getElementById("isE").style.color = "red";
              else
                  document.getElementById("isE").style.color = "green";
              document.getElementById("isE").innerHTML = xmlhttp.responseText;
          }
          
      };
      try{
      xmlhttp.open("GET",url,true);
      xmlhttp.send();
  }catch(e){alert("unable to connect to server");
  }
  </script>
</head>
<body >
 <div class="row">
   <div class="col-sm-12 header">
    	<marquee><h1>User details</h1></marquee>
   </div>
 </div>
 <div class="row">
<div class="col-sm-4"></div>
<div class="col-sm-5 detail">
  <form method="post" action="Login" name="regF">
  <div class="row">
  <div class="col-sm-3"><h4>FirstName :</h4> </div>
  <div class="col-sm-9"><input type="text" name="firstName" required />${msg1} ${msg2}</div>
  </div>
  <div class="row">
   <div class="col-sm-3"><h4>LastName : </h4> </div>
  <div class="col-sm-9"><input type="text" name="lastName" required /> </div>
  </div>
     <div class="row">
   <div class="col-sm-3"><h4>Email : </h4> </div>
  <div class="col-sm-9"><input type="email" name="email" required /> </div>
  </div>
      <div class="row">
   <div class="col-sm-3"><h4>User Name : </h4> </div>
  <div class="col-sm-9"><input type="text" name="userName" onblur="checkExist()" required /><span id="isE"></span>${msg4}</div>
  </div>
   <div class="row">
   <div class="col-sm-3"><h4>Password : </h4> </div>
  <div class="col-sm-9"><input type="password" name="password" required /> ${msg3}</div>
  </div>
    <div class="row">
  <div class="col-sm-3 button1"><button type="submit" value="next">Next</button></div>
  <div class="col-sm-9 button2"><a href="index.html"><button type="button">Cancel</button></a></div>
   <br>*All the fields are mandatory
  </div>
        </form></div>
   <div class="col-sm-3">     
</div></div>

</body>
</html>
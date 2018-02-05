<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>

<% Class.forName ("com.mysql.jdbc.Driver");
  ResultSet rs;
%>
<%ServletContext context=getServletContext(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee Data</title>
</head>
<body>
<center>
<h3>Mind Details</h3>
<br>
<br>
<% 
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainee","root","Welcome123");
           String username=(String)context.getAttribute("User_name");
        String query="select firstname,lastname,email,username,MID,Age,City,batch from traineedata where username=?";
        PreparedStatement stmt=(PreparedStatement)conn.prepareStatement(query);
        stmt.setString(1, username);
        rs=stmt.executeQuery();
        %>
        <TABLE BORDER="1">
            <TR>
                <TH>FirstName</TH>
                <TH>LastName</TH>
                <TH>Email</TH>
                <TH>User Name</TH>
                <TH>MID</TH>
                <th>Age</th>
                <th>City</th>
                <th>Batch</th>
            </TR>
            <% while(rs.next()){ %>
            <TR>
                <TD> <%= rs.getString(1) %></td>
                <TD> <%= rs.getString(2) %></TD>
                <TD> <%= rs.getString(3) %></TD>
                <TD> <%= rs.getString(4) %></TD>
                <TD> <%= rs.getString(5) %></TD>
                <TD> <%= rs.getString(6) %></TD>
                <TD> <%= rs.getString(7) %></TD>
                <TD> <%= rs.getString(8) %></TD>
            </TR>
            <% } %>
        </TABLE>
        <br>
        <br>
        <a href="index.html">Return to Home Page</a>
</center>
 
</body>
</html>
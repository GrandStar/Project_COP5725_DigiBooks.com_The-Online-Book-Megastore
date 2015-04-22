<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
<form method='post' action='LogoutServlet'>
	<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
            <table>
            <tr>
				<td><input type="text" name='username' readonly value='<%=session.getAttribute("name")%>'/></br></td>
        	</tr>
        	 		
        	 <tr>
				<td>First Name :</td>
				<td> <input type="text" name='firstname' required="required" value='<%=request.getAttribute("fname")%>'/></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td> <input type="text" name='fullname' required="required" value='<%=request.getAttribute("lname")%>'/></td>
			</tr>
			<tr>
				<td>Phone Number : </td>
				<td><input type="text" name='phonenumber' required="required" value='<%=request.getAttribute("phonenumber")%>'/></td>
			</tr>
			<tr>
				<td>Email id : </td>
				<td><input type="email" name='emailid' required="required" value='<%=request.getAttribute("email")%>'/></td>
			</tr>				
			</tr>
				<td>Password:</td> 
				<td><input type="password" name="password" required value='<%=request.getAttribute("password")%>' onchange="
  						if(this.checkValidity()) form.pwd2.pattern = this.value;"></td>
  			</tr>
  			<tr>
				<td>Confirm Password:</td>
				<td> <input title="Please enter the same Password as above" type="password" placeholder="confirm password" required  name="pwd2"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="Update"/></td>
			</tr>
			</table>
</form>
</body>
</html>
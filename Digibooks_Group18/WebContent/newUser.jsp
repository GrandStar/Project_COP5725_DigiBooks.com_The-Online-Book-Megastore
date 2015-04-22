
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer login Page</title>
</head>
<body>
<form method='post' action='UserInfoServlet'>
<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
            <table>
            <tr>
				<td>First Name :</td> 
				<td><input type="text" name='firstname' placeholder="abc" required="required"/></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><input type="text" name='fullname' placeholder="xyz" required="required"/></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type='radio' name='gender' value='1'>Male</input>
					<input type='radio' name='gender' value='2'>Female</input>
				</td>
			</tr>
			<tr>
				<td>Role :</td>
				<td> <select name="role">
					  <option value="0">Select Role</option>
					  <option value="1">IT Support</option>
					  <option value="2">Inventory Management</option>
					  <option value="3">Sales Team</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td> <input type="text" name='phonenumber' placeholder="999-999-9999" required="required"/></td>
			</tr>
			<tr>
				<td>Email id :</td>
				<td> <input type="email" name='emailid' placeholder="abc@xyz.com" required="required"/></td>
			</tr>
			<tr>
				<td>User Name : </td>
				<td><input type="text" name='username' placeholder="abcde" required="required"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" placeholder="password" required  onchange="
  					if(this.checkValidity()) form.pwd2.pattern = this.value;"></td>
  			</tr>
  			<tr>
				<td>Confirm Password: </td>
				<td><input title="Please enter the same Password as above" type="password" placeholder="password" required  name="pwd2"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"/></td>
			</tr>
			</table>
</form>
</body>
</html>
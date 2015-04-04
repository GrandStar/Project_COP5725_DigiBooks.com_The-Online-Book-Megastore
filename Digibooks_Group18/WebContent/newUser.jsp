<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
<form method='post' action='UserInfoServlet'>
First Name : <input type="text" name='username'/></br>
Last Name : <input type="text" name='fullname'/></br>
Gender :
<input type='radio' name='gender' value='Male'>Male</input>
<input type='radio' name='gender' value='Female'>Female</input>
</br>
Email id : <input type="text" name='emailid'/></br>
Password: <input type="password" name="password"></br>
Address line1 : <input name='line1'/></br>
Address linen : <input name='line2'/></br>
State :
	<select name='state'>
	<option value='default'> Select one</option>
	<option value='Florida'> Florida</option>
	<option value='California'> California</option>
	<option value='Washington'> Washington</option>
	<option value='Texas'> Texas</option>
	<option value='New York'> New York</option>
</select></br>
<input type="submit" value="Register"/>
</form>
</body>
</html>
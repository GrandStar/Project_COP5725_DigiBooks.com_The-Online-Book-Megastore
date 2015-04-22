<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
<body>
<form method='post' action='CustomerLoginServlet'>
	<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
            <table>
            <tr>
				<td>First Name : </td>
				<td><input type="text" name='firstname' placeholder="abc" required="required"/></td>
			</tr>
			
			<tr>
				<td>Last Name :</td>
				<td> <input type="text" name='lastname' placeholder="xyz" required="required"/></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><input type='radio' name='gender' value='1'>Male</input>
					<input type='radio' name='gender' value='2'>Female</input></td>
			</tr>
			<tr>
				<td>Address Line 1 : </td>
				<td><input type="text" name='addressl1' placeholder="Street Number, Apartment Number" required="required"/></td>
			</tr>
			<tr>
				<td>Address Line 2 : </td>
				<td><input type="text" name='addressl2' placeholder="Area, City"/></td>
			</tr>
			<tr>
				<td>Phone Number : </td>
				<td><input type="text" name='phonenumber' placeholder="999-999-9999" required="required"/></td>
			</tr>
			<tr>
				<td>Zip Code : </td>
				<td><input type="text" name='zipcode' placeholder="99999" required="required"/></td>
			</tr>
			<tr>
				<td>State :</td>
				<td> <select name="state">
			  <option value="0">Select State</option>
			  <option value="1">Alabama</option>
			  <option value="2">Alaska</option>
			  <option value="3">Arizona</option>
			  <option value="4">Arkansas</option>
			  <option value="5">California</option>
			  <option value="6">Colorado</option>
			  <option value="7">Connecticut</option>
			  <option value="8">Delaware</option>
			  <option value="9">Florida</option>
			  <option value="10">Georgia</option>
			  <option value="11">Hawaii</option>
			  <option value="12">Idaho</option>
			  <option value="13">Illinois</option>
			  <option value="14">Indiana</option>
			  <option value="15">Iowa</option>
			  <option value="16">Kansas</option>
			  <option value="17">Kentucky</option>
			  <option value="18">Louisiana</option>
			  <option value="19">Maine</option>
			  <option value="20">Maryland</option>
			  <option value="21">Massachusetts</option>
			  <option value="22">Michigan</option>
			  <option value="23">Minnesota</option>
			  <option value="24">Mississippi</option>
			  <option value="25">Missouri</option>
			  <option value="26">Montana</option>
			  <option value="27">Nebraska</option>
			  <option value="28">Nevada</option>
			  <option value="29">New Hampshire</option>
			  <option value="30">New Jersey</option>
			  <option value="31">New Mexico</option>
			  <option value="32">New York</option>
			  <option value="33">North Carolina</option>
			  <option value="34">North Dakota</option>
			  <option value="35">Ohio</option>
			  <option value="36">Oklahoma</option>
			  <option value="37">Oregon</option>
			  <option value="38">Pennsylvania</option>
			  <option value="39">Rhode Island</option>
			  <option value="40">South Carolina</option>
			  <option value="41">South Dakota</option>
			  <option value="42">Texas</option>
			  <option value="44">Utah</option>
			  <option value="45">Vermont</option>
			  <option value="46">Virginia</option>
			  <option value="47">Washington</option>
			  <option value="48">West Virginia</option>
			  <option value="49">Wisconsin</option>
			  <option value="50">Wyoming</option>
			</select></td>
		</tr>
		<tr>
			<td>Email id : </td>
			<td><input type="email" name='emailid' placeholder="abc@xyz.com" required="required"/></td>
		<tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="password" placeholder="password" required  onchange="
			if(this.checkValidity()) form.pwd2.pattern = this.value;"></td>
		<tr>
		<tr>
			<td>Confirm Password: </td>
			<td><input title="Please enter the same Password as above" type="password" placeholder="password" required  name="pwd2"></p>
		</tr>
		<tr>
			<td><input type="submit" name="button" value="Register"/></td>
		</tr>
		</table>
</form>
</body>
</html>
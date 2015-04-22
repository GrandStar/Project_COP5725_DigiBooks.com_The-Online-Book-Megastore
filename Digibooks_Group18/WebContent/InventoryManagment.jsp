<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welocme to Digibooks.com</title>
</head>
<body>
	<form method='post' action='LogoutServlet'>
		<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
            <table>
            <tr>
				<td>Book Name :</td> 
				<td><input type="text" name='bookname' required="required" readonly value='<%=request.getAttribute("bookbame")%>'/></td>
			</tr>
			<tr>
				<td>ISBN : </td>
				<td><input type="text" name='isbn'  required="required" readonly value='<%=request.getAttribute("isbn")%>'/></td>
			</tr>
			<tr>
				<td>Inventory : </td>
				<td><input type="text" name='inventory'  required="required" value='<%=request.getAttribute("inventory")%>'/></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" value="Update Inventory"/></td>
			</tr>
			</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welocme to Digibooks.com</title>
</head>

<body onload="myFunction()">
<script>
function myFunction() {
	    document.getElementById("myCheck").disabled = false;
}
</script>
	<form method='post' action='CustomerLoginServlet'>
		<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
            <table>
            <tr>
				<td>Customer :</td> 
				<td><input type="text" name='username' readonly value='<%=request.getAttribute("username")%>'/></td>
			</tr>
            <tr>
				<td>Book ID :</td> 
				<td><input type="text" name='bookid' readonly value='<%=request.getAttribute("bookid")%>'/></td>
			</tr>
			<tr>
				<td>Book Name :</td> 
				<td><input type="text" name='bookname' readonly value='<%=request.getAttribute("bookname")%>'/></td>
			</tr>
			<tr>
				<td>ISBN : </td>
				<td><input type="text" name='isbn' readonly value='<%=request.getAttribute("isbn")%>'/></td>
			</tr>
			<tr>
				<td>Author : </td>
				<td><input type="text" name='author' readonly value='<%=request.getAttribute("author")%>'/></td>
			</tr>
			<tr>
				<td>Publication House : </td>
				<td><input type="text" name='publicationHouse' readonly value='<%=request.getAttribute("Publication")%>'/></td>
			</tr>
			<tr>
				<td>Language : </td>
				<td><input type="text" name='language' readonly value='<%=request.getAttribute("language")%>'/></td>
			</tr>
			<tr>
				<td>Price : </td>
				<td><input type="text" name='price' readonly value='<%=request.getAttribute("price")%>'/></td>
			</tr>
			<tr>
				<td>Genre : </td>
				<td><input type="text" name='genre' readonly value='<%=request.getAttribute("genre")%>'/></td>
			</tr>
			<tr>
				<td>IsInventory : </td>
				<td><input type="text" name='IsInventory' readonly value='<%=request.getAttribute("IsInventory")%>'/></td>
			</tr>
			<tr>
				<td>Quantities : </td>
				<td><input type="number" name="quantity" required="required" min="0" max="10" step="1"></td>
			</tr>
			<tr>
				<td><input type="submit" name="button" id="myCheck" value="Add to Cart"/></td>
			</tr>
			</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
<form action="CustomerLoginServlet" method="post">
<h2>Welcome</h2>
<input  type="text" name="username"  readonly value='<%=request.getAttribute("username")%>'/>
	<table border="1">		
	<% String[] bookname = (String[])request.getAttribute("bookname"); %>
	<% String[] author = (String[])request.getAttribute("author"); %>
	<% String[] isbn = (String[])request.getAttribute("isbn"); %>
	<% Float[] price = (Float[])request.getAttribute("price"); %>
	<% String[] genre = (String[])request.getAttribute("genre"); %>
	<tr>
		<td>Customer :</td> 
		<td><input type="text" name='username' readonly value='<%=request.getAttribute("username")%>'/></td>
	</tr>
	<tr>
	  <td>Select</td>
      <td>Book Name</td>
      <td>Author</td>
      <td>ISBN</td>
      <td>Genre</td>
      <td>Price</td>
   </tr>
	<c:forEach begin="0" end="${fn:length(bookname) - 1}" var="index">
   <tr>
   	  <td><input type='radio' name='select' value="">
      <td><input type="text" readonly name="bookname" value="${bookname[index]}"/></td>
      <td><input type="text" readonly name="author" value="${author[index]}"/></td>
      <td><input type="text" readonly name="isbn" value="${isbn[index]}"/></td>
      <td><input type="text" readonly name="genre" value="${genre[index]}"/></td>
      <td><input type="text" readonly name="price" value="${price[index]}"/></td>
   </tr>
</c:forEach>
<tr>
   <td><input type="submit" name="button" value="See Details" /></td>
</tr>
</table>
</form>
</body>
</html>
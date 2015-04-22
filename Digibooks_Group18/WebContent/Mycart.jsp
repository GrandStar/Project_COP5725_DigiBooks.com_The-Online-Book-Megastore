<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import='com.amzi.obj.Cart'%>
<%@page import='com.amzi.obj.Customer'%>
<%@page import='com.amzi.obj.MBook'%>
<%@page import='com.amzi.obj.Cart'%>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%Cart custcart = (Cart)session.getAttribute("cart");%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
<form action="CustomerLoginServlet" method="post">
<h2>Welcome</h2>
<input  type="text" name="username"  readonly value='<%=session.getAttribute("name")%>'/>
	<table border="1">
	<%int count = custcart.cart.size()-1; %>	
	<% String[] bookname = (String[])request.getAttribute("bookname"); %>
	<% String[] isbn = (String[])request.getAttribute("isbn"); %>
	<% Float[] price = (Float[])request.getAttribute("price"); %>
	<% Integer[] quantity = (Integer[])request.getAttribute("quantity"); %>
	<% Float[] totalprice = (Float[])request.getAttribute("totalprice"); %>
	<tr>
      <td>Book Name</td>
      <td>ISBN</td>
      <td>Unit Price</td>
      <td>Quantity</td>
      <td>Total Price</td>
   </tr>
	<c:forEach begin="0" end="${fn:length(bookname) - 1}" var="index">
	
   <tr>
      <td><input type="text" readonly name="bookname" value="${bookname[index]}"/></td>
      <td><input type="text" readonly name="isbn" value="${isbn[index]}"/></td>
      <td><input type="text" readonly name="price" value="${price[index]}"/></td>
      <td><input type="text" readonly name="isbn" value="${quantity[index]}"/></td>
      <td><input type="text" readonly name="price" value="${totalprice[index]}"/></td>
   </tr>
</c:forEach>
	<tr>
		<td>Total Payment :</td> 
		<td><input type="text" name='totalPayment' value='<%=request.getAttribute("totalPayment")%>'/></td>
	</tr>
	<tr>
		<td>Mode of Payment :</td>
			<td> <select name="payment">
				<option value="0">Select Role</option>
				<option value="1">Cash on delivery</option>
				<option value="2">Credit Card</option>
				<option value="3">Debit Card</option>
		</select>
		</td>
		<td>
		<input type="submit" name="button" value="Make Payment"/>
	</td>
	</tr>
	
</table>
</form>
</body>
</html>
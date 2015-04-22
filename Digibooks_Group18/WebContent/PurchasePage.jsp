<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import='com.amzi.obj.Cart'%>
<%@page import='com.amzi.obj.Customer'%>
<%@page import='com.amzi.obj.MBook'%>
<%@page import='com.amzi.obj.Cart'%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
<%Cart custcart = (Cart)session.getAttribute("cart");%>
<%System.out.println("testing :"+custcart.cart.size()); %>
<title>Welcome to Digibooks.com</title>
</head>
<body>
<form action="CustomerLoginServlet" method="post">
	 <fieldset style="width: 400px">  
            <legend> Login to Digibooks.com </legend>  
	<table>
	 Welcome<tr>  
        	 	<input type="text" name='username' readonly size="35" value='<%=session.getAttribute("name")%>'/>
        	</tr>
        	<tr>
        		<td><input type="submit" name="button" value="Edit Info" /></td>
        	</tr>
        	<tr>  
                <td>Book Name :</td>  
                <td><input  type="text" name="bookname" placeholder="abc"/></td>
                <td><input type="submit" name="button" value="Search by Name" /></td>  
            </tr>
            <tr>  
                <td>ISBN :</td>  
                <td><input  type="text" name="isbn" placeholder="999999999"/></td>
                <td><input type="submit" name="button" value="Search by ISBN" /></td>  
            </tr>
            <tr>  
                <td>Author :</td>  
                <td><input  type="text" name="author" placeholder="xyz"/></td>
                <td><input type="submit" name="button" value="Search by Author" /></td>  
            </tr>
            
       </table>
</form>
</body>
</html>
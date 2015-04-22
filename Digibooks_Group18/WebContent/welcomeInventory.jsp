<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body> 
	<h3>Login successful!!!</h3>  
        Hello there Inventory Management user,
	<form action="LogoutServlet" method="post">
	<fieldset style="width: 400px">  
            <legend> Login to Digibooks.com </legend>
    
        <table>  
        	 <tr>  
        	 		<td><input type="text" name='username' readonly value='<%=session.getAttribute("name")%>'/></td>
        	 </tr>
        	 <tr>
                    <td><input type="submit" name="button" value="Logout" /></td>
                    <td><input type="submit" name="button" value="Edit Info" /></td>
                    <td><input type="submit" name="button" value="Add Book" /></td>   
        	 </tr>
        	 <tr>
				<td>ISBN :</td>
				<td> <input  type="text" name='isbn' placeholder="999999999"/></td>
				<td><input type="submit" name="button" value="Edit Inventory" /></td>
			</tr>
		</table>
      </form>
</body>  
</html>
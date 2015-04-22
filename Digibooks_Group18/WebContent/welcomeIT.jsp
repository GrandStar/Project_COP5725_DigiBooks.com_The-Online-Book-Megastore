<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body>  
	<form action="LogoutServlet" method="post">
	<fieldset style="width: 400px">  
            <legend> Welcome to Digibooks.com </legend>
    <h3>Login successful!!!</h3>  
        Hello there IT user,  
        	 <tr>  
        	 		<td><input type="text" name='username' readonly value='<%=session.getAttribute("name")%>'/></br></td>
        	 		<td></td>
                    <td><input type="submit" name="button" value="Logout" /></td>
                    <td><input type="submit" name="button" value="Edit Info" /></td>
                    <td><input type="submit" name="button" value="New User" /></td> 
        	 </tr> 
      </form>
</body>  
</html>
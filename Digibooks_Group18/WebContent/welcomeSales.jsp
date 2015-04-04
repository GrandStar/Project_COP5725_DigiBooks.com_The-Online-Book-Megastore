<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Welcome <%=session.getAttribute("name")%></title>  
</head>  
<body>  
	<form action="LogoutServlet" method="post">
    <h3>Login successful!!!</h3>  
    <h4>  
        Hello Sales user, 
        I am Batman ! 
        <%=session.getAttribute("name")%></h4>
        	 <tr>  
                    <td><input type="submit" name="button" value="Logout" /></td>
                    <td><input type="submit" name="button" value="Edit Info" /></td>  
        	 </tr> 
      </form>
</body>  
</html>
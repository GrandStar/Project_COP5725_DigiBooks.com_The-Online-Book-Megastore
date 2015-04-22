<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Customer Login Application</title>  
</head>  
<body>  
    <form action="CustomerLoginServlet" method="post">  
        <fieldset style="width: 300px">  
            <legend> Login to Digibooks.com </legend>  
            <table>  
                <tr>  
                    <td>User ID</td>  
                    <td><input  type="email" name="username" placeholder="abc@xyz.com"/></td>  
                </tr>  
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="userpass" placeholder="password"/></td>  
                </tr>  
                <tr>  
                    <td><input type="submit" name="button" value="Login" /></td>
                    <td><input type="submit" name="button" value="New User" /></td>   
                </tr>
            </table>  
        </fieldset>  
    </form>
    <a href="http://localhost:8080/Digibooks_Group18/index.jsp">Redirect to Admin Users</a>    
</body>  
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Login Application</title>  
</head>  
<body>  
    <form action="loginServlet" method="post">  
        <fieldset style="width: 300px">  
            <legend> Login to Digibooks.com </legend>  
            <table>  
                <tr>  
                    <td>User ID</td>  
                    <td><input type="text" name="username" /></td>  
                </tr>  
                <tr>  
                    <td>Password</td>  
                    <td><input type="password" name="userpass" /></td>  
                </tr>  
                <tr>  
                    <td><input type="submit" name="button" value="Login" /></td>
                    <td><input type="submit" name="button" value="New User" /></td>   
                </tr>
            </table>  
        </fieldset>  
    </form>    
</body>  
</html>
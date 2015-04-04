package com.amzi.dao;  


import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.*; 

  
public class LoginDao {  
    public static int validate(String name, String pass) {          

        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int roleId=0;
        String validateEmployeeSql= "{call validateEmployee(?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(validateEmployeeSql);
            callableStatement.setString(1, name);
            callableStatement.setString(2, pass);
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            roleId = callableStatement.getInt(3);
            return roleId;
  
        } catch (Exception e) {  
            System.out.println(e);  
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return roleId;  
    }  
}
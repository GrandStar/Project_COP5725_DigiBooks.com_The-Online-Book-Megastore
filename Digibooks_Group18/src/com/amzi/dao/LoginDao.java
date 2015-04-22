package com.amzi.dao;


import java.sql.*; 
import java.util.ArrayList;

import com.amzi.obj.Cart;
import com.amzi.obj.Customer;
import com.amzi.obj.MBook;
import com.amzi.obj.MEmplyoee;

  
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
    
    public static int register(MEmplyoee emp) {          

        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int result = 0;
        String createEmployee =  "{call createEmployee(?,?,?,?,?,?,?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(createEmployee);
            callableStatement.setString(1, emp.getFname());
            callableStatement.setString(2, emp.getLname());
            callableStatement.setInt(3, emp.getGender());
            callableStatement.setString(4, emp.getPhonenumber());
            callableStatement.setString(5, emp.getEmailid());
            callableStatement.setString(6, emp.getUsername());
            callableStatement.setString(7, emp.getPassword());
            callableStatement.setInt(8, emp.getRoleid());
            callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(9);
            return result;
  
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
		return result;
    }
    public static MEmplyoee EditInfo(String username) {          

        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        MEmplyoee emp = new MEmplyoee();
        int result = 0;
        String getdataEmployee  =  "{call getdataEmployee(?,?,?,?,?,?)}";
        
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
        	callableStatement = conn.prepareCall(getdataEmployee);
            callableStatement.setString(1, username);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.executeUpdate();
            emp.setFname(callableStatement.getString(2));
            emp.setLname(callableStatement.getString(3));
            emp.setPhonenumber(callableStatement.getString(4));
            emp.setEmailid(callableStatement.getString(5));
            emp.setPassword(callableStatement.getString(6));
            emp.setUsername(username);
            
            return emp;
        	
        	
  
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
        //return roleId;  
		return emp;
    }
    
    public static int update(MEmplyoee emp) {          

        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int result = 0;
        String updateEmployee  =  "{call updateEmployee (?,?,?,?,?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(updateEmployee);
            callableStatement.setString(1, emp.getUsername());
            callableStatement.setString(2, emp.getFname());
            callableStatement.setString(3, emp.getLname());
            callableStatement.setString(4, emp.getPhonenumber());
            callableStatement.setString(5, emp.getEmailid());
            callableStatement.setString(6, emp.getPassword());
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(7);
            return result;
  
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
		return result;
    }
    
    
    public static int AddBook(MBook book) {          
    	Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int result = 0;
        String ADDBOOK  =  "{call ADDBOOK(?,?,?,?,?,?,?,?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(ADDBOOK);
            callableStatement.setString(1, book.getBookname());
            callableStatement.setString(2, book.getAuthor());
            callableStatement.setInt(3, book.getPublicationhouse());
            callableStatement.setInt(4, book.getGenre());
            callableStatement.setInt(5, book.getPublicationyear());
            callableStatement.setFloat(6, book.getPrice());
            callableStatement.setInt(7, book.getLanguage());
            callableStatement.setInt(8, book.getInventory());
            callableStatement.setString(9, book.getISBN());
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(10);
            return result;
  
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
		return result;
    }
    
    public static int Custvalidate(String name, String pass) {          

        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int roleId=0;
        String validateCustomer= "{call validateCustomer(?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(validateCustomer);
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
    
    public static int registerCust(Customer cust) {          

        Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int result = 0;
        String createCustomer =  "{call createCustomer(?,?,?,?,?,?,?,?,?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(createCustomer);
            callableStatement.setString(1,cust.getFname());
            callableStatement.setString(2, cust.getLname());
            callableStatement.setInt(3,cust.getGender());
            callableStatement.setString(4,cust.getAddressl1());
            callableStatement.setString(5,cust.getAddressl2());
            callableStatement.setString(6,cust.getPhonenumber());
            callableStatement.setInt(7,cust.getZipcode());
            callableStatement.setInt(8,cust.getState());
            callableStatement.setString(9,cust.getEmailid());
            callableStatement.setString(10,cust.getPassword());
            callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(11);
            return result;
  
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
		return result;
    }

	public static Customer EditCustInfo(String email) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        Customer cust = new Customer();
        int result = 0;
        String getdataCustomer  =  "{call getdataCustomer(?,?,?,?,?,?,?,?)}";
        
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
        	callableStatement = conn.prepareCall(getdataCustomer);
            callableStatement.setString(1, email);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(8, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            
            cust.setEmailid(email);
            cust.setFname(callableStatement.getString(2));
            cust.setLname(callableStatement.getString(3));
            cust.setAddressl1(callableStatement.getString(4));
            cust.setAddressl2(callableStatement.getString(5));
            cust.setPhonenumber(callableStatement.getString(6));
            cust.setZipcode(callableStatement.getInt(7));
            cust.setState(callableStatement.getInt(8));
            return cust;
  
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
        //return roleId;  
		return cust;
    
	}

	public static int UpdateCust(Customer cust) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int result = 0;
        String updateCustomer  =  "{call updateCustomer (?,?,?,?,?,?,?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(updateCustomer);
            callableStatement.setString(1, cust.getEmailid());
            callableStatement.setString(2, cust.getFname());
            callableStatement.setString(3, cust.getLname());
            callableStatement.setString(4, cust.getAddressl1());
            callableStatement.setString(5, cust.getAddressl2());
            callableStatement.setString(6, cust.getPhonenumber());
            callableStatement.setInt(7, cust.getZipcode());
            callableStatement.setInt(8, cust.getState());
            callableStatement.registerOutParameter(9, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(9);
            return result;
  
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
		return result;
	}

	public static MBook getInventory(String isbn) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        MBook book = new MBook();
        String getdataBookInventory  =  "{call getdataBookInventory(?,?,?,?)}";
        
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
        	callableStatement = conn.prepareCall(getdataBookInventory);
            callableStatement.setString(1, isbn);
            callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            
            book.setBookname(callableStatement.getString(2));
            book.setISBN(callableStatement.getString(3));
            book.setInventory(Integer.parseInt(callableStatement.getString(4)));
            
            return book;
  
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
		return book;
	}

	public static int updateInventory(MBook book) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        int result = 0;
        String updateBookInventory  =  "{call updateBookInventory (?,?,?)}";
        
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
            callableStatement = conn.prepareCall(updateBookInventory);
            callableStatement.setString(1, book.getISBN());
            callableStatement.setInt(2, book.getInventory());
            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            result = callableStatement.getInt(3);
            return result;
  
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
		return result;
		
	}

	public static ArrayList<MBook> SearchByName(String bookName) {
		Connection conn = null;  
		Statement stmt = null; 
        ResultSet rs = null; 
        //String searchbyname  = "select bookname,author,ISBN ,price  from tbook where bookname like '%"+bookname+"%'";
        String searchbyname  = "select a.bookname,a.author,b.genredesc,a.ISBN,a.price from tbook  a inner join mgenre  b on a.genre=b.genreid where a.bookname like '%"+bookName+"%'";
        ArrayList<MBook> result = new ArrayList<MBook>();
        
        try {  
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery(searchbyname);
        	while(rs.next()){
        		MBook book = new MBook();
        		book.setBookname(rs.getString("bookname"));
        		book.setAuthor(rs.getString("author"));
        		book.setISBN(rs.getString("ISBN"));
        		book.setPrice(rs.getFloat("price"));
        		book.setGenredesc(rs.getString("genredesc"));
        		result.add(book);
        	}
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
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }    
		return result;
		
	}

	public static ArrayList<MBook> SearchByISBN(String ISBN) {
		Connection conn = null;  
		Statement stmt = null; 
        ResultSet rs = null; 
        String searchbyname  = "select a.bookname,a.author,b.genredesc,a.ISBN,a.price from tbook  a inner join mgenre  b on a.genre=b.genreid where a.ISBN like '%"+ISBN+"%'";
        ArrayList<MBook> result = new ArrayList<MBook>();
        
        try {  
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery(searchbyname);
        	while(rs.next()){
        		MBook book = new MBook();
        		book.setBookname(rs.getString("bookname"));
        		book.setAuthor(rs.getString("author"));
        		book.setISBN(rs.getString("ISBN"));
        		book.setPrice(rs.getFloat("price"));
        		book.setGenredesc(rs.getString("genredesc"));
        		result.add(book);
        	}
        	
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
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }    
		return result;
	}

	public static ArrayList<MBook> SearchByAuthor(String author) {
		Connection conn = null;  
		Statement stmt = null; 
        ResultSet rs = null; 
        String searchbyname  = "select a.bookname,a.author,b.genredesc,a.ISBN,a.price from tbook  a inner join mgenre  b on a.genre=b.genreid where a.author like '%"+author+"%'";
        ArrayList<MBook> result = new ArrayList<MBook>();
        
        try {  
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
        	stmt = conn.createStatement();
        	rs = stmt.executeQuery(searchbyname);
        	while(rs.next()){
        		MBook book = new MBook();
        		book.setBookname(rs.getString("bookname"));
        		book.setAuthor(rs.getString("author"));
        		book.setISBN(rs.getString("ISBN"));
        		book.setPrice(rs.getFloat("price"));
        		book.setGenredesc(rs.getString("genredesc"));
        		result.add(book);
        	}
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
            if (rs != null) {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }    
		return result;
	}

	public static MBook CompleteDetails(String isbn) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        MBook book = new MBook();
        String AddBookBasket  =  "{call AddBookBasket(?,?,?,?,?,?,?,?,?,?)}";
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
        	callableStatement = conn.prepareCall(AddBookBasket);
            callableStatement.setString(1, isbn);
            callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(7, java.sql.Types.FLOAT);
            callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(9, java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            
            book.setBookid(callableStatement.getInt(2));
            book.setISBN(isbn);
            book.setBookname(callableStatement.getString(3));
            book.setAuthor(callableStatement.getString(4));
            book.setPublicationName(callableStatement.getString(5));
            book.setGenredesc(callableStatement.getString(6));
            book.setPrice(callableStatement.getFloat(7));
            book.setLanguageName(callableStatement.getString(8));
            book.setISBN(callableStatement.getString(9));
            book.setIsInventory(callableStatement.getInt(10));
            
            return book;
  
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
		return book;
	
	}



	public static int transaction(Cart custcart) {
		Connection conn = null;  
        PreparedStatement pst = null;  
        ResultSet rs = null; 
        CallableStatement callableStatement = null;
        MBook book = new MBook();
        String INSERTTRANS  =  "{call INSERTTRANS(?,?,?,?,?,?,?,?,?,?,?)}";
        try {  
        	Class.forName("oracle.jdbc.driver.OracleDriver");	
        	conn=DriverManager.getConnection(  
        			"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","sspande","Vfs!1234");
            
        	callableStatement = conn.prepareCall(INSERTTRANS);
            callableStatement.setString(1, Cart.getEmailid());
            callableStatement.setInt(2, Cart.getMakepaymentflg());
            callableStatement.setInt(3, custcart.getCart().get(0).getBookid());
            callableStatement.setInt(4, custcart.getCart().get(0).getQuantity());
            callableStatement.setInt(5, custcart.getCart().get(1).getBookid());
            callableStatement.setInt(6, custcart.getCart().get(1).getQuantity());
            callableStatement.setInt(7, custcart.getCart().get(2).getBookid());
            callableStatement.setInt(8, custcart.getCart().get(2).getQuantity());
            callableStatement.setFloat(9, Cart.getTotalPaymentl());
            callableStatement.registerOutParameter(10, java.sql.Types.INTEGER);
            callableStatement.registerOutParameter(11, java.sql.Types.INTEGER);
            callableStatement.executeUpdate();
            
       
            int check1 = callableStatement.getInt(10);
            int check2 = callableStatement.getInt(11);
            System.out.println("transaction :"+ check1);
            System.out.println("transaction :"+ check2);
            return 0;
  
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
		return 0;
		
	}

}
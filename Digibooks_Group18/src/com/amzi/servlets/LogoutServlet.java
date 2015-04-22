package com.amzi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzi.dao.LoginDao;
import com.amzi.obj.MBook;
import com.amzi.obj.MEmplyoee;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String selectedValue = request.getParameter("button");
		PrintWriter out = response.getWriter();
		if(selectedValue.equalsIgnoreCase("Logout")){
			request.getSession().invalidate();
			out.print("<p style=\"color:red\">Logout Successful</p>"); 
	        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	        rd.include(request, response);
		}
		else if(selectedValue.equalsIgnoreCase("Edit Info")){
			MEmplyoee emp = LoginDao.EditInfo(request.getParameter("username"));
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("fname", emp.getFname());
			request.setAttribute("lname", emp.getLname());
			request.setAttribute("phonenumber",emp.getPhonenumber());
			request.setAttribute("email",emp.getEmailid());
			request.setAttribute("password",emp.getPassword());
			RequestDispatcher rd=request.getRequestDispatcher("EditPage.jsp");    
            rd.forward(request,response);
		}
		else if(selectedValue.equalsIgnoreCase("Update")){
			MEmplyoee emp = new MEmplyoee();
	        emp.setFname(request.getParameter("firstname"));
	        emp.setLname(request.getParameter("fullname"));
	        emp.setPhonenumber(request.getParameter("phonenumber"));
	        emp.setEmailid(request.getParameter("emailid"));
	        emp.setUsername(request.getParameter("username"));
	        emp.setPassword(request.getParameter("password"));
	        
	        int result = LoginDao.update(emp);
	        
	        if(result==0){
	        	out.print("<p style=\"color:red\">No information is updated.</p>");    
	            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
	            rd.include(request,response);
	        }
	        else{
	        	out.print("<p style=\"color:green\">User is successfully updated his information.</p>");
	        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
	            rd.include(request,response);
	        }
		}
		
		else if(selectedValue.equalsIgnoreCase("Add Book")){
			RequestDispatcher rd=request.getRequestDispatcher("NewBook.jsp");    
            rd.include(request,response);
		}
		else if(selectedValue.equalsIgnoreCase("New User")){
			RequestDispatcher rd=request.getRequestDispatcher("newUser.jsp");    
            rd.forward(request,response);
		}
		else if(selectedValue.equalsIgnoreCase("Edit Inventory")){
			MBook book = LoginDao.getInventory(request.getParameter("isbn"));
			request.setAttribute("bookbame", book.getBookname());
			request.setAttribute("isbn", book.getISBN());
			request.setAttribute("inventory",book.getInventory());
			RequestDispatcher rd=request.getRequestDispatcher("InventoryManagment.jsp");    
            rd.forward(request,response);
		}
		else if(selectedValue.equalsIgnoreCase("Update Inventory")){
			MBook book = new MBook();
			book.setBookname(request.getParameter("bookname"));
			book.setISBN(request.getParameter("isbn"));
			book.setInventory(Integer.parseInt(request.getParameter("inventory")));
			
	        int result = LoginDao.updateInventory(book);
	        
	        if(result==0){
	        	out.print("<p style=\"color:red\">No information is updated.</p>");    
	            RequestDispatcher rd=request.getRequestDispatcher("welcomeInventory.jsp");    
	            rd.include(request,response);
	        }
	        else{
	        	out.print("<p style=\"color:green\">Inventory is update.</p>");
	        	RequestDispatcher rd=request.getRequestDispatcher("welcomeInventory.jsp");    
	            rd.include(request,response);
	        }
		}
        out.close();
	}
}

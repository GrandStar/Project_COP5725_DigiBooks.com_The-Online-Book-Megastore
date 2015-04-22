package com.amzi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzi.dao.LoginDao;
import com.amzi.obj.MEmplyoee;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
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
        PrintWriter out = response.getWriter();
        
        
        MEmplyoee emp = new MEmplyoee();
        emp.setFname(request.getParameter("firstname"));
        emp.setLname(request.getParameter("fullname"));
        emp.setGender(Integer.parseInt(request.getParameter("gender")));
        emp.setRoleid(Integer.parseInt(request.getParameter("role")));
        emp.setPhonenumber(request.getParameter("phonenumber"));
        emp.setEmailid(request.getParameter("emailid"));
        emp.setUsername(request.getParameter("username"));
        emp.setPassword(request.getParameter("password"));
        
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", emp.getFname());  
        
        int result = LoginDao.register(emp);
        
        if(result==1){
        	out.print("<p style=\"color:red\">This username is already Existed, Please change it and try again.</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("newUser.jsp");    
            rd.include(request,response);
        }
        else{
        	out.print("<p style=\"color:green\">User is successfully created.</p>");
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);
        }
        
        
        out.close(); 
	}
}
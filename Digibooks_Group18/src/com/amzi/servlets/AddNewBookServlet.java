package com.amzi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amzi.dao.LoginDao;
import com.amzi.obj.MBook;
import com.amzi.obj.MEmplyoee;

/**
 * Servlet implementation class AddNewServlet
 */
@WebServlet("/AddNewServlet")
public class AddNewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewBookServlet() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String selectedValue = request.getParameter("button");
		PrintWriter out = response.getWriter();
		
		if(selectedValue.equalsIgnoreCase("new Book")){
			MBook book = new MBook();
			book.setBookname(request.getParameter("bookname"));
			book.setAuthor(request.getParameter("author"));
			book.setPublicationhouse(Integer.parseInt(request.getParameter("publicationHouse")));
			book.setGenre(Integer.parseInt(request.getParameter("Genre")));
			book.setLanguage(Integer.parseInt(request.getParameter("Language")));
			book.setISBN(request.getParameter("ISBN"));
			book.setPublicationyear(Integer.parseInt(request.getParameter("Publicationyear")));
			book.setPrice(Float.parseFloat(request.getParameter("price")));
			book.setInventory(Integer.parseInt(request.getParameter("Inventory")));
			int result = LoginDao.AddBook(book);
			
			if(result==1){
	        	out.print("<p style=\"color:red\">Book is already available.</p>");    
	            RequestDispatcher rd=request.getRequestDispatcher("NewBook.jsp");    
	            rd.include(request,response);
	        }
	        else{
	        	out.print("<p style=\"color:green\">Book is Successfully added.</p>");
	        	RequestDispatcher rd=request.getRequestDispatcher("NewBook.jsp");
	            rd.include(request,response);
	        }
			
		}
		out.close();
	}

}

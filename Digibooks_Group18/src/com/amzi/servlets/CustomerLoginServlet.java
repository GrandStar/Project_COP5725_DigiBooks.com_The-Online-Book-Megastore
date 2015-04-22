package com.amzi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amzi.dao.LoginDao;
import com.amzi.obj.Cart;
import com.amzi.obj.Customer;
import com.amzi.obj.MBook;
import com.amzi.obj.MEmplyoee;

/**
 * Servlet implementation class CustomerLoginServlet
 */
@WebServlet("/CustomerLoginServlet")
public class CustomerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLoginServlet() {
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
        PrintWriter out = response.getWriter();
        String selectedValue = request.getParameter("button");
        if(selectedValue.equalsIgnoreCase("login")){
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        if(session!=null){
        session.setAttribute("name", n);
        Cart custcart = new Cart();
        custcart.setEmailid(n);
        session.setAttribute("cart", custcart);
        }
        else
        session.setAttribute("name", "a");
        int val = LoginDao.Custvalidate(n, p);
        if(val==1){
        	out.print("<p style=\"color:red\">Welcome to Digibooks.com</p>"); 
            RequestDispatcher rd=request.getRequestDispatcher("PurchasePage.jsp");    
            rd.forward(request,response);    
        }
        else if(val==0){
        	out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");    
            rd.include(request,response);	
        }  	
        }
        else if(selectedValue.equalsIgnoreCase("New User")){
        	RequestDispatcher rd=request.getRequestDispatcher("newCustomerUser.jsp");    
            rd.forward(request,response);
        }
        else if(selectedValue.equalsIgnoreCase("Register")){
        	Customer cust = new Customer();
        	cust.setFname(request.getParameter("firstname"));
        	cust.setLname(request.getParameter("lastname"));
        	cust.setGender(Integer.parseInt(request.getParameter("gender")));
        	cust.setAddressl1(request.getParameter("addressl1"));
        	cust.setAddressl2(request.getParameter("addressl2"));
        	cust.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
        	cust.setState(Integer.parseInt(request.getParameter("state")));
        	cust.setPhonenumber(request.getParameter("phonenumber"));
        	cust.setEmailid(request.getParameter("emailid"));
        	cust.setPassword(request.getParameter("password"));
        	int val = LoginDao.registerCust(cust);
        	if(val==1){
        		out.print("<p style=\"color:green\">Welcome.. Please login</p>");
            	RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");  
                rd.forward(request,response);    	
            }
            else{    
                out.print("<p style=\"color:red\">User is already available.</p>");    
                RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");    
                rd.include(request,response);    
            } 	
        }
        else if(selectedValue.equalsIgnoreCase("Edit Info")){
        	Customer cust = LoginDao.EditCustInfo(request.getParameter("username"));
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("fname", cust.getFname());
			request.setAttribute("lname", cust.getLname());
			request.setAttribute("addressl1", cust.getAddressl1());
			request.setAttribute("addressl2", cust.getAddressl2());
			request.setAttribute("phonenumber",cust.getPhonenumber());
			request.setAttribute("zipcode",cust.getZipcode());
			request.setAttribute("state",cust.getState());
			RequestDispatcher rd=request.getRequestDispatcher("EditCustPage.jsp");    
            rd.forward(request,response);
        }
        
        else if(selectedValue.equalsIgnoreCase("Update")){
        	Customer cust = new Customer();
        	cust.setFname(request.getParameter("firstname"));
        	cust.setLname(request.getParameter("fullname"));
        	cust.setEmailid(request.getParameter("username"));
        	cust.setAddressl1(request.getParameter("addressl1"));
        	cust.setAddressl2(request.getParameter("addressl2"));
        	cust.setPhonenumber(request.getParameter("phonenumber"));
        	cust.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
        	cust.setState(Integer.parseInt(request.getParameter("state")));
      
        	int val = LoginDao.UpdateCust(cust);
        	if(val==0){
        		out.print("<p style=\"color:green\">User is already available.</p>");
            	RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");  
                rd.forward(request,response);    	
            }
            else{    
                out.print("<p style=\"color:red\">Welcome.. Please login</p>");    
                RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");    
                rd.include(request,response);    
            } 	
        }
        
        else if(selectedValue.equalsIgnoreCase("Search by Name") || selectedValue.equalsIgnoreCase("Search by ISBN") || selectedValue.equalsIgnoreCase("Search by Author")){
        	ArrayList<MBook> result = new ArrayList<MBook>();
        	if(selectedValue.equalsIgnoreCase("Search by Name")){
        		String CustName = request.getParameter("username");
        		result = LoginDao.SearchByName(request.getParameter("bookname"));
        		String[] bookname = new String[result.size()];
        		String[] author = new String[result.size()];
        		String[] isbn = new String[result.size()];
        		Float[] price = new Float[result.size()];
        		String[] genre = new String[result.size()];
        		MBook[] book = new MBook[result.size()];
        		for(int i=0;i<result.size();i++){
        			bookname[i] = result.get(i).getBookname();
        			author[i] = result.get(i).getAuthor();
        			isbn[i] = result.get(i).getISBN();
        			price[i] = result.get(i).getPrice();
        			genre[i] = result.get(i).getGenredesc();
        			book[i] = result.get(i);
        		}
        		request.setAttribute("username",CustName);
        		request.setAttribute("bookname",bookname);
        		request.setAttribute("author",author);
        		request.setAttribute("isbn",isbn);
        		request.setAttribute("price",price);
        		request.setAttribute("genre",genre);
        		request.setAttribute("book", book);
    			RequestDispatcher rd=request.getRequestDispatcher("showresult.jsp");    
                rd.forward(request,response);
        		
        	}
        	else if(selectedValue.equalsIgnoreCase("Search by ISBN")){
        		String CustName = request.getParameter("username");
        		result = LoginDao.SearchByISBN(request.getParameter("isbn"));
        		String[] bookname = new String[result.size()];
        		String[] author = new String[result.size()];
        		String[] isbn = new String[result.size()];
        		Float[] price = new Float[result.size()];
        		String[] genre = new String[result.size()];
        		for(int i=0;i<result.size();i++){
        			bookname[i] = result.get(i).getBookname();
        			author[i] = result.get(i).getAuthor();
        			isbn[i] = result.get(i).getISBN();
        			price[i] = result.get(i).getPrice();
        			genre[i] = result.get(i).getGenredesc();	
        		}
        		request.setAttribute("username",CustName);
        		request.setAttribute("bookname",bookname);
        		request.setAttribute("author",author);
        		request.setAttribute("isbn",isbn);
        		request.setAttribute("price",price);
        		request.setAttribute("genre",genre);
    			RequestDispatcher rd=request.getRequestDispatcher("showresult.jsp");    
                rd.forward(request,response);
        	}
        	else if(selectedValue.equalsIgnoreCase("Search by Author")){
        		String CustName = request.getParameter("username");
        		result = LoginDao.SearchByAuthor(request.getParameter("author"));
        		String[] bookname = new String[result.size()];
        		String[] author = new String[result.size()];
        		String[] isbn = new String[result.size()];
        		Float[] price = new Float[result.size()];
        		String[] genre = new String[result.size()];
        		for(int i=0;i<result.size();i++){
        			bookname[i] = result.get(i).getBookname();
        			author[i] = result.get(i).getAuthor();
        			isbn[i] = result.get(i).getISBN();
        			price[i] = result.get(i).getPrice();
        			genre[i] = result.get(i).getGenredesc();	
        		}
        		request.setAttribute("username",CustName);
        		request.setAttribute("bookname",bookname);
        		request.setAttribute("author",author);
        		request.setAttribute("isbn",isbn);
        		request.setAttribute("price",price);
        		request.setAttribute("genre",genre);
    			RequestDispatcher rd=request.getRequestDispatcher("showresult.jsp");    
                rd.forward(request,response);
        	}
        }
        
        else if(selectedValue.equalsIgnoreCase("Search by Book Name") || selectedValue.equalsIgnoreCase("Search by Book ISBN") || selectedValue.equalsIgnoreCase("Search by Book Author")){
        	ArrayList<MBook> result = new ArrayList<MBook>();
        	if(selectedValue.equalsIgnoreCase("Search by Book Name")){
        		String CustName = request.getParameter("username");
        		String quantity = request.getParameter("quantity");
        		result = LoginDao.SearchByName(request.getParameter("bookname"));
        		String[] bookname = new String[result.size()];
        		String[] author = new String[result.size()];
        		String[] isbn = new String[result.size()];
        		Float[] price = new Float[result.size()];
        		String[] genre = new String[result.size()];
        		for(int i=0;i<result.size();i++){
        			bookname[i] = result.get(i).getBookname();
        			author[i] = result.get(i).getAuthor();
        			isbn[i] = result.get(i).getISBN();
        			price[i] = result.get(i).getPrice();
        			genre[i] = result.get(i).getGenredesc();	
        		}
        		request.setAttribute("username",CustName);
        		request.setAttribute("quantity", quantity);
        		request.setAttribute("bookname",bookname);
        		request.setAttribute("author",author);
        		request.setAttribute("isbn",isbn);
        		request.setAttribute("price",price);
        		request.setAttribute("genre",genre);
    			RequestDispatcher rd=request.getRequestDispatcher("showResultone.jsp");    
                rd.forward(request,response);
        		
        	}
        	else if(selectedValue.equalsIgnoreCase("Search by Book ISBN")){
        		String CustName = request.getParameter("username");
        		String quantity = request.getParameter("quantity");
        		result = LoginDao.SearchByISBN(request.getParameter("isbn"));
        		String[] bookname = new String[result.size()];
        		String[] author = new String[result.size()];
        		String[] isbn = new String[result.size()];
        		Float[] price = new Float[result.size()];
        		String[] genre = new String[result.size()];
        		for(int i=0;i<result.size();i++){
        			bookname[i] = result.get(i).getBookname();
        			author[i] = result.get(i).getAuthor();
        			isbn[i] = result.get(i).getISBN();
        			price[i] = result.get(i).getPrice();
        			genre[i] = result.get(i).getGenredesc();	
        		}
        		request.setAttribute("username",CustName);
        		request.setAttribute("quantity", quantity);
        		request.setAttribute("bookname",bookname);
        		request.setAttribute("author",author);
        		request.setAttribute("isbn",isbn);
        		request.setAttribute("price",price);
        		request.setAttribute("genre",genre);
    			RequestDispatcher rd=request.getRequestDispatcher("showResultone.jsp");    
                rd.forward(request,response);
        	}
        	else if(selectedValue.equalsIgnoreCase("Search by Book Author")){
        		String CustName = request.getParameter("username");
        		String quantity = request.getParameter("quantity");
        		result = LoginDao.SearchByAuthor(request.getParameter("author"));
        		String[] bookname = new String[result.size()];
        		String[] author = new String[result.size()];
        		String[] isbn = new String[result.size()];
        		Float[] price = new Float[result.size()];
        		String[] genre = new String[result.size()];
        		for(int i=0;i<result.size();i++){
        			bookname[i] = result.get(i).getBookname();
        			author[i] = result.get(i).getAuthor();
        			isbn[i] = result.get(i).getISBN();
        			price[i] = result.get(i).getPrice();
        			genre[i] = result.get(i).getGenredesc();	
        		}
        		request.setAttribute("username",CustName);
        		request.setAttribute("quantity", quantity);
        		request.setAttribute("bookname",bookname);
        		request.setAttribute("author",author);
        		request.setAttribute("isbn",isbn);
        		request.setAttribute("price",price);
        		request.setAttribute("genre",genre);
    			RequestDispatcher rd=request.getRequestDispatcher("showResultone.jsp");    
                rd.forward(request,response);
        	}
        }
        else if(selectedValue.equalsIgnoreCase("See Details")){
        	MBook result = new MBook();
    		String CustName = request.getParameter("username");
    		
    		result = LoginDao.CompleteDetails(request.getParameter("isbn"));
    		request.setAttribute("username",CustName);
    		request.setAttribute("bookid", result.getBookid());
    		request.setAttribute("bookname",result.getBookname());
    		request.setAttribute("author",result.getAuthor());
    		request.setAttribute("isbn",result.getISBN());
    		request.setAttribute("price",result.getPrice());
    		request.setAttribute("genre",result.getGenredesc());
    		request.setAttribute("Publication", result.getPublicationName());
    		request.setAttribute("check", result.getIsInventory());
    		String mgs;
    		if(result.getIsInventory()==0){
    			mgs="Not in stock";
    		}
    		else{
    			mgs="Available";
    		}
    		request.setAttribute("IsInventory", mgs);
    		request.setAttribute("language", result.getLanguageName());
			RequestDispatcher rd=request.getRequestDispatcher("CompleteBook.jsp");    
            rd.forward(request,response);
    	}
        
        else if(selectedValue.equalsIgnoreCase("See Book Details")){
        	MBook result = new MBook();
    		String CustName = request.getParameter("username");
    		String quantity = request.getParameter("quantity");
    		result = LoginDao.CompleteDetails(request.getParameter("isbn"));
    		request.setAttribute("username",CustName);
    		request.setAttribute("bookid", result.getBookid());
    		request.setAttribute("bookname",result.getBookname());
    		request.setAttribute("author",result.getAuthor());
    		request.setAttribute("isbn",result.getISBN());
    		request.setAttribute("price",result.getPrice());
    		request.setAttribute("genre",result.getGenredesc());
    		request.setAttribute("Publication", result.getPublicationName());
    		request.setAttribute("check", result.getIsInventory());
    		String mgs;
    		if(result.getIsInventory()==0){
    			mgs="Not in stock";
    		}
    		else{
    			mgs="Available";
    		}
    		request.setAttribute("IsInventory", mgs);
    		request.setAttribute("language", result.getLanguageName());
			RequestDispatcher rd=request.getRequestDispatcher("CompleteBookone.jsp");    
            rd.forward(request,response);
    	}
        
        else if(selectedValue.equalsIgnoreCase("Add to Cart")){
        	MBook book = new MBook();
        	Cart Custcart = (Cart) (request.getSession(false).getAttribute("cart"));
        	System.out.println("Add to cart method :"+Custcart.cart.size());
        	
    		String emailid = request.getParameter("username");
    		String bookname = request.getParameter("bookname");
    		int bookid = Integer.parseInt(request.getParameter("bookid"));
    		String isbn = request.getParameter("isbn");
    		float price = Float.parseFloat(request.getParameter("price"));
    		int quantity = Integer.parseInt(request.getParameter("quantity"));
    		
    		book.setBookid(bookid);
    		book.setBookname(bookname);
    		book.setISBN(isbn);
    		book.setPrice(price);
    		book.setQuantity(quantity);
    		
    		
    		System.out.println(Custcart.cart.size());
    		System.out.println("Add to cart method after adding :"+Custcart.cart.size());
    		Custcart.cart.add(book);
    		HttpSession session = request.getSession(false);
    		session.setAttribute("cart", Custcart);
    		int i = Custcart.cart.size();
    		System.out.println("check "+i);
    		System.out.print(Custcart.cart.size());
    		request.setAttribute("name", emailid);
    		request.setAttribute("items", i);
    		RequestDispatcher rd=request.getRequestDispatcher("Customercart.jsp");    
            rd.forward(request,response);
    	}
        
        else if(selectedValue.equalsIgnoreCase("See Cart")){
        	Cart Custcart = (Cart) (request.getSession(false).getAttribute("cart"));
        	System.out.println("Final cart :"+Custcart.cart.size());
        	String[] Bookname = new String[3];
        	String[] ISBN = new String[3];
        	Float[] price = new Float[3];
        	Integer[] quantity = new Integer[3];
        	Float[] totalprice = new Float[3];
        	float totalPayment=0;
        	for(int k=0;k<Custcart.cart.size();k++){
        		Bookname[k] = Custcart.cart.get(k).getBookname();
        		System.out.println("Book name :"+Bookname[k]);
        		ISBN[k] = Custcart.cart.get(k).getISBN();
        		price[k] = Custcart.cart.get(k).getPrice();
        		quantity[k] = Custcart.cart.get(k).getQuantity();
        		totalprice[k] = price[k]*quantity[k];
        		totalPayment = totalPayment+totalprice[k];
        	}
        	Cart.setTotalPaymentl(totalPayment);
        	request.setAttribute("bookname",Bookname);
    		request.setAttribute("isbn", ISBN);
    		request.setAttribute("price",price);
    		request.setAttribute("quantity",quantity);
    		request.setAttribute("totalprice",totalprice);
    		request.setAttribute("totalPayment", totalPayment);
     		RequestDispatcher rd=request.getRequestDispatcher("Mycart.jsp");    
            rd.forward(request,response);
    	}
        else if(selectedValue.equalsIgnoreCase("Make Payment")){
        	Cart Custcart = (Cart) (request.getSession(false).getAttribute("cart"));
        	int makepayment = Integer.parseInt(request.getParameter("payment"));
        	Cart.setMakepaymentflg(makepayment);
        	System.out.println("Final cart :"+Custcart.cart.size());
        	System.out.print("Toatal payment :" +Cart.getTotalPaymentl());
        	LoginDao.transaction(Custcart);
     		RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");    
            rd.forward(request,response);
    	}
        out.close();
	}
}


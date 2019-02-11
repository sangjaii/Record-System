package bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.rmi.server.Dispatcher;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/show-order.jsp";
		ShoppingCart cart;
		ArrayList<Book> books;
		
		// Get the session object, making sure that the user cannot access this servlet directly
		// If the user attempts to accesses this servlet directly, forward the user to he/she
		// SearchBook.html.
			
		
		HttpSession session=request.getSession(true);
		if(session.isNew())
		{
			ServletContext context = getServletContext();			
			RequestDispatcher dispatch= context.getRequestDispatcher("/Searchbooks.html");
			dispatch.forward(request, response);
			return;
		}
		  	
		
		// Get the ShoppingCart object (namely cart) from the session object. 
		// If cart is null, create a new ShoppingCart object and create an
		// association between the String "bookstore.cart" and the newly created object.
		
		cart=(ShoppingCart)session.getAttribute("bookstore.cart");
		if(cart == null)
		{
			cart = new ShoppingCart();
			session.setAttribute("bookstore.cart", cart);
		}
		/* Put your code here */

		// Get the ArrayList object (namely books) from the session object. This ArrayList
		// object, which was created in QueryServlet.class, contains the book objects that
		// match the search criteria specified in SearchBook.html
		
		books = (ArrayList<Book>)session.getAttribute("foundBooks");
		int term = Integer.parseInt(request.getParameter("Cartitem"));
		cart.addBook(books.get(term));
		session.setAttribute("bookstore.cart", cart);
		
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		/* Put your code here */
		
		// Get the index of the selected book from BookInfo.jsp
		
		/* Put your code here */
		
		// Add the the selected book object to the Shopping cart 
		
		/* Put your code here */
		
		// Forward the control to either show-order.jsp or SearchBook.html
		
		/* Put your code here */

	}

	private HttpSession getSession(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}

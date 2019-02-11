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

/**
 * Servlet implementation class GetAll
 */
@WebServlet("/GetAll")
public class GetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		java.sql.Connection connection = null; // manages connection
		java.sql.Statement statement = null; // query statement
		java.sql.ResultSet resultSet = null; // manages results
		String DATABASE_URL = "jdbc:mysql://localhost:3306/books?serverTimezone=UTC  ";
		ArrayList<Book> getAllBook = new ArrayList<Book>();
		
		HttpSession session = request.getSession(true);


		/*
		 * 	Specify to the DriverManager which JDBC drivers to try to make Connections with.
		 */
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// connect to database books and query database
		try {		
			
			// establish connection to database
			connection = java.sql.DriverManager.getConnection(DATABASE_URL, "guest", "guest");

			// create Statement for querying database
			statement = connection.createStatement();

			// query database
			String query = "SELECT * FROM bookinfo";
			System.out.println(query);
			resultSet = statement.executeQuery(query);

			// process query results
			while (resultSet.next() == true) {
				String isbn = (String) resultSet.getObject(1);
				String title = (String) resultSet.getObject(2);
				String author = (String) resultSet.getObject(3);
				int edition = (Integer)resultSet.getObject(4);
				String publisher = (String)resultSet.getObject(5);
				String copyright = (String)resultSet.getObject(6);
				double price = (Double)resultSet.getObject(7);
				getAllBook.add(new Book(isbn, author, title, price, edition, publisher, copyright));
				System.out.println(title + "; " + edition + "; " + publisher + "; " + copyright);
			}
			session.setAttribute("getAllBook", getAllBook);
			String url = "/displayAllBook.jsp";
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher(url);
			dispatcher.forward(request, response);			
		} // end try
		catch (java.sql.SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally // ensure resultSet, statement and connection are closed
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} // end try
			catch (Exception exception) {
				exception.printStackTrace();
			} // end catch
		} // end finally		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

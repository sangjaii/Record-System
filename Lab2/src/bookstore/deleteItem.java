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
 * Servlet implementation class deleteItem
 */
@WebServlet("/deleteItem")
public class deleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isbn = request.getParameter("ISBN");
		PrintWriter out = response.getWriter();
		out.print("HI");
		
		java.sql.Connection connection = null; // manages connection
		java.sql.Statement statement = null; // query statement
		int resultSet = 0; // manages results
		String DATABASE_URL = "jdbc:mysql://localhost:3306/books?serverTimezone=UTC  ";


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
		
		out.print("MIDDLE");
		// connect to database books and query database
		try {		
			
			// establish connection to database
			connection = java.sql.DriverManager.getConnection(DATABASE_URL, "guest", "guest");

			// create Statement for querying database	
			statement = connection.createStatement();

			out.print("1");
			// query database
			String query = "DELETE FROM bookinfo WHERE ISBN="  + isbn ;
			System.out.println(query);
			resultSet = statement.executeUpdate(query);

			
			out.println("BYE");
			String url = "/GetAll";
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

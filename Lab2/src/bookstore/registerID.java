package bookstore;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerID")
public class registerID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerID() {
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
		
		java.sql.Connection connection = null; // manages connection
		java.sql.Statement statement = null; // query statement
		int resultSet = 0; // manages results
		String DATABASE_URL = "jdbc:mysql://localhost:3306/login?serverTimezone=UTC  ";
		String ID = (String) request.getParameter("userID");
		String PW = (String) request.getParameter("userPW");
		
		
		//check user whether session is existed.
		HttpSession session = request.getSession(true);
		if(session.isNew())
		{
		PrintWriter out = response.getWriter();
		String str = "";
		str += "You cannot access this page directly!<br>\n";
		str += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><br>\n";
		str += "<meta http-equiv=\"Refresh\" content=\"2; url=login.html\"><br>\n";
		out.print(str);
		out.close();
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/login.html");
		dispatcher.forward(request, response);	
		}
		
		

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
		
		
		try {		
			
			// establish connection to database
			connection = java.sql.DriverManager.getConnection(DATABASE_URL, "guest", "guest");

			// create Statement for querying database	
			statement = connection.createStatement();

			// query database
			String query = "INSERT INTO login(ID,password)  VALUES(" + "'" + ID + "' , '" + PW + "')";
			System.out.println(query);
			resultSet = statement.executeUpdate(query);

			
			String url = "/SearchBook.jsp";
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

}

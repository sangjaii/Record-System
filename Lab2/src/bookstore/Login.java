package bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		java.sql.ResultSet resultSet = null; // manages results
		String DATABASE_URL = "jdbc:mysql://localhost:3306/login?serverTimezone=UTC  ";
		String ID=null;
		String PW=null;
		String userInputID = (String) request.getParameter("ID");
		String userInputPW = (String) request.getParameter("password");
		
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
		
		
		try
		{
			connection = java.sql.DriverManager.getConnection(DATABASE_URL, "guest", "guest");
			statement = connection.createStatement();
			
			String query = "SELECT * FROM LOGIN WHERE ID=" + "'" + userInputID + "'" ;
			System.out.print(query);
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next() == true)
			{
				ID=resultSet.getString(1);
				PW=resultSet.getString(2);
			}
			
			if(ID.equals(userInputID)&& PW.equals(userInputPW))
			{
				PrintWriter out = response.getWriter();
				session.setAttribute("UserID", ID);
				session.setAttribute("logined", true);
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/SearchBook.jsp");
				dispatcher.forward(request, response);					
			}
			else
			{
				PrintWriter out = response.getWriter();
				String wrong = "";
				wrong += "Wrong ID or PassWord!<br>\n";
				wrong += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><br>\n";
				wrong += "<meta http-equiv=\"Refresh\" content=\"3; url=login.html\"><br>\n";
				out.print(wrong);
				out.close();
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/login.html");
				dispatcher.forward(request, response);	
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} // end try
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		
		
		
		
	}

}

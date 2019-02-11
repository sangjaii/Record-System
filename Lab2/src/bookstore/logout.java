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
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if(session.isNew())
		{
			PrintWriter out = response.getWriter();
			String str="";
			str += "You cannot access this page directly!<br>\n";
			str += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><br>\n";
			str += "<meta http-equiv=\"Refresh\" content=\"2; url=login.html\"><br>\n";
			out.print(str);
			out.close();
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/login.html");
			dispatcher.forward(request, response);	
		}
		
		session.setAttribute("logined", false);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/SearchBook.jsp");
		dispatcher.forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

//Name = Poon Yin Sang Bernie Yu Ho Lam 
//Student Number = 17050056D 17052524D
package bookstore;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceiptServlet
 */
@WebServlet("/ReceiptServlet")
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String customerName = request.getParameter("customerName");
		PrintWriter out = response.getWriter();		
		/*
		 * Assume perform credit card transaction here
		 */		
		String outStr = "";
		outStr += "Dear " + customerName + " , thanks for purchasing books from BookStore<br>\n";
		outStr += "This page will be automatically go back to SearchBook.html<br>\n";
		outStr += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><br>\n";
		outStr += "<meta http-equiv=\"Refresh\" content=\"5; url=Searchbooks.html\"><br>\n";
		outStr += "<br><br>";
		outStr += "Student Name: Poon Yin Sang Bernie Yu Ho Lam <br>\r\n" + "Student ID: 17050056D 17052524D<br>";
		out.print(outStr);
		out.close();		
	}

}

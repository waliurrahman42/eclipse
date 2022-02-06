package myservalate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeFirst
 */
@WebServlet("/WelcomeFirst")
public class WelcomeFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		String u="wali";
		int pass=1234;
		
		
		String user=request.getParameter("uname");
		String password=request.getParameter("upass");
		 int p=Integer.parseInt(password);
		
		
				PrintWriter out= response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>welcome to servalate</h1>");
				out.println("<h2>welcome user  "+user+"</h2>");
				out.println("<h2>welcome user   "+password+"</h2>");
				out.println("</body>");
				out.println("</html>");
			
		
		if(u.equals(user) && (pass==p)) {
			  RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
			 // rd.forward(request, response);
			  rd.include(request, response);
		 }
		else {
			response.sendRedirect("https://www.google.com");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

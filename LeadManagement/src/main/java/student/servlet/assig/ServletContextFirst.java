package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextFirst
 */
@WebServlet("/ServletContextFirst")
public class ServletContextFirst extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletContext context = getServletContext();
		context.setAttribute("PORT", 3306);
		
		
		String drivername = context.getInitParameter("Driver");
		
		Enumeration<String> parameternames=context.getInitParameterNames();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h4>"+drivername+"</h4>");
		while(parameternames.hasMoreElements()) {
			String parametername=parameternames.nextElement();
			out.println("<h4>"+parametername+"</h4>");
		}
		out.println("</html>");
		out.println("</body>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

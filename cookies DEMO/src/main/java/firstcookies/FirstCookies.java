package firstcookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstCookies
 */
@WebServlet("/FirstCookies")
public class FirstCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
//	    String id="wali";
//		String pwrd="wali12";
		
		String user=request.getParameter("uname").trim();
		String pass=request.getParameter("upass").trim();
		
			//creating cookies......
		Cookie ncookie = new Cookie("username", user);
		Cookie pcookie = new Cookie("password", pass);
		
		//set expirey date after 12hrs
		ncookie.setMaxAge(60*60*12);
		pcookie.setMaxAge(60*60*12);
		
		//adding cookie in response
		response.addCookie(ncookie);
		response.addCookie(pcookie);
		
		String title="stting cookies";
		out.println("<html><head><title>"+title+"</title>");
			out.println("</head><body bgcolor=\"#ff9988\">");
		
				out.println("<h1> hello </h1>");
				out.println("<ul>");
					out.println("<li>"+user +"</li>");
					out.println("<li>"+pass +"</li>");
				out.println("</ul>");
			
	
		out.println("</body></html>");
		
		
		
		
		
		
		
//		if(user.equals(id) && pass.equals(pwrd)) {
//			out.println("login!!!! success........");
//			
//		}
//		else {
//			out.println("invalid login");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

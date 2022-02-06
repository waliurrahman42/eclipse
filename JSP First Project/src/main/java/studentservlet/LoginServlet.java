package studentservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("user");
		String upass=request.getParameter("pass");
		
		if(request.getParameterValues("remember") != null)
		{
			Cookie ncookie = new Cookie("username",uname );
			Cookie pcookie = new Cookie("password",upass);
			
			ncookie.setMaxAge(180);
			pcookie.setMaxAge(180);
			
			response.addCookie(ncookie);
			response.addCookie(pcookie);
				
		}
		
		if(DbService.stdlogin(uname, upass)) {
		    
			HttpSession hs = request.getSession(); 
			hs.setAttribute("name",uname);
			hs.setAttribute("pass", upass);
			
			RequestDispatcher rd= request.getRequestDispatcher("ViewStudent.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", "invalid username or password");
			rd.forward(request, response);
		}
		
	}

}

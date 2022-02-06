package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbService;
/**
 * Servlet implementation class StudentLogin
 */

public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		int user=Integer.parseInt(request.getParameter("uid").trim());
		String password=request.getParameter("upass");
		
		if(DbService.stdlogin(user, password)) {
			out.println("login success!!!!!!!!!");
			out.println("***************welcome*************** : ");
			HttpSession hs = request.getSession();
			  
			  hs.setAttribute("name",user);
			  hs.setAttribute("pass", password);
			  
			  RequestDispatcher rd = request.getRequestDispatcher("ViewAllStudent");
			  rd.forward(request, response);
			
		}
		
		else {
			//  response.sendRedirect("index.html");
			  RequestDispatcher rd = request.getRequestDispatcher("InvalidLoginPage");
			  request.setAttribute("msg","invaid user name or password");
			  rd.forward(request, response);
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


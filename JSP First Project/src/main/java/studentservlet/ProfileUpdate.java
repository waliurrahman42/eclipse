package studentservlet;

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
 * Servlet implementation class ProfileUpdate
 */
@WebServlet("/ProfileUpdate")
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
		HttpSession hs = request.getSession(false);
		if (hs!=null) {
				  // getting value from session object
			int id =(int) hs.getAttribute("uid");
			
			String name =request.getParameter("uname");
			String pass =request.getParameter("upass");
			String dept =request.getParameter("udept");
			int status =Integer.parseInt(request.getParameter("ustatus"));
			//int id=Integer.parseInt(request.getParameter("uid"));
			
			
			int res= DbService.updateData(id, name, pass, dept, status);
			if(res>0) {
				RequestDispatcher rd= request.getRequestDispatcher("ViewStudent.jsp");
				request.setAttribute("msg1", "Data Updated Of Roll No "+id+"");
				rd.forward(request, response);
			}
	
		}
	
	}

}

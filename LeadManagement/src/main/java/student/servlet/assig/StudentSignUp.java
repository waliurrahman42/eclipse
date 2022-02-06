package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;



/**
 * Servlet implementation class signUpServarlet
 */
@WebServlet("/StudentSignUp")
public class StudentSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("sid").trim());
		String pass=request.getParameter("spass");
		String name=request.getParameter("sname");
		String dept=request.getParameter("sdept");
		
		int i=DbService.inserData(id, name, pass, dept);
		if(i>0) {
			 RequestDispatcher rd = request.getRequestDispatcher("InvalidLoginPage");
			 request.setAttribute("msg2","signUp success now u can login");
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
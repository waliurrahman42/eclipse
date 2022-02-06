package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;

/**
 * Servlet implementation class RemoveStudent
 */
@WebServlet("/RemoveStudent")
public class RemoveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id").trim());
		
		//fetching value of port no which is set on servletContextFirst page
		ServletContext context=getServletContext();
		
		int res =DbService.deleteData(id);
		if(res>0) {
			out.print("student is removed");
			int port=(int)context.getAttribute("PORT");
			out.println("server is running on port no"+port);
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

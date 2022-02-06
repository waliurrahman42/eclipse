package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id").trim());
//		out.print("<html><body>");
//		out.print("<form>");
//		out.print("<input type=text name="+id+"  placeholder="+id+" disabled>");
//		out.print("</form>");
//		out.print("</body></html>");
//		
		
//		int res =DbService.updateData(id);
//		if(res>0) {
//			out.print("student is updated");
//			DbService.searchByid(id);
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

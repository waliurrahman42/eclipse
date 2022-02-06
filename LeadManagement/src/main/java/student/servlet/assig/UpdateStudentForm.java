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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudentForm")
public class UpdateStudentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id").trim());
		
			HttpSession hs = request.getSession();
			hs.setAttribute("uid",id);
			  
			
			ResultSet rs=DbService.searchByid(id);
			try {
				while (rs.next()) {
				out.print("<html><body>");
					out.print("<form action=ProfileUpdate>");
						//out.println("user id: <input type=text name=uid value="+id+"   readonly><br>");
						out.println("name: <input type=text name=uname value="+rs.getString(2)+"  ><br>");
						out.println("user password : <input type=text name=upass  value="+rs.getString(3)+" ><br>");
						out.println("department : <input type=text name=udept  value="+rs.getString(4)+" ><br>");
						out.println("user status :<input type=text name=ustatus value="+rs.getInt(5)+"  ><br>");
						
						out.println("<input type=submit value=update ><br>");
					out.print("</form>");
				out.print("</body></html>");
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
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

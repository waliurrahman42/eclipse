package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		//int id=Integer.parseInt(request.getParameter("uid"));
		HttpSession hs = request.getSession(false);
		if (hs!=null) {
			  // getting value from session object
		int id =(int) hs.getAttribute("uid");
		
		String name =request.getParameter("uname");
		String pass =request.getParameter("upass");
		String dept =request.getParameter("udept");
		int status =Integer.parseInt(request.getParameter("ustatus"));
		
		out.println("update page servlet");
		
		int res= DbService.updateData(id, name, pass, dept, status);
		if(res>0) {
			out.println("student is updated");
			ResultSet rs=DbService.fetchData();
			out.println("<html> <body>");
			out.println("<table border=1>");
			out.println("<tr>");
			out.print("<th> Roll No </th>");
			out.print("<th> Student Name </th>");
			out.print("<th> Student Password </th>");
			out.print("<th> Student Dept </th>");
			out.print("<th> Student Status </th>");
			out.println("</tr>");
			try {
				while(rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt(1)+"</td>") ;
					out.print("<td>"+rs.getString(2)+"</td>") ;
					out.print("<td>"+rs.getString(3)+"</td>") ;
					out.print("<td>"+rs.getString(4)+"</td>") ;
					out.print("<td>"+rs.getInt(5)+"</td>") ;
					out.print("<td><a href=RemoveStudent?id="+rs.getInt(1)+"&name="+rs.getString(2)+">Delete</a> </td>") ;
					out.print("<td><a href=UpdateStudentForm?id="+rs.getInt(1)+"&name="+rs.getString(2)+">UPDATE</a> </td>") ;
					out.print("</tr>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.println("</table>");
			out.println("<a href=\"login.html\"><button>login</button></a>");
			
			out.println("</body> </html>");
			}
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

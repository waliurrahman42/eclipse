package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;

/**
 * Servlet implementation class ViewAllStudentServlet
 */
@WebServlet("/ViewAllStudentServlet")
public class ViewAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		ResultSet rs =DbService.fetchData();
		out.println("<html> <body>");
		out.println("<table >");
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
				out.print("<td><a href=RemoveStudent1?id="+rs.getInt(1)+"&name="+rs.getString(2)+">Delete</a> </td>") ;
				out.print("</tr>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</body> </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package state;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchData
 */
@WebServlet("/SearchData")
public class SearchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=request.getParameter("name");
		String uname=request.getParameter("uname");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		
		try {
			ResultSet rs=StateDbservice.fetchUsingUserName(name);
			StringBuilder sb=new StringBuilder();
			while(rs.next()){ 
				sb.append("<tr> <td>"+rs.getString(1)+"</td>"
							  +"<td>"+rs.getString(2)+"</td>"
						      +"<td>"+rs.getString(3)+"</td>"
						      +"<td>"+rs.getString(4)+"</td>"
						  +"</tr>");
			}
			response.getWriter().println(sb.toString());
		} catch (Exception e) {
			
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

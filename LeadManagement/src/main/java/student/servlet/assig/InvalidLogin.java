package student.servlet.assig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InvalidLogin
 */
@WebServlet("/InvalidLoginPage")
public class InvalidLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=  response.getWriter();
			 
			  out.println("<html>");
			  out.println("<body>");
				  out.println("<form action=invalidLogin>");
					  out.println("<input type =text name=uid > <br>");
					  out.println("<input type =text name=upass > <br>");
					  out.println("<input type =submit value=Login > <br>");
				  out.println("</form>");
			  out.println("</body>");
			  out.println("</html>");
			  
			  String msg =(String) request.getAttribute("msg");
		  
		  if(msg!=null) {
			  out.println(msg);
		  }
		  String msg1 =(String) request.getAttribute("msg1");
		  
		  if(msg1!=null) {
			  out.println(msg1);
		  }
		  String msg2 =(String) request.getAttribute("msg2");
		  
		  if(msg2!=null) {
			  out.println(msg2);
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

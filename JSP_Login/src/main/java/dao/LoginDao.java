package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mybeans.LoginBean;

public class LoginDao {
	
	static Connection con=null;
	
	public static  Connection getDbConnection() {
		 String user = "root";
		 String password = "Waliur#12";
		 String dbName = "cdac";
		 String url="jdbc:mysql://localhost:3306/"+dbName;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, user, password);	
			}
			catch (ClassNotFoundException e) {
				System.out.println("driver class not found "+e);
			}
			catch(SQLException e) {
				System.err.println("Sql execption while Connection"+e);
			}
		 return con;
	}
	
	//login stutend
	public static  String stdlogin(LoginBean loginBean) {
		
		try {
				Connection con =getDbConnection();
				PreparedStatement ps=con.prepareStatement("select * from student where sname=?  and spass=?");
				ps.setString(1,loginBean.getName());
				ps.setString(2,loginBean.getPassword());
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					return "true";
				}
				
		}
		catch(SQLException e) {
			 System.err.println("exception while stdlogin student"+e);
		}
		return "false";
				
	}

}

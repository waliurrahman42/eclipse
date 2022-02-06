package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class DbService {


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
	
	
	//insert data
	public static int inserData(int id, String name, String pass, String dept) {
		
		int i=0;
		try {
			
			Connection con =getDbConnection();
			String query="insert into student values (?,?,?,?,?)";
			PreparedStatement ps= con.prepareStatement(query);
			 
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, pass);
			ps.setString(4, dept);
			ps.setInt(5,0);
			i=ps.executeUpdate();
		}
		catch(SQLException e){
			System.out.println("execption while adding "+e);
		}
	
		 return i;
	}

	//fetch data
	
	public static ResultSet fetchData() {
		ResultSet rs=null;
			try {
				Connection con =getDbConnection();
				String query="select * from student"; 
				 PreparedStatement ps = con.prepareStatement(query);
				 rs = ps.executeQuery();
			}
			catch(SQLException e){
				System.out.println("execption while fetching data "+e);
			}
			return rs;
	}
	
	
	// delete data
	public static int deleteData(int id) {
		int  i=0;
		try {
			Connection con =getDbConnection();
			String query="DELETE FROM student where sid=?"; 
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,id);
			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			 System.err.println("exception while removing student"+e);
		}
		 return i;
	}
	
	
	//login
	public static  boolean stdlogin(int id,String pass) {
		boolean found = false;
		try {
				Connection con =getDbConnection();
				PreparedStatement ps=con.prepareStatement("select sname from student where sid=?  and spass=?");
				ps.setInt(1,id);
				ps.setString(2,pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
						found =true;
				}
		}
		catch(SQLException e) {
			 System.err.println("exception while removing student"+e);
		}
				return found;
	}
	//search by id
	public static ResultSet searchByid(int id) {
		ResultSet rs = null;
		try {
				Connection con =getDbConnection();
				PreparedStatement ps=con.prepareStatement("select * from student where sid=?");
				ps.setInt(1,id);
				rs=ps.executeQuery();
		}
		catch(SQLException e) {
			 System.err.println("exception while removing student"+e);
		}
				return rs;
	}	
	//update by id
	public static int updateData(int id, String name, String pass, String dept) {
		int  i = 0;
		try {
			Connection con =getDbConnection();
			PreparedStatement ps=con.prepareStatement("update student set sname=?, spass=?, sdept=?  WHERE sid=?");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setString(3, pass);
			ps.setString(4, dept);
			ps.setInt(5,0);

			i=ps.executeUpdate();
		}
		catch(SQLException e) {
			 System.err.println("exception while updating student"+e);
		}
				return i;
	}
}

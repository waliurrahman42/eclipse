package state;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mybeans.UserBean;

public class StateDbservice {

	static Connection con=null;

	//database connection
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

	//fetching state table on 
	public static ResultSet fetchStateData() {
		ResultSet rs = null;
		try {
			Connection con =getDbConnection();
			PreparedStatement ps=con.prepareStatement("select * from State_master ");
			rs=ps.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("exception while search Byid student"+e);
		}
		return rs;
	}	

	//fetching city details on the bassis of state id
	public static ResultSet fetchStatecity(String st) {
		ResultSet rs = null;
		try {
			Connection con =getDbConnection();
			PreparedStatement ps=con.prepareStatement("select * from city_master where city_state_id=? ");
			ps.setString(1,st);
			rs=ps.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("exception while search Byid city"+e);
		}
		return rs;
	}

	//insert data using beanclass
	public static int insertdata(UserBean us)  {
		Connection con =getDbConnection();
		int i=0;
		try {
			String query="insert into user_details values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,us.getFullname() );
			ps.setString(2,us.getUsername() );
			ps.setString(3,us.getPassword());
			ps.setInt(4,us.getDdlState() );
			ps.setInt(5,us.getDdlCity() );
			i=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	// fetch user details using inner join query
	public static ResultSet fetchUserDetail()  {
		Connection con =getDbConnection();
		ResultSet rs=null;
		try {
			String query="select ud.fullname,ud.username,sm.state_name,cm.city_name from user_details ud inner join state_master sm on ud.state_id=sm.state_id inner join city_master cm on ud.city_id=cm.city_id ";
			PreparedStatement ps=con.prepareStatement(query);
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}


	
	
	
	//search using  ajax by name
	public static ResultSet fetchUsingName(String name) {
		ResultSet rs = null;
		try {
			Connection con =getDbConnection();
			String query="select ud.fullname,ud.username,sm.state_name,cm.city_name from user_details ud inner join state_master sm on ud.state_id=sm.state_id inner join city_master cm on ud.city_id=cm.city_id where fullname like ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,name+"%");
			rs=ps.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("exception while search By name using join "+e);
		}
		return rs;
	}
	//search using  ajax by username
	public static ResultSet fetchUsingUserName(String uname) {
			ResultSet rs = null;
			try {
				Connection con =getDbConnection();
				String query="select ud.fullname,ud.username,sm.state_name,cm.city_name from user_details ud inner join state_master sm on ud.state_id=sm.state_id inner join city_master cm on ud.city_id=cm.city_id where username like ?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,uname+"%");
				rs=ps.executeQuery();
			}
			catch(SQLException e) {
				System.err.println("exception while search By name using join "+e);
			}
			return rs;
	}
	//search using  ajax by state
	public static ResultSet fetchUsingState(String state) {
			ResultSet rs = null;
			try {
				Connection con =getDbConnection();
				String query="select ud.fullname,ud.username,sm.state_name,cm.city_name from user_details ud inner join state_master sm on ud.state_id=sm.state_id inner join city_master cm on ud.city_id=cm.city_id where state_name = ?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,state);
				rs=ps.executeQuery();
			}
			catch(SQLException e) {
				System.err.println("exception while search By name using join "+e);
			}
			return rs;
	}
		
	//search using  ajax by city	
	public static ResultSet fetchUsingCity(String city ) {
		ResultSet rs = null;
		try {
			Connection con =getDbConnection();
			String query="select ud.fullname,ud.username,sm.state_name,cm.city_name from user_details ud inner join state_master sm on ud.state_id=sm.state_id inner join city_master cm on ud.city_id=cm.city_id where city_name = ?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,city);
			rs=ps.executeQuery();
		}
		catch(SQLException e) {
			System.err.println("exception while search By name using join "+e);
		}
		return rs;
	}
	
}

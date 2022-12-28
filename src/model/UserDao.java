package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao{

		
		private String url="jdbc:mysql://localhost:3306/salonDB";
		private String uname="root";
		private String pass="abc123";
		private Connection con;
	private Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection(url,uname,pass);
		
		return con;
	}
		
		
		public int reguser(MyUser u) throws ClassNotFoundException, SQLException
		{
			con = getConnection();
			String sql = "insert into booking_tbl(username, name, email, password) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,u.getUsername());
			ps.setString(2,u.getName());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getPass());
			
			int a = ps.executeUpdate();	
			return a;
		}
		public boolean checkEmail(String email) throws ClassNotFoundException, SQLException
		{
			con = getConnection();
			String sql = "SELECT * FROM booking_tbl WHERE email =?";
			PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ps.setString(1,email);
			
			
			ResultSet rs = ps.executeQuery();
			boolean a = rs.absolute(1);
//			PreparedStatement ps = getConnection().prepareStatement(arg0);
//			return ps.executeUpdate();
			return a;
		}
		public boolean checkUser(String email,String pass) throws ClassNotFoundException, SQLException
		{
			String sql="SELECT * FROM booking_tbl WHERE username=? and password=?";
			PreparedStatement ps=getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ps.setString(1,email);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			boolean a=rs.absolute(1);
			return a;
		}
		public int addservice(Addbooking u) throws ClassNotFoundException, SQLException
		{
			con = getConnection();
			String sql = "insert into addbooking(username, name, service, date, price, time) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1,u.getUsername());
			ps.setString(2,u.getName());
			ps.setString(3,u.getService());
			ps.setString(4,u.getDate());
			ps.setString(5,u.getPrice());
			ps.setString(6,u.getTime());
			
			int a = ps.executeUpdate();	
			return a;
		}
		

}

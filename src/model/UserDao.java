package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		
		public java.util.List<Addbooking> viewAllBooking() throws ClassNotFoundException, SQLException
		{
			String sql="SELECT * FROM Addbooking";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			java.util.List<Addbooking> ul=new ArrayList<Addbooking>();
			
			
			while(rs.next())
			{
				Addbooking p =new Addbooking();
				p.setBid(rs.getInt(1));
				p.setUsername(rs.getString(2));
				p.setName(rs.getString(3));
				p.setService(rs.getString(4));
				p.setDate(rs.getString(5));
				p.setPrice(rs.getString(6));
				p.setTime(rs.getString(7));

				
				ul.add(p);
			}
			

			return ul;
		}
		
		
		public java.util.List<Addbooking> viewUserBooking(String Username) throws ClassNotFoundException, SQLException
		{
			String sql="SELECT * FROM Addbooking WHERE Username=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, Username);
			ResultSet rs=ps.executeQuery();
			
			java.util.List<Addbooking> ul=new ArrayList<Addbooking>();
			
			
			while(rs.next())
			{
				Addbooking p =new Addbooking();
				p.setBid(rs.getInt(1));
				p.setUsername(rs.getString(2));
				p.setName(rs.getString(3));
				p.setService(rs.getString(4));
				p.setDate(rs.getString(5));
				p.setPrice(rs.getString(6));
				p.setTime(rs.getString(7));

				
				ul.add(p);
			}
			

			return ul;
		}
		public int deleteBooking(int Bid) throws ClassNotFoundException, SQLException
		{
			String sql="delete FROM Addbooking where Bid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
		    ps.setInt(1, Bid);
		
			int a=ps.executeUpdate();
		
			return a;
		}
		
		public Addbooking updateBooking(int Bid) throws ClassNotFoundException, SQLException
		{
			String sql="SELECT * FROM Addbooking where BId=?";
			PreparedStatement ps=getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		    ps.setInt(1, Bid);
		
			ResultSet a=ps.executeQuery();
			
			a.absolute(1);
			
			Addbooking p = new Addbooking();
			
			p.setBid(a.getInt(1));
			p.setUsername(a.getString(2));
			p.setName(a.getString(3));
			p.setService(a.getString(4));
			p.setDate(a.getString(5));
			p.setPrice(a.getString(6));
			p.setTime(a.getString(7));
		
			return p;
		}
		
		public int updateBookingData(int bid, String username, String name, String service, String date, String price, String time) throws ClassNotFoundException, SQLException
		{
			String sql="UPDATE Addbooking SET username=?, name=?, service=?, date=?, price =?, time=? WHERE bid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);		    
		    ps.setString(1,username);
		    ps.setString(2,name);
		    ps.setString(3,service);
		    ps.setString(4,date);
		    ps.setString(5,price);
		    ps.setString(6,time);
		    ps.setInt(7, bid);
		
			int a=ps.executeUpdate();
		
			return a;
		}
		public boolean checkadminUser(String email,String pass) throws ClassNotFoundException, SQLException
		{
			String sql="SELECT * FROM adminlogin WHERE username=? and password=?";
			PreparedStatement ps=getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			ps.setString(1,email);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			boolean a=rs.absolute(1);
			return a;
		}

}

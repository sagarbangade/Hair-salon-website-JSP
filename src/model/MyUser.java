package model;

public class MyUser {
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyUser(String username, String name, String email, String pass) {
		super();
		this.username = username;
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	public MyUser(int bid, String username, String name, String email, String pass) {
		super();
		this.bid = bid;
		this.username = username;
		this.name = name;
		this.email = email;
		this.pass = pass;
	}
	private int bid;
	private String username;
	private String name;
	private String email;
	private String pass;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}

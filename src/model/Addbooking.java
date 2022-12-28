package model;

public class Addbooking {
	private int bid;
	private String username;
	private String name;
	private String service;
	private String date;
	private String price;
	private String time;
	public Addbooking() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Addbooking(String username, String name, String service, String date, String price, String time) {
		super();
		this.username = username;
		this.name = name;
		this.service = service;
		this.date = date;
		this.price = price;
		this.time = time;
	}
	public Addbooking(int bid, String username, String name, String service, String date, String price, String time) {
		super();
		this.bid = bid;
		this.username = username;
		this.name = name;
		this.service = service;
		this.date = date;
		this.price = price;
		this.time = time;
	}

}

package model;

public class AddServices {
	private int sid;
	private String serviceName;
	private String servicePrice;
	public AddServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddServices(String serviceName, String servicePrice) {
		super();
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
	}
	public AddServices(int sid, String serviceName, String servicePrice) {
		super();
		this.sid = sid;
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
}

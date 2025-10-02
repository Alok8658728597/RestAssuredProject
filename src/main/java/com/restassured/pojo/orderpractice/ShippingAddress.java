package com.restassured.pojo.orderpractice;

public class ShippingAddress{
	private String line1;
	private String city;
	private String zip;
	
	public ShippingAddress(String line1,String city,String zip) {
		this.line1=line1;
		this.city=city;
		this.zip=zip;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
}
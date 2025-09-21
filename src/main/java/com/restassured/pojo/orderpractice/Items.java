package com.restassured.pojo.orderpractice;

public class Items{
	private String productId;
	private String name;
	private double price;
	private int quantity;
	private Attributes attributes;
	
	public Items(String productId,String name,double price,int quantity,Attributes attributes) {
		this.productId=productId;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.attributes=attributes;
	}
	public String getProductID() {
		return this.productId;
	}
	public void setProductID(String productId) {
		this.productId=productId;
	}
	public String getName() {
		return this.name;
	}
	public void setString(String name) {
		this.name=name;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public Attributes getAttributes() {
		return this.attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes=attributes;
		
	}
}

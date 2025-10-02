package com.restassured.pojo.orderpractice;

import java.util.List;

public class Customers{
	private String customerId;
	private String name;
	private List<String> emails;
	public Customers(String customerId,String name,List<String> emails) {
		this.customerId=customerId;
		this.name=name;
		this.emails=emails;
	}
	public List<String> getEmails(){
		return this.emails;
	}
	
	public void setEmails(List<String> emails) {
		this.emails=emails;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String cutomerId) {
		this.customerId = cutomerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	}
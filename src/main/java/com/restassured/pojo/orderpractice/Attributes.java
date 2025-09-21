package com.restassured.pojo.orderpractice;

import java.util.List;

public class Attributes{
	private String color;
	private List<String> features;
	
	public Attributes(String color,List<String> features) {
		this.color=color;
		this.features=features;
	}
	public String getColor() {
		return this.color;
	}
	public List<String> getFeatures(){
		return this.features;
	}
	public void setColor(String color) {
		this.color=color;
		
	}
	public void setFeatures(List<String> features) {
		this.features=features;
	}
}
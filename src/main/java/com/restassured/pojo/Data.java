package com.restassured.pojo;
/*{
"name": "Alok Itself",
"data": {
  "year": 2014,
  "price": 1849.99
}
}
Here we write inner data pojo
*In Java POJO, you should match the type of the value, not the key.
*wrong:private String year;
*right:private int year;
*/
public class Data{
	private int year;
	private double price;
	

public Data(int year,double price) {
	this.year=year;
	this.price=price;
}
 public int getYear() {
	 return this.year;
 }
 public void setYear(int year) {
	 this.year=year;
 }
 public double getPrice() {
	 return this.price;
 }
 public void setPrice(double price) {
	 this.price=price;
 }
}
//Setters are meant to set the value, not return it.
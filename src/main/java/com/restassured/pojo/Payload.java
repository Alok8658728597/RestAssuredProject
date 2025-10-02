package com.restassured.pojo;
/*{
"name": "Alok Itself",
"data": {
  "year": 2014,
  "price": 1204
}
}
Here we will write outer pojo
*/
public class Payload{
	private String name;
	private Data data;
	
	public Payload(String name,Data data) {
		this.name=name;
		this.data=data;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public Data getData() {
		return this.data;
	}
	public void setData(Data data) {
		 this.data=data;
	}
	
}
/*"payment": {
    "method": "net_banking",
    "amountPaid": 3997.00,
    "status": "SUCCESS"
  },*/
package com.restassured.pojo.orderpractice;
public class Payment{
	private String method;
	private double amountPaid;
	private String status;
	
	public Payment(String method,double amountPaid,String status) {
		this.method=method;
		this.amountPaid=amountPaid;
		this.status=status;
	}
	public String getMethod() {
		return this.method;
	}
	public void setMethod(String method) {
		this.method=method;
	}
	public double getamountPaid() {
		return this.amountPaid;
	}
	public void setamountPaid() {
		this.amountPaid=amountPaid;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus() {
		this.status=status;
	}
	
}

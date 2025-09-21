/*{
  "orderId": "ORD-20250921-003",
  "customer": {
    "customerId": "CUST-3003",
    "name": "Alok Swain",
    "emails": [
      "alok.swain@example.com",
      "alok.secondary@example.com"
    ]
  },
  "shippingAddress": {
    "line1": "123, MG Road",
    "city": "Bangalore",
    "zip": "560001"
  },
  "items": [
    {
      "productId": "P3001",
      "name": "Smart Watch",
      "price": 2999.00,
      "quantity": 1,
      "attributes": {
        "color": "black",
        "features": ["heart rate", "step counter", "sleep monitor"]
      }
    },
    {
      "productId": "P3002",
      "name": "Earphones",
      "price": 499.00,
      "quantity": 2,
      "attributes": {
        "color": "white",
        "features": []
      }
    }
  ],
  "payment": {
    "method": "net_banking",
    "amountPaid": 3997.00,
    "status": "SUCCESS"
  },
  "giftWrap": false,
  "specialInstructions": null
}

*/
package com.restassured.pojo.orderpractice;

public class Order{
	private String orderId;
	private Customers customers;
	private ShippingAddress shippingaddress;
	private Items items;
	private Attributes attributes;
	private Payment payment;
	public Order(String orderId, Customers customers, ShippingAddress shippingaddress, Items items,
			Attributes attributes, Payment payment) {
		super();
		this.orderId = orderId;
		this.customers = customers;
		this.shippingaddress = shippingaddress;
		this.items = items;
		this.attributes = attributes;
		this.payment = payment;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public ShippingAddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(ShippingAddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Customers getCustomer() {
		return this.customers;
	}
	public void setCustomer(Customers customers) {
		this.customers=customers;
	}
	
	
	
	
}

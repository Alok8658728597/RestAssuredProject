package Session23;

import java.util.List;

public class NestedJSONPojoClass {
 /*"ComapnyName":"Capgemini",
  "Bank":["HDFC","PNB","AXIX"],
  "Street":"NilachalBazzar",
        "City":"Paradeep",
        "Pincode":754141*/
	 private String companyName;
	 private List<String> bank;
	    private String street;
	    private String city;
	    private int pincode; 
	    private List<EmployeePOJO> employeelist;
	    
	    public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<String> getBank() {
		return bank;
	}
	public void setBank(List<String> bank) {
		this.bank = bank;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public List<EmployeePOJO> getEmployeelist() {
		return employeelist;
	}
	public void setEmployeelist(List<EmployeePOJO> employeelist) {
		this.employeelist = employeelist;
	}
		
	
}

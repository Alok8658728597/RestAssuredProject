package Session23;

public class EmployeePOJO {
	/*"Employees":[
{
	"Name":"Rohan",
	"Job":"Student",
	"age":12,
      "Address":{
        "Street":"NilachalBazzar",
        "City":"Paradeep",
        "Pincode":754141
        
      }*/
	
	private String name;
	private String job;
    private int age;
    private AddressPOJO Address;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public AddressPOJO getAddress() {
		return Address;
	}
	public void setAddress(AddressPOJO address) {
		Address = address;
	}
	
	

}

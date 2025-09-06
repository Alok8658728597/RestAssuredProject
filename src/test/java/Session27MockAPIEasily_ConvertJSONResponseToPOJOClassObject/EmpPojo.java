package Session27MockAPIEasily_ConvertJSONResponseToPOJOClassObject;

import Session22.EmployeeTechSkill;

public class EmpPojo {
	/*{
	"Name":"Rohan",
	"Job":"Student",
	"age":12,
	"Salary":10000.00,
	"TechSkill":{
		"Programming Language":"Java",
		"UI Automation":"Selenium",
		"API Testing":"RestAssured"
	}
}*/
	private String name;
	private String job;
	private int age;
	private double salary;
	private EmployeeTechSkill  TechSkills;
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
	public double getSalary() {
		return salary;
	}

}

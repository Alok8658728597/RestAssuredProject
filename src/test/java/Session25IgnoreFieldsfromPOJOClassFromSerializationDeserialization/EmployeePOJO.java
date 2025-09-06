package Session25IgnoreFieldsfromPOJOClassFromSerializationDeserialization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(value= {"age","salary"})
//@JsonIgnoreProperties(ignoreUnknown=true)
public class EmployeePOJO {
	private String name;
	//@JsonIgnore
	private String job;
	private int age;
	//@JsonProperty(access=JsonProperty.Access.READ_ONLY) //this will display salary in serialization and not dis in desreialization
	//@JsonProperty(access=JsonProperty.Access.WRITE_ONLY) //this will display salary in de-serialization and not dis in sreialization
	private double salary;
	private boolean IsMarried;
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
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isIsMarried() {
		return IsMarried;
	}
	public void setIsMarried(boolean isMarried) {
		IsMarried = isMarried;
	}


}

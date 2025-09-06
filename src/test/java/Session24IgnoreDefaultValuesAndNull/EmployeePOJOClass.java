package Session24IgnoreDefaultValuesAndNull;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeePOJOClass {
	private String name;
	private String job;
	private int age;
	private double salary;
	 private boolean IsMarried;
	 private String[] hobbies;
	 private List<String> degrees;
	 private Map<String,String> familymambers;
	 public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getDegrees() {
		return degrees;
	}
	public void setDegrees(List<String> degrees) {
		this.degrees = degrees;
	}
	public Map<String, String> getFamilymambers() {
		return familymambers;
	}
	public void setFamilymambers(Map<String, String> familymambers) {
		this.familymambers = familymambers;
	}
	
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

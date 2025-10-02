package com.restassured.pojo;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class DataUsingLombok{
	private int year;
	private double price;
	@JsonProperty("CPU model")
	private String CPUmodel;
	@JsonProperty("Hard disk size")
	private String Harddisksize;
}
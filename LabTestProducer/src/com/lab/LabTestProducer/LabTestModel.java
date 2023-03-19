package com.lab.LabTestProducer;

public class LabTestModel {

	private String tname, description, price;

	//overload constructor
	public LabTestModel(String tname, String description, String price) {
		super();
		this.tname = tname;
		this.description = description;
		this.price = price;
	}

	//default constructor
	public LabTestModel() {
		
	}

	//getter for get name
	public String getTname() {
		return tname;
	}
	//set the name
	public void setTname(String tname) {
		this.tname = tname;
	}
	//get the description
	public String getDescription() {
		return description;
	}
	//set the description
	public void setDescription(String description) {
		this.description = description;
	}
	//get the price
	public String getPrice() {
		return price;
	}
	//set the price
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}

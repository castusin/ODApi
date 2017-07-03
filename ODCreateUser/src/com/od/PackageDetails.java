package com.od;



public class PackageDetails {
	
	
	String title;
	float price;
	int quantity;
	String typeCode;
	String type;
	
	public PackageDetails(String title, float price, String typeCode, int quantity, String type) {
		super();
		this.title = title;
		this.price=price;
		this.typeCode=typeCode;
		this.type=type;
		this.quantity=quantity;
	
	
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getTypeCode() {
		return typeCode;
	}


	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public PackageDetails(){
		
	}
	

}

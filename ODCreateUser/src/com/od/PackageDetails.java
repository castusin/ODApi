package com.od;



public class PackageDetails {
	
	
	String title;
	float price;
	int quantity;
	String typeCode;
	String type;
	int packageId;
	float originalamount;
	float discountamount;
	
	float collectamount;
	
	
	public PackageDetails(String title, float price, String typeCode, int quantity, String type, int packageId, float originalamount, float discountamount, float collectamount) {
		super();
		this.title = title;
		this.price=price;
		this.typeCode=typeCode;
		this.type=type;
		this.quantity=quantity;
		this.packageId=packageId;
		this.originalamount=originalamount;
		this.discountamount=discountamount;
		
		this.collectamount=collectamount;
		
		
	
	}


	

	public float getDiscountamount() {
		return discountamount;
	}


	public void setDiscountamount(float discountamount) {
		this.discountamount = discountamount;
	}


	public float getOriginalamount() {
		return originalamount;
	}


	public void setOriginalamount(float originalamount) {
		this.originalamount = originalamount;
	}


	public float getCollectamount() {
		return collectamount;
	}


	public void setCollectamount(float collectamount) {
		this.collectamount = collectamount;
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




	public int getPackageId() {
		return packageId;
	}




	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}





}

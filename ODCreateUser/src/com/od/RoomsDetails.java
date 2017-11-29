package com.od;



public class RoomsDetails {
	
	
	String roomType;
	float price;
	int quantity;
	float originalamount;
	float discountamount;
	
	float collectamount;


	public RoomsDetails(float price, int quantity, String roomType, float originalamount, float discountamount, float collectamount) {
		super();
		this.roomType = roomType;
		this.price=price;
		this.quantity=quantity;
		this.originalamount=originalamount;
		this.discountamount=discountamount;
	
		this.collectamount=collectamount;
	
	}



	public float getOriginalamount() {
		return originalamount;
	}



	public void setOriginalamount(float originalamount) {
		this.originalamount = originalamount;
	}



	public float getDiscountamount() {
		return discountamount;
	}



	public void setDiscountamount(float discountamount) {
		this.discountamount = discountamount;
	}



	public float getCollectamount() {
		return collectamount;
	}



	public void setCollectamount(float collectamount) {
		this.collectamount = collectamount;
	}



	public int getQuantity() {
		return quantity;
	}





	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getRoomType() {
		return roomType;
	}





	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}





	public float getPrice() {
		return price;
	}





	public void setPrice(float price) {
		this.price = price;
	}





	public RoomsDetails(){
		
	}
	

}

package com.od;



public class RoomsDetails {
	
	
	String roomType;
	float price;
	int quantity;
	

	public RoomsDetails(float price, int quantity, String roomType) {
		super();
		this.roomType = roomType;
		this.price=price;
		this.quantity=quantity;
	
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

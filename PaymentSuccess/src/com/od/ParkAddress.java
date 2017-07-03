package com.od;



public class ParkAddress {
	
	
	public String streetAddress;
	public String city;
	public String state;
	public String resortname;
	public int pin;
	public ParkAddress(String streetAddress, String city, String state, int pin, String resortname) {
		super();
		
		this.streetAddress=streetAddress;
		this.city=city;
		this.state=state;
		this.pin=pin;
		this.resortname=resortname;
	}
	
	



	public String getResortname() {
		return resortname;
	}





	public void setResortname(String resortname) {
		this.resortname = resortname;
	}





	public String getStreetAddress() {
		return streetAddress;
	}





	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public int getPin() {
		return pin;
	}





	public void setPin(int pin) {
		this.pin = pin;
	}





	public ParkAddress(){
		
	}

}

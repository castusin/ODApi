package com.od;



public class GetAvailabilityModel {
	
	
	public int availability;
	public int parkId;
	public int ParkId;
	//public String facilityCode;
	public String roomtypeCode;
	public GetAvailabilityModel(int availability, int parkId, int ParkId, String roomtypeCode) {
		super();
		
		this.availability=availability;
		this.parkId=parkId;
		this.ParkId=ParkId;
		this.roomtypeCode=roomtypeCode;
	}
	
	


	public String getRoomtypeCode() {
		return roomtypeCode;
	}


	public void setRoomtypeCode(String roomtypeCode) {
		this.roomtypeCode = roomtypeCode;
	}


	public int getAvailability() {
		return availability;
	}



	public void setAvailability(int availability) {
		this.availability = availability;
	}



	public int getParkId() {
		return parkId;
	}



	public void setParkId(int parkId) {
		this.parkId = parkId;
	}



	public GetAvailabilityModel(){
		
	}

}
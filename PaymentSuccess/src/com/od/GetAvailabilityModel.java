package com.od;



public class GetAvailabilityModel {
	
	
	public int availability;
	public int parkId;
	public int ParkId;
	public String facilityCode;
	public GetAvailabilityModel(int availability, int parkId, int ParkId, String facilityCode) {
		super();
		
		this.availability=availability;
		this.parkId=parkId;
		this.ParkId=ParkId;
		this.facilityCode=facilityCode;
	}
	
	

	public String getFacilityCode() {
		return facilityCode;
	}



	public void setFacilityCode(String facilityCode) {
		this.facilityCode = facilityCode;
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

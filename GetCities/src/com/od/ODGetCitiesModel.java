package com.od;



public class ODGetCitiesModel {
	
	public String cityName;
	public int cityKey ;
	
	
	
	public ODGetCitiesModel(int cityKey, String cityName) {
		super();
		
		this.cityKey=cityKey;
		this.cityName=cityName;
		
	}
	


	public String getCityName() {
		return cityName;
	}



	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public int getCityKey() {
		return cityKey;
	}



	public void setCityKey(int cityKey) {
		this.cityKey = cityKey;
	}



	public ODGetCitiesModel(){
		
	}

}

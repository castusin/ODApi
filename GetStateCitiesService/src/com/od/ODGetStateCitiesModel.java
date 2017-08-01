
package com.od;



public class ODGetStateCitiesModel {
	
	public String cityName;
	public int cityKey ;
	public int stateKey;
	
	
	public ODGetStateCitiesModel(int cityKey, String cityName, int stateKey) {
		super();
		
		this.cityKey=cityKey;
		this.cityName=cityName;
		this.stateKey=stateKey;
		
	}
	


	public int getStateKey() {
		return stateKey;
	}



	public void setStateKey(int stateKey) {
		this.stateKey = stateKey;
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



	public ODGetStateCitiesModel(){
		
	}

}


package com.od;

import java.util.Date;

public class LocalAreaData {
	
	public int localAreaId;
	public String localArea;
	public int cityId ;
	public String cityName;
	
		
	public LocalAreaData(int localAreaId, String localArea, int cityId,
			String cityName, String locationLang, String locaitonLat, Date date, String name, String parktype, int parkId) {
		super();
		this.localAreaId = localAreaId;
		this.localArea = localArea;
		this.cityId = cityId;
		this.cityName = cityName;
		
	}
	
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getLocalAreaId() {
		return localAreaId;
	}
	public void setLocalAreaId(int localAreaId) {
		this.localAreaId = localAreaId;
	}
	public String getLocalArea() {
		return localArea;
	}
	public void setLocalArea(String localArea) {
		this.localArea = localArea;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
		
	public LocalAreaData() {
	
	}
	

}

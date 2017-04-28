package com.od;

import java.util.Date;

public class ODGetCityDetailsModel {
	
	public int localAreaId;
	public String localArea;
	public int cityId ;
	public String cityName;
	public String locationLang;
	public String locaitonLat;
	public Date date;
	
	
	
	public ODGetCityDetailsModel(int localAreaId, String localArea, int cityId,
			String cityName, String locationLang, String locaitonLat, Date date) {
		super();
		this.localAreaId = localAreaId;
		this.localArea = localArea;
		this.cityId = cityId;
		this.cityName = cityName;
		this.locationLang = locationLang;
		this.locaitonLat = locaitonLat;
		this.date = date;
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
	
	public String getLocationLang() {
		return locationLang;
	}
	public void setLocationLang(String locationLang) {
		this.locationLang = locationLang;
	}
	public String getLocaitonLat() {
		return locaitonLat;
	}
	public void setLocaitonLat(String locaitonLat) {
		this.locaitonLat = locaitonLat;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	public ODGetCityDetailsModel() {
	
	}
	

}

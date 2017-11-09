package com.cis;

import java.util.List;

import com.od.LocalAreaData;
import com.od.ODAminitiesService;
import com.od.PackageDetails;
import com.od.GetDatesModel;
import com.od.ODParkDetailsService;


public class CISResults {
	public static final String GS_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	String responseCode; // 0 - success, any positive number error
	String errorMessage; // error message if any
	String warningMessage; // if any
	String dateFormat;
	Object resultObject;
	public List<ODParkDetailsService> parkDetails;
	public List<GetDatesModel> dateList;
	public List<PackageDetails> facilityList;
	public List<LocalAreaData> localareaList;
	public List<ODParkDetailsService> roomDetails;
	public List<ODParkDetailsService> addOnDetails;
	public List<ODParkDetailsService> addOnFullDetails;
	public List<ODAminitiesService> amenitieslist;
	
	
	
	public List<ODParkDetailsService> getAddOnFullDetails() {
		return addOnFullDetails;
	}

	public void setAddOnFullDetails(List<ODParkDetailsService> addOnFullDetails) {
		this.addOnFullDetails = addOnFullDetails;
	}

	public List<ODAminitiesService> getAmenitieslist() {
		return amenitieslist;
	}

	public void setAmenitieslist(List<ODAminitiesService> amenitieslist) {
		this.amenitieslist = amenitieslist;
	}

	public List<ODParkDetailsService> getAddOnDetails() {
		return addOnDetails;
	}

	public void setAddOnDetails(List<ODParkDetailsService> addOnDetails) {
		this.addOnDetails = addOnDetails;
	}

	public List<PackageDetails> getFacilityList() {
		return facilityList;
	}

	public List<ODParkDetailsService> getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(List<ODParkDetailsService> roomDetails) {
		this.roomDetails = roomDetails;
	}

	public void setFacilityList(List<PackageDetails> facilityList) {
		this.facilityList = facilityList;
	}

	public List<GetDatesModel> getDateList() {
		return dateList;
	}

	public void setDateList(List<GetDatesModel> dateList) {
		this.dateList = dateList;
	}

	public String getDateErrorFormat() {
		return dateFormat;
	}

	public void setDateErrorFormat(String dateErrorFormat) {
		this.dateFormat = dateErrorFormat;
	}
	
	

	public List<ODParkDetailsService> getParkDetails() {
		return parkDetails;
	}

	public void setParkDetails(List<ODParkDetailsService> parkDetails) {
		this.parkDetails = parkDetails;
	}

	public List<LocalAreaData> getLocalareaList() {
		return localareaList;
	}

	public void setLocalareaList(List<LocalAreaData> localareaList) {
		this.localareaList = localareaList;
	}

	public Object getResultObject() {
		return resultObject;
	}

	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	public CISResults() {
		// TODO Auto-generated constructor stub
		responseCode = "0"; // 0 - success, any positive number error
		errorMessage = ""; // error message if any
		warningMessage = ""; // if any

	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getWarningMessage() {
		return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}


}

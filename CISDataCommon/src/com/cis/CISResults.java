package com.cis;

import java.util.List;

import com.od.FacilityDetails;
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
	public List<FacilityDetails> facilityList;
	
	
	public List<FacilityDetails> getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(List<FacilityDetails> facilityList) {
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

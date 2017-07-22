package com.od;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.DateTime;


public class ValidateOTP {
	
	public String otp;
	public String phoneNumber;
	public String emailId;
	public String timeStamp;
	
	public ValidateOTP(){
		
	}
	
	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}

	

	public ValidateOTP(String otp, String phoneNumber,
			String emailId, String timeStamp) {
		super();
		this.otp = otp;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.timeStamp = timeStamp;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

}

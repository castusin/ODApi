package com.od;


public class ForgotPassword {
	
	public String emailId;
	public String phoneNumber;

	
	public ForgotPassword(String emailId, String phoneNumber) {
		super();
		this.emailId=emailId;
		this.phoneNumber=phoneNumber;
	
		
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


		public ForgotPassword(){
			
		}

}

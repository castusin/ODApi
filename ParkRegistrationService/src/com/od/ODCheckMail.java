
package com.od;


public class ODCheckMail {
	
	public String emailId;
	public String phoneNumber;

	
	public ODCheckMail(String userName, String emailId, String phoneNumber) {
		super();
		this.emailId=emailId;
		this.phoneNumber=phoneNumber;
	
		
	}
		

		


		public String getEmailId() {
		return emailId;
	}





	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public String getPhoneNumber() {
		return phoneNumber;
	}





	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}





		public ODCheckMail(){
			
		}

}

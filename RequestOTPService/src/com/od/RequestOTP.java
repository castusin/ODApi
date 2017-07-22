package com.od;

	public class RequestOTP {
		
		public String phoneNumber;
		
		

		public RequestOTP(String phoneNumber) {
			super();
			this.phoneNumber=phoneNumber;
			
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public RequestOTP() {
			// TODO Auto-generated constructor stub
		}

		
		
	}

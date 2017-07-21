package com.od;

import java.sql.Date;

import org.joda.time.DateTime;

public class ODParkRegistrationModel {
	
	public String userId;
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	public String phoneNumber;
	public String userType;
	public String googleFbId;
	public String profilePicUrl;
	public String userGender;
	public String userRole;
	public String creationDate;
	public String createdBy;
	public String updationDate;
	public String updatedBy;
	public String passwordLastChangedOn;
	public String lastLoginDatetime;

	
	public ODParkRegistrationModel(String userId, String firstName, String lastName, String userName, String password, String phoneNumber, String userType, String profilePicUrl, String googleFbId, String userGender, String userRole, String creationDate, String createdBy, String updationDate, String updatedBy, String passwordLastChangedOn, String lastLoginDatetime) {
		super();
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.phoneNumber=phoneNumber;
		this.userType=userType;
		this.googleFbId=googleFbId;
		this.profilePicUrl=profilePicUrl;
		this.userGender=userGender;
		this.userRole=userRole;
		this.creationDate=creationDate;
		this.createdBy=createdBy;
		this.updationDate=updationDate;
		this.updatedBy=updatedBy;
		this.passwordLastChangedOn=passwordLastChangedOn;
		this.lastLoginDatetime=lastLoginDatetime;
		
	}
		



		public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getUserType() {
		return userType;
	}




	public void setUserType(String userType) {
		this.userType = userType;
	}




	public String getGoogleFbId() {
		return googleFbId;
	}




	public void setGoogleFbId(String googleFbId) {
		this.googleFbId = googleFbId;
	}




	public String getProfilePicUrl() {
		return profilePicUrl;
	}




	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}




	public String getUserGender() {
		return userGender;
	}




	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}




	public String getUserRole() {
		return userRole;
	}




	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getCreatedBy() {
		return createdBy;
	}




	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}




	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


		public String getCreationDate() {
		return creationDate;
	}




	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}




	public String getUpdationDate() {
		return updationDate;
	}




	public void setUpdationDate(String updationDate) {
		this.updationDate = updationDate;
	}




	public String getPasswordLastChangedOn() {
		return passwordLastChangedOn;
	}




	public void setPasswordLastChangedOn(String passwordLastChangedOn) {
		this.passwordLastChangedOn = passwordLastChangedOn;
	}




	public String getLastLoginDatetime() {
		return lastLoginDatetime;
	}




	public void setLastLoginDatetime(String lastLoginDatetime) {
		this.lastLoginDatetime = lastLoginDatetime;
	}




		public ODParkRegistrationModel(){
			
		}

}

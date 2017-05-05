package com.od;


import java.sql.Date;
 
public class ODCreateUserModel {
	
	public int userId;
	public String firstName ;
	public String lastName ;
	public int phoneNumber1 ;
	public int phoneNumber2;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public int pincode;
	public int reservationId;
	public Date reservedDate;
	public int parkId;
	public String userType;
	public String faciltiyTypecode;
	public Date fromDate;
	public Date toDate;
	public int qty;
	public float totalPrice;
	public String status;
	
	
	public ODCreateUserModel(int userId, String firstName, String lastName, int phoneNumber1, int phoneNumber2, String address1, String address2, String city, String state, int pincode, int reservationId, Date reservedDate, int parkId, String userType, String faciltiyTypecode, Date fromDate, Date toDate, int qty, float totalPrice, String status) {
		super();
		this.userId=userId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber1=phoneNumber1;
		this.phoneNumber2=phoneNumber2;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.state=state;
		this.pincode=pincode;
		this.reservationId=reservationId;
		this.reservedDate=reservedDate;
		this.parkId=parkId;
		this.userType=userType;
		this.faciltiyTypecode=faciltiyTypecode;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.qty=qty;
		this.totalPrice=totalPrice;
		this.status=status;
		
	
	}
		

		public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
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


	public int getPhoneNumber1() {
		return phoneNumber1;
	}


	public void setPhoneNumber1(int phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}


	public int getPhoneNumber2() {
		return phoneNumber2;
	}


	public void setPhoneNumber2(int phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}


	public String getAddress1() {
		return address1;
	}


	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getAddress2() {
		return address2;
	}


	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public int getReservationId() {
		return reservationId;
	}


	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}


	public Date getReservedDate() {
		return reservedDate;
	}


	public void setReservedDate(Date reservedDate) {
		this.reservedDate = reservedDate;
	}


	public int getParkId() {
		return parkId;
	}


	public void setParkId(int parkId) {
		this.parkId = parkId;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getFaciltiyTypecode() {
		return faciltiyTypecode;
	}


	public void setFaciltiyTypecode(String faciltiyTypecode) {
		this.faciltiyTypecode = faciltiyTypecode;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


		public ODCreateUserModel(){
			
		}

}
package com.od;


import java.sql.Date;
import java.util.List;
 
public class ODCreateUserModel {
	
	public String userId;
	public String firstName ;
	public String lastName ;
	public String phoneNumber1 ;
	public String phoneNumber2;
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
	public String emailId;
	public Date reservationDate;
	public int adults;
	public int child;
	public float originalAmount;
	public float discountAmount;
	public float collectAmount;
	public String couponCode;

	
	public List<PackageDetails> packageList;
	//public List<RoomsDetails> roomList;
	public ODCreateUserModel(String userId, String firstName, String lastName, String phoneNumber1, String phoneNumber2, String address1, String address2, String city, String state, int pincode, int reservationId, Date reservedDate, int parkId, String userType, String faciltiyTypecode, Date fromDate, Date toDate, int qty, float totalPrice, String status, String emailId, List<PackageDetails> facilityList, List<RoomsDetails> roomList, List<PackageDetails> packageList, Date reservationDate, int adults, int child, float originalAmount, float discountAmount, float collectAmount, String couponCode) {
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
		this.emailId=emailId;
		this.reservationDate=reservationDate;
		this.adults=adults;
		this.child=child;
		this.originalAmount=originalAmount;
		this.discountAmount=discountAmount;
		this.collectAmount=collectAmount;
		this.packageList=packageList;
		this.couponCode=couponCode;
		
		//this.roomList=roomList;
	}
		

		public String getCouponCode() {
		return couponCode;
	}




	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}




		public float getDiscountAmount() {
		return discountAmount;
	}




	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}




	public float getOriginalAmount() {
		return originalAmount;
	}




	public void setOriginalAmount(float originalAmount) {
		this.originalAmount = originalAmount;
	}




	public float getCollectAmount() {
		return collectAmount;
	}




	public void setCollectAmount(float collectAmount) {
		this.collectAmount = collectAmount;
	}




		public Date getReservationDate() {
		return reservationDate;
	}




	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}




	public int getAdults() {
		return adults;
	}




	public void setAdults(int adults) {
		this.adults = adults;
	}




	public int getChild() {
		return child;
	}




	public void setChild(int child) {
		this.child = child;
	}




		public List<PackageDetails> getPackageList() {
		return packageList;
	}




	public void setPackageList(List<PackageDetails> packageList) {
		this.packageList = packageList;
	}




		public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
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


	


	public String getPhoneNumber1() {
		return phoneNumber1;
	}


	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}


	public String getPhoneNumber2() {
		return phoneNumber2;
	}


	public void setPhoneNumber2(String phoneNumber2) {
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

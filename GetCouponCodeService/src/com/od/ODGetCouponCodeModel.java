
package com.od;

import java.util.Date;



public class ODGetCouponCodeModel {
	
	public String parkKey;
	public String couponType ;
	
	public String couponCode;
	public int discount ;
	
	public Date fromDate;
	public Date toDate ;
	public String description;
	public Date createdOn ;
	public int createdBy;
	public Date modifiedOn ;
	public int modifiedBy;
	//public int createdTime ;
	public String status;
	
	public ODGetCouponCodeModel(String parkKey, String couponType, String couponCode, int discount, Date fromDate, Date toDate, String description, Date createdOn, int createdBy, Date modifiedOn, int modifiedBy, String status) {
		super();
		
		this.parkKey=parkKey;
		this.couponType=couponType;
		
		this.couponCode=couponCode;
		this.discount=discount;
		
		this.fromDate=fromDate;
		this.toDate=toDate;
		
		this.description=description;
		this.createdOn=createdOn;
		
		this.createdBy=createdBy;
		this.modifiedOn=modifiedOn;
		
		this.modifiedBy=modifiedBy;
		this.status=status;
	}
	




	public String getParkKey() {
		return parkKey;
	}





	public void setParkKey(String parkKey) {
		this.parkKey = parkKey;
	}





	public String getCouponType() {
		return couponType;
	}





	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}





	public String getCouponCode() {
		return couponCode;
	}





	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}





	public int getDiscount() {
		return discount;
	}





	public void setDiscount(int discount) {
		this.discount = discount;
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





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public Date getCreatedOn() {
		return createdOn;
	}





	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}





	public int getCreatedBy() {
		return createdBy;
	}





	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}





	public Date getModifiedOn() {
		return modifiedOn;
	}





	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}





	public int getModifiedBy() {
		return modifiedBy;
	}





	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public ODGetCouponCodeModel(){
		
	}

}

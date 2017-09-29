package com.od;

import java.time.Instant;
import java.util.Date;
import java.util.List;



public class ODParkPackageDetailsService {
	
	
	public String packageName;
	public float packagePrice;
	public String packageDiscountType ;
	
	public int packageDiscountValue;
	public String packageTopImage ;
	
	
	public List<ODPackageItemsModel> packageItems;
	public ODParkPackageDetailsService(float packagePrice, String packageDiscountType, int packageDiscountValue, String packageTopImage, List<ODPackageItemsModel> packageItems, String packageName) {
		super();
		
		this.packagePrice=packagePrice;
		this.packageDiscountType=packageDiscountType;
		this.packageDiscountValue=packageDiscountValue;
		this.packageTopImage=packageTopImage;
		this.packageItems=packageItems;
		this.packageName=packageName;
		
	}
	

	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}


	public List<ODPackageItemsModel> getPackageItems() {
		return packageItems;
	}


	public void setPackageItems(List<ODPackageItemsModel> packageItems) {
		this.packageItems = packageItems;
	}


	public float getPackagePrice() {
		return packagePrice;
	}





	public void setPackagePrice(float packagePrice) {
		this.packagePrice = packagePrice;
	}





	public String getPackageDiscountType() {
		return packageDiscountType;
	}





	public void setPackageDiscountType(String packageDiscountType) {
		this.packageDiscountType = packageDiscountType;
	}





	public int getPackageDiscountValue() {
		return packageDiscountValue;
	}





	public void setPackageDiscountValue(int packageDiscountValue) {
		this.packageDiscountValue = packageDiscountValue;
	}





	public String getPackageTopImage() {
		return packageTopImage;
	}





	public void setPackageTopImage(String packageTopImage) {
		this.packageTopImage = packageTopImage;
	}





	public ODParkPackageDetailsService(){
		
	}

}

package com.od;

public class ODGetCategoriesQuery {
	
	//public static String SQL_GETCATEGORIES = " select Local_area,Parktype,Main_photo_url from Park_info where city_id=? and Parktype=? "; 
	
	
	public static String SQL_GETCATEGORIES ="select p.*,mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date from Park_info p,(select a.Park_id,a.min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date from  (select Park_id, min(Current_price) as min_curr_price from Park_current_pricing_availability cpv where date=? and Room_type_code='P'  group by Park_id)a	left join park_discount pd on a.Park_id=pd.Resort_id and ? between pd.From_date and pd.To_date) mpp	where p.city_id=? and p.Parktype=? and p.Park_id=mpp.Park_id";
	
}

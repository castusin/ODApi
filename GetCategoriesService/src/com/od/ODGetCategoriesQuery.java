package com.od;

public class ODGetCategoriesQuery {
	
	//public static String SQL_GETCATEGORIES = " select Local_area,Parktype,Main_photo_url from Park_info where city_id=? and Parktype=? "; 
	
	
	public static String SQL_GETCATEGORIES ="select p.*,mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date from Park_info p,(select a.Park_id,a.min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date from  (select Park_id,park_room_fac, min(Current_price) as min_curr_price from Park_current_pricing_availability cpv where date=? and Room_type_code='P'  group by Park_id)a	left join park_discount pd on a.Park_id=pd.Resort_id and a.park_room_fac = pd.park_room_fac and ? between pd.From_date and pd.To_date and pd.Status='A' ) mpp	where p.city_id=? and p.Parktype=? and p.Park_id=mpp.Park_id and p.Is_active=0";
	
	//public static String SQL_GETCATEGORIES   ="select p.*,mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date from Park_info p,(select a.Park_id,a.min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date from  (select Park_id,park_room_fac, min(Current_price) as min_curr_price from Park_current_pricing_availability cpv where date=? and Room_type_code='P'  group by Park_id)a	left join park_discount pd on a.Park_id=pd.Resort_id and a.park_room_fac = pd.park_room_fac and ? between pd.From_date and pd.To_date) mpp	where p.local_id=? and p.Parktype=? and p.Park_id=mpp.Park_id";
	public static String SQL_GETALLGETCATEGORIES_PARKSINFO = "SELECT p.*,mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date FROM Park_info p,(SELECT a.Park_id, a.min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date FROM (SELECT Park_id, park_room_fac, MIN( Current_price ) AS min_curr_price FROM Park_current_pricing_availability cpv where  date=? and Room_type_code='P' and Is_active=0 GROUP BY Park_id)a LEFT JOIN park_discount pd ON a.Park_id = pd.Resort_id AND a.park_room_fac = pd.park_room_fac AND  ? BETWEEN pd.From_date AND pd.To_date and pd.Status='A')mpp WHERE p.city_id=? AND p.Park_id = mpp.Park_id and p.Is_active=0";
}

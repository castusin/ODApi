package com.od;

public class ODGetParkInfoQuery {
	
	//public static String SQL_GETPARKSINFO = "select * from Park_info where local_id=? and Is_active=0";

	public static String SQL_GETDATES = "select Date from Park_current_pricing_availability where Date=? "; 

	public static String SQL_GETPARKSINFO ="select p.*,mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date from Park_info p,(select a.Park_id,a.min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date from  (select Park_id, min(Current_price) as min_curr_price from Park_current_pricing_availability cpv where date=? and Room_type_code='P'  group by Park_id)a	left join park_discount pd on a.Park_id=pd.Resort_id and ? between pd.From_date and pd.To_date) mpp	where p.local_id=? and p.Parktype=? and p.Park_id=mpp.Park_id";
	
	//public static String SQL_GETPARKSROOMSINFO ="SELECT p . * , mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date FROM Park_info p, (	SELECT a.Park_id, MIN( a.min_curr_price ) AS min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date FROM (	SELECT Park_id, park_room_fac, MIN( Current_price ) AS min_curr_price, COUNT( * ) FROM Park_current_pricing_availability cpv WHERE DATE	BETWEEN  ?	AND  ?	AND Current_available_qty >0 AND Room_type_code =  'R'	GROUP BY Park_id, park_room_fac	HAVING COUNT( * ) = DATEDIFF(  ?,  ? ) +1	)a	LEFT JOIN park_discount pd ON a.Park_id = pd.Resort_id	GROUP BY a.park_id, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date	)mpp WHERE p.local_id =?	AND p.Parktype = ?	AND p.Park_id = mpp.Park_id";
			


	public static String SQL_GETPARKSROOMSINFO ="select p.*,mpp.min_curr_price, mpp.Discount, mpp.Discount_mode, mpp.From_date, mpp.To_date from Park_info p,(select a.Park_id,min(a.min_curr_price) as min_curr_price, pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date from (select Park_id,park_room_fac, min(Current_price) as min_curr_price, count(*) from Park_current_pricing_availability cpv where date between ? and ? and Current_available_qty>0 and Room_type_code='R' group by Park_id,park_room_fac having count(*) = datediff(?,?)+1)a left join park_discount pd on a.Park_id=pd.Resort_id group by a.park_id,pd.Discount, pd.Discount_Mode, pd.From_date, pd.To_date) mpp where p.local_id=? and p.Parktype=? and p.Park_id=mpp.Park_id";
	
	public static String SQL_GETALLPARKSINFO = "SELECT * FROM  Park_info WHERE local_id = ? "; 


}
package com.od;

public class ODGetParkInfoQuery {
	
	public static String SQL_GETPARKSINFO = "select A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro,A.Local_area, A.City, A.Name, min(rms.price)from (SELECT pv.Park_id, pv.Facility_type_code, count( * ) , min( Current_price ) AS price FROM Park_current_pricing_availability pv, Park_facility_inventory_pricing p	WHERE p.Park_id = pv.Park_id AND  p.facility_type_code = pv.Facility_type_code 	AND pv.date	BETWEEN ? AND ?	AND current_available_qty >'0' GROUP BY pv.Park_id, pv.Facility_type_code	HAVING count( * ) =?) rms, Park_info A	WHERE rms.Park_id = A.Park_id	GROUP BY A.Park_Id, A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name";

	//public static String SQL_GETPARKSINFO = "SELECT A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty	FROM Park_info A JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id	WHERE A.Local_area =? AND B.DATE = ? AND B.Current_available_qty !=  '0'";
	
	
	
	public static String SQL_GETDATES = "select Date from Park_current_pricing_availability where Date=? "; 

}


/*select A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, 
A.Local_area, A.City, A.Name, min(rms.price)
from (
select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as price
from Park_current_pricing_availability pv, Park_facility_inventory_pricing p
where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code
and pv.date between '2017-06-14'and '2017-06-17' 
and current_available_qty > 0
group by pv.Park_id, pv.Facility_type_code
having count(*)=4) rms, Park_info A
where rms.park_id=A.park_id
group by A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, 
A.Local_area, A.City, A.Name;*/

/*SELECT A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty
FROM Park_info A
JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id
WHERE A.Local_area =  'Madhapur'
AND DATE =  '2017-03-27'
AND B.Current_available_qty !=  '0'*/
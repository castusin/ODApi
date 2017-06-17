package com.od;

public class ODGetParkInfoQuery {
	
	public static String SQL_GETPARKSINFO = "select A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, min(rms.Current_price) AS Current_price from (select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price from Park_current_pricing_availability pv, Park_facility_inventory_pricing p where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code and pv.date between ? and ? and current_available_qty > 0 group by pv.Park_id, pv.Facility_type_code having count(*)=?) rms, littlepa_ODDB.Park_info A where rms.park_id=A.park_id group by A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name";
	//public static String SQL_GETPARKSINFO = "SELECT A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty	FROM Park_info A JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id	WHERE A.Local_area =? AND B.DATE = ? AND B.Current_available_qty !=  '0'";
	
	
	
	public static String SQL_GETDATES = "select Date from Park_current_pricing_availability where Date=? "; 

}


/*select A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro,
A.Local_area, A.City, A.Name, min(rms.Current_price)
from (
select pv.Park_id, pv.Facility_type_code, count(*) , min(Current_price) as Current_price
from Park_current_pricing_availability pv, Park_facility_inventory_pricing p
where p.park_id = pv.Park_id and p.facility_type_code = pv.Facility_type_code
and pv.date between ? and ?
and current_available_qty > 0
group by pv.Park_id, pv.Facility_type_code
having count(*)=?) rms, littlepa_ODDB.Park_info A
where rms.park_id=A.park_id
group by A.Park_Id,A.Parktype, A.Park_subcategory, A.Metro,
A.Local_area, A.City, A.Name;*/

/*SELECT A.Parktype, A.Park_subcategory, A.Metro, A.Local_area, A.City, A.Name, A.Description, B.Facility_type_code, B.Current_available_qty
FROM Park_info A
JOIN Park_current_pricing_availability B ON A.Park_id = B.Park_id
WHERE A.Local_area =  'Madhapur'
AND DATE =  '2017-03-27'
AND B.Current_available_qty !=  '0'*/
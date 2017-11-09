
package com.od;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODGetParkDetailsBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODGetParkDetailsDAO parkDetailsDAO=(ODGetParkDetailsDAO)ctx.getBean("ParkDetailsDAO");
	
	/**
	 * @param parkId
	 * @param reservationDate 
	 * @return  1 in case of error or 0 if successful
	 * @throws Exception 
	 */
	public CISResults getParksDetails(String parkId,String parkType,String checkIn, String checkOut, String reservationDate) throws Exception {
		// Capture service Start time
		    TimeCheck time=new TimeCheck();
			testServiceTime seriveTimeCheck=new testServiceTime();
			String serviceStartTime=time.getTimeZone();
			
		 	CISResults cisResult=new CISResults();
		 	ODGetParkDetailsModel parkDetails=new ODGetParkDetailsModel();
		 	List<ODParkDetailsService> parkDetailslist = null;
		 	List<ODParkDetailsService> roomDetailslist = null;
		 	List<ODParkDetailsService> addOnDetailslist=null;
		 	List<ODParkDetailsService> addOnFullDetailslist=null;
		 	List<ODAminitiesService> amenitieslist=null;
		 	//Map<String,List<ODParkDetailsService>> map = new HashMap<String,List<ODParkDetailsService>>();
		 	
			final Logger logger = Logger.getLogger(ODGetParkInfoBL.class);
			
			// converting string to date
			
			
			
			cisResult = parkDetailsDAO.getParksDetail(parkId);
			if(reservationDate.equalsIgnoreCase("")){
				
				SimpleDateFormat myFormat = new SimpleDateFormat(CISConstants.CHECKIN_DATE_FORMAT);
				Date date1 = myFormat.parse(checkIn);
			    Date date2 = myFormat.parse(checkOut);
			    // calculating count
				int count=0;
				long diff = date2.getTime() - date1.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000)+1;
				count = (int) diffDays;
				
				roomDetailslist = parkDetailsDAO.getParksRoomDetails(checkIn,checkOut,parkType,parkId,count);
				parkDetailslist = parkDetailsDAO.getParksDetails(checkIn,checkOut,parkType,parkId,count);
				addOnDetailslist = parkDetailsDAO.getAddonDetails(checkIn,checkOut,parkType,parkId,count);
				addOnFullDetailslist = parkDetailsDAO.getAddonFullDetails(checkIn,checkOut,parkType,parkId);
				amenitieslist = parkDetailsDAO.getAminitiesDetails(checkIn,checkOut,parkType,parkId,count);
				cisResult.setParkDetails(parkDetailslist);	
				cisResult.setRoomDetails(roomDetailslist);
				cisResult.setAddOnDetails(addOnDetailslist);
				cisResult.setAddOnFullDetails(addOnFullDetailslist);
				cisResult.setAmenitieslist(amenitieslist);
				
				logger.debug("OD GetParkDetailsBL service" +cisResult);
			}else{
				
				roomDetailslist = parkDetailsDAO.getParksRoomDetailsRes(reservationDate,parkType,parkId);
				parkDetailslist = parkDetailsDAO.getParksDetailsRes(reservationDate,parkType,parkId);
				addOnDetailslist = parkDetailsDAO.getAddonDetailsRes(reservationDate,parkType,parkId);
				addOnFullDetailslist = parkDetailsDAO.getAddonFullDetails(checkIn,checkOut,parkType,parkId);
				
				amenitieslist = parkDetailsDAO.getAminitiesDetailsRes(reservationDate,parkType,parkId);
				cisResult.setParkDetails(parkDetailslist);	
				cisResult.setRoomDetails(roomDetailslist);
				cisResult.setAddOnDetails(addOnDetailslist);
				cisResult.setAddOnFullDetails(addOnFullDetailslist);
				cisResult.setAmenitieslist(amenitieslist);
				logger.debug("OD GetParkDetailsBL service" +cisResult);
				
			}
			
			String serviceEndTime=time.getTimeZone();
			long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			logger.info("Database time for get park details service:: " +result );
			
			  
			 return cisResult;
		}

	}

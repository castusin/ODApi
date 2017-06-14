package com.od;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODPaymentSuccessBL {
	
	private static final String S = null;
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODPaymentSuccessDAO successDAO=(ODPaymentSuccessDAO)ctx.getBean("successDAO");
	
	/**
	 * @param transactionId
	 * @param status 
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults paymentSuccess(int transactionId, String status) {
		// Capture service Start time
		
	    TimeCheck time=new TimeCheck();
	    EmailCommunication sendMail=new EmailCommunication();
	    CISResults cisResult= new CISResults();
		testServiceTime seriveTimeCheck=new testServiceTime();
		String serviceStartTime=time.getTimeZone();
		 List<GetDatesModel> dateList = null;		
		final Logger logger = Logger.getLogger(ODPaymentSuccessBL.class);
			 
	     cisResult = successDAO.paymentSuccess(transactionId,status);
	    
	     cisResult = successDAO.getRoomDetails(transactionId);
	     
	        String roomType="";
	        GetRoomDetailsModel  type=(GetRoomDetailsModel)cisResult.getResultObject();
			roomType=type.getFacilityType();
			//Date checkIn="";
	        GetRoomDetailsModel  in=(GetRoomDetailsModel)cisResult.getResultObject();
	        Date checkIn=in.getFromDate();
			//Date checkOut="";
	        GetRoomDetailsModel  out=(GetRoomDetailsModel)cisResult.getResultObject();
			Date checkOut=out.getToDate();
			//int qty="";
	        GetRoomDetailsModel  quan=(GetRoomDetailsModel)cisResult.getResultObject();
			int qty=quan.getQuantity();
			//float price="";
	        GetRoomDetailsModel  rs=(GetRoomDetailsModel)cisResult.getResultObject();
			float price=rs.getTotalPrice();
	     
	     if(status.equalsIgnoreCase(CISConstants.STATUS1)){
	    	 
	    	 // get emailId and firstname from db
	    	cisResult = successDAO.paymentEmail(transactionId);
			String paymentEmail="";
			ODPaymentSuccessModel  emailId=(ODPaymentSuccessModel)cisResult.getResultObject();
			paymentEmail=emailId.getEmailId();
			String firstName="";
			ODPaymentSuccessModel  name=(ODPaymentSuccessModel)cisResult.getResultObject();
			firstName=name.getFirstName();
			
			//sending all parameters required	 
			cisResult=sendMail.sendPaymentstatus(paymentEmail,firstName,roomType,checkIn,checkOut,qty,price);
	    	
			
			
			// get current availability
			 cisResult = successDAO.getAvailablility();
			
			 GetAvailabilityModel  quantity= (GetAvailabilityModel)cisResult.getResultObject();
			 int avail=quantity.getAvailability();
			 GetAvailabilityModel  id= (GetAvailabilityModel)cisResult.getResultObject();
			 int parkid=id.getParkId();
			 GetAvailabilityModel  facility= (GetAvailabilityModel)cisResult.getResultObject();
			 String facilitycode=facility.getFacilityCode();
			 // update availability
			 avail=avail-qty;
			
			 cisResult = successDAO.getUpdateAvailablility(avail,parkid,facilitycode);
		
	    }
	    
	    else if(status.equalsIgnoreCase(CISConstants.STATUS2)){
		cisResult = successDAO.paymentEmail(transactionId);
		String paymentEmail="";
		ODPaymentSuccessModel  emailId=(ODPaymentSuccessModel)cisResult.getResultObject();
		paymentEmail=emailId.getEmailId();
		
			 
		cisResult=sendMail.sendPaymentFailure(paymentEmail);
			
	    }	
	     
			// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		logger.info("Database time for payment status service:: " +result );
			  
		return cisResult;
		}

	}

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
	public CISResults paymentSuccess(String transactionId, String status) {
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
			int qty=quan.getRoomQuantity();
			 GetRoomDetailsModel  id=(GetRoomDetailsModel)cisResult.getResultObject();
			int parkid=id.getParkId();
			//float price="";
	        GetRoomDetailsModel  rs=(GetRoomDetailsModel)cisResult.getResultObject();
			float price=rs.getTotalPrice();
			
			String facilityTitle="";
			float facilityPrice=0;
			int facilityQuantity=0;
			String facilityTypeCode="";
			
			String roomTitle="";
			float roomPrice=0;
			int roomQuantity=0;
			String roomTypeCode="";
		
	        GetRoomDetailsModel  ftitile=(GetRoomDetailsModel)cisResult.getResultObject();
	        facilityTitle=ftitile.getFacilityTitle();
			
			
	        GetRoomDetailsModel  fprice=(GetRoomDetailsModel)cisResult.getResultObject();
	        facilityPrice=fprice.getFacilityPrice();
			
	        GetRoomDetailsModel  fquant=(GetRoomDetailsModel)cisResult.getResultObject();
	        facilityQuantity=fquant.getFacilityQuantity();
			
	       
			
	        GetRoomDetailsModel  rtitle=(GetRoomDetailsModel)cisResult.getResultObject();
	        roomTitle=rtitle.getRoomTitle();
			
	        GetRoomDetailsModel  rprice=(GetRoomDetailsModel)cisResult.getResultObject();
	        roomPrice=rprice.getRoomPrice();
			
	        GetRoomDetailsModel  rquant=(GetRoomDetailsModel)cisResult.getResultObject();
	        roomQuantity=rquant.getRoomQuantity();
			
	       
	        
	     if(status.equalsIgnoreCase(CISConstants.STATUS1)){
	    	 
	    	 // get emailId and firstname from db
	    	cisResult = successDAO.paymentEmail(transactionId);
			String paymentEmail="";
			ODPaymentSuccessModel  emailId=(ODPaymentSuccessModel)cisResult.getResultObject();
			paymentEmail=emailId.getEmailId();
			String firstName="";
			ODPaymentSuccessModel  name=(ODPaymentSuccessModel)cisResult.getResultObject();
			firstName=name.getFirstName();
			
		/*	cisResult = successDAO.SupplierEmail(parkid);
			String supplierEmail="";
			SupplierModel  suppemailId=(SupplierModel)cisResult.getResultObject();
			supplierEmail=suppemailId.getEmailId();
			*/
			//sending all parameters required	 
			cisResult=sendMail.sendPaymentstatus(paymentEmail,firstName,checkIn,checkOut,price,transactionId,facilityTitle,facilityPrice,facilityQuantity,roomTitle,roomPrice,roomQuantity);
	    	
			cisResult=sendMail.sendAdminSuccessMail(firstName,checkIn,checkOut,price,transactionId,facilityTitle,facilityPrice,facilityQuantity,roomTitle,roomPrice,roomQuantity);
	    	
			
			//cisResult=sendMail.sendSupplierSuccessMail(supplierEmail,firstName,roomType,checkIn,checkOut,qty,price,transactionId);
            
			
			// get current availability
			 cisResult = successDAO.getAvailablility();
			
			 GetAvailabilityModel  quantity= (GetAvailabilityModel)cisResult.getResultObject();
			 int avail=quantity.getAvailability();
			 GetAvailabilityModel  iD= (GetAvailabilityModel)cisResult.getResultObject();
			 int parkId=iD.getParkId();
			 GetAvailabilityModel  facility= (GetAvailabilityModel)cisResult.getResultObject();
			 //String facilitycode=facility.getFacilityCode();
			 String roomtypecode=facility.getRoomtypeCode();
			 // update availability
			 avail=avail-qty;
			
			 cisResult = successDAO.getUpdateAvailablility(avail,parkId,roomtypecode);
		
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

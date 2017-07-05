package com.od;


import java.util.ArrayList;
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
	 * @param cod 
	 * @return  1 in case of error or 0 if successful
	 */
	public CISResults paymentSuccess(String transactionId, String status, String cod) {
		// Capture service Start time
		
	    TimeCheck time=new TimeCheck();
	    EmailCommunication sendMail=new EmailCommunication();
	    CISResults cisResult= new CISResults();
		testServiceTime seriveTimeCheck=new testServiceTime();
		String serviceStartTime=time.getTimeZone();
		 List<GetDatesModel> dateList = null;		
		final Logger logger = Logger.getLogger(ODPaymentSuccessBL.class);
	  		 
	     cisResult = successDAO.paymentSuccess(transactionId,status);
	     
	     if(status.equalsIgnoreCase(CISConstants.STATUSFAILURE)){
			 cisResult = successDAO.paymentEmail(transactionId);
			 String paymentEmail2="";
			 ODPaymentSuccessModel  emailId2=(ODPaymentSuccessModel)cisResult.getResultObject();
			 paymentEmail2=emailId2.getEmailId();
			
				 
			cisResult=sendMail.sendPaymentFailure(paymentEmail2);
				
		    }	
	     
	     else{
	   //  if(status.equalsIgnoreCase(CISConstants.STATUS1)){
	    	 
	     List<GetRoomDetailsModel> details=successDAO.getRoomDetails(transactionId);
	     String typecode="";
	     String title="";
	     Date checkIn = null;
	     Date checkOut = null;
	     int qty=0;
	     int parkid=0;
	     float price=0;
	     float totalPrice=0;
	     String type="";
	     String  suppEmail="";
	     String suppCell="";
	     String suppLand="";
			ArrayList<Object> roomDetails = new ArrayList<Object>();
			 
			for (int i = 0; i < details.size(); i++) {
				
			GetRoomDetailsModel roomDetaisModel = new GetRoomDetailsModel();
			//Color color = new Color();
				
			     typecode= details.get(i).typeCode;
			     title=details.get(i).title;
			     type=details.get(i).type;
			     checkIn=details.get(i).fromDate;
			     checkOut=details.get(i).toDate;
			     qty=details.get(i).quantity;
			     parkid=details.get(i).parkId;
			     price=details.get(i).price;
			     totalPrice=details.get(i).totalPrice;
				
			    roomDetails.add(roomDetaisModel);
				
			}
			

			 cisResult.setResultObject(roomDetails);
			
	    
	    	 
	    	 // get emailId and firstname from db
	    	cisResult = successDAO.paymentEmail(transactionId);
			String paymentEmail="";
			ODPaymentSuccessModel  emailId=(ODPaymentSuccessModel)cisResult.getResultObject();
			paymentEmail=emailId.getEmailId();
			String firstName="";
			ODPaymentSuccessModel  name=(ODPaymentSuccessModel)cisResult.getResultObject();
			firstName=name.getFirstName();
			
			cisResult = successDAO.getParkAddress(parkid);
			
			
			ParkAddress  address=(ParkAddress)cisResult.getResultObject();
			String streetAddress=address.getStreetAddress();
			String city=address.getCity();
			String state=address.getState();
			int pin=address.getPin();
			String parkName=address.getResortname();
			
			 List<SupplierModel> suppdetails= successDAO.SupplierEmail(parkid);
			
			
			
			ArrayList<Object> supplierDetails = new ArrayList<Object>();
			 
			for (int i = 0; i < suppdetails.size(); i++) {
				
				SupplierModel supplierDetaisModel = new SupplierModel();
			//Color color = new Color();
				
				suppEmail= suppdetails.get(i).emailId;
			    suppCell=suppdetails.get(i).cell;
				suppLand=suppdetails.get(i).land;
				
			     supplierDetails.add(supplierDetaisModel);
				
			}
			

			 cisResult.setResultObject(supplierDetails);
			 
			 if(cod.equalsIgnoreCase(CISConstants.PAYMENTSUCCESS)){
			
			//sending all parameters required	 
			cisResult=sendMail.sendPaymentstatus(paymentEmail,firstName,checkIn,checkOut,price,transactionId,title,totalPrice,qty,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
	    	
			cisResult=sendMail.sendAdminSuccessMail(firstName,checkIn,checkOut,price,transactionId,title,totalPrice,qty,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
	    	
			cisResult=sendMail.sendSupplierSuccessMail(suppEmail,firstName,checkIn,checkOut,price,transactionId,title,totalPrice,qty,streetAddress,city,state,pin,parkName,suppCell);
			}else if(cod.equalsIgnoreCase(CISConstants.COD)){
				
				cisResult=sendMail.sendPaymentstatusCOD(paymentEmail,firstName,checkIn,checkOut,price,transactionId,title,totalPrice,qty,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
		    	
				cisResult=sendMail.sendAdminSuccessMailCOD(firstName,checkIn,checkOut,price,transactionId,title,totalPrice,qty,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
		    	
				cisResult=sendMail.sendSupplierSuccessMailCOD(suppEmail,firstName,checkIn,checkOut,price,transactionId,title,totalPrice,qty,streetAddress,city,state,pin,parkName,suppCell);
			
				
			}
			
			
			// get current availability
			 cisResult = successDAO.getAvailablility(transactionId);
			
			
			 cisResult = successDAO.getUpdateAvailablility(transactionId);
		
	 //  }
	    
	     } 
	     
			// Capture Service End time
		String serviceEndTime=time.getTimeZone();
		long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		logger.info("Database time for payment status service:: " +result );
			  
		return cisResult;
		}

	}

package com.od;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
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
		 SMSCommunication smsCommunicaiton=new SMSCommunication();
		 final Logger logger = Logger.getLogger(ODPaymentSuccessBL.class);
		 
		 Calendar currentdate = Calendar.getInstance();
         DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
         TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONEIND);
         formatter.setTimeZone(obj);
         String createDate=time.getTimeZone();
	  		 
	     cisResult = successDAO.paymentSuccess(transactionId,status);
	     
		 // get emailId and firstname from db
		 cisResult = successDAO.paymentEmail(transactionId);
		 String paymentEmail="";
		 ODPaymentSuccessModel  emailId=(ODPaymentSuccessModel)cisResult.getResultObject();
		 paymentEmail=emailId.getEmailId();
		 String firstName="";
		 ODPaymentSuccessModel  name=(ODPaymentSuccessModel)cisResult.getResultObject();
		 firstName=name.getFirstName();
		 ODPaymentSuccessModel  phone=(ODPaymentSuccessModel)cisResult.getResultObject();
		 String phoneNumber=phone.getPhoneNumber();
		// String cell="9440069067";
		 if(status.equalsIgnoreCase(CISConstants.STATUSFAILURE)){
			 cisResult = successDAO.paymentEmail(transactionId);
			 String paymentEmail2="";
			 ODPaymentSuccessModel  emailId2=(ODPaymentSuccessModel)cisResult.getResultObject();
			 paymentEmail2=emailId2.getEmailId();
			
				 
			 cisResult=sendMail.sendPaymentFailure(paymentEmail2);
			try {
				cisResult=smsCommunicaiton.sendFailureMessages(phoneNumber);
				} catch (Throwable e) {
					
					e.printStackTrace();
					cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResult.setErrorMessage(CISConstants.SMS_FAILED);
				} 
		
		    }	
	     
	     else{
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
			
			StringBuilder stringBuilder = new StringBuilder();

			String finalString="";
			String finalStringsms="";
			for (int i = 0; i < details.size(); i++) {
				
			GetRoomDetailsModel roomDetaisModel = new GetRoomDetailsModel();
			
			     typecode= details.get(i).typeCode;
			     title=details.get(i).title;
			     type=details.get(i).type;
			     checkIn=details.get(i).fromDate;
			     checkOut=details.get(i).toDate;
			     qty=details.get(i).quantity;
			     parkid=details.get(i).parkId;
			     price=details.get(i).price;
			     totalPrice=details.get(i).totalPrice;
			     
			     String s=
			    		 "Title :"+title+""+
			    		
			    		 "Quantity :"+qty+""+
			    		 "Price :"+price+"";
			    		 
			    		 
			    		// "<p>Total Price :"+totalPrice+"<p/>";
			    		
			    		 
			     stringBuilder.append(s);
			     finalString = stringBuilder.toString();
			     
			 	 roomDetails.add(roomDetaisModel);
				
				}
			
			     System.out.println(finalString);
			
			     /*String sms=
			    		 "Title :"+title+""+
			    		
			    		 "Quantity :"+qty+""+
			    		 " Price :"+price+""+
			    		 
			    		 
			    		 "Total Price :"+totalPrice+"";
			    		
			    		 
			     stringBuilder.append(sms);
			     finalStringsms = stringBuilder.toString();*/
			
			cisResult.setResultObject(roomDetails);
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
				
				suppEmail= suppdetails.get(i).emailId;
			    suppCell=suppdetails.get(i).cell;
				suppLand=suppdetails.get(i).land;
		        supplierDetails.add(supplierDetaisModel);
				
			}
			 cisResult.setResultObject(supplierDetails);
			 
			 if(cod.equalsIgnoreCase(CISConstants.PAYMENTSUCCESS)){
			
				 cisResult=sendMail.sendPaymentstatus(paymentEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate);
				// cisResult=sendMail.sendPaymentstatusTest(paymentEmail,firstName,transactionId,roomDetails,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
			    	
				 cisResult=sendMail.sendAdminSuccessMail(firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate);
			
				 cisResult=sendMail.sendSupplierSuccessMail(suppEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,createDate);
				 try {
						//cisResult=smsCommunicaiton.sendMessages(phoneNumber,parkName,address,city,finalString);
					 cisResult=smsCommunicaiton.sendMessages(phoneNumber,parkName,address,city,finalString,totalPrice);
						
					 } catch (Throwable e) {
							
							e.printStackTrace();
							cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
							cisResult.setErrorMessage(CISConstants.SMS_FAILED);
						} 
			 
			 }else if(cod.equalsIgnoreCase(CISConstants.COD)){
				
				cisResult=sendMail.sendPaymentstatusCOD(paymentEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate);
				/// cisResult=sendMail.sendPaymentstatusTest(paymentEmail,firstName,transactionId,finalString,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
				    
				cisResult=sendMail.sendAdminSuccessMailCOD(firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate);
		    	
				cisResult=sendMail.sendSupplierSuccessMailCOD(suppEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,createDate);
				try {
					//cisResult=smsCommunicaiton.sendMessagesCOD(phoneNumber,parkName,address,city,title,qty,checkIn,checkOut,totalPrice);
					cisResult=smsCommunicaiton.sendMessagesCOD(phoneNumber,parkName,address,city,finalString,totalPrice);
					
				} catch (Throwable e) {
					e.printStackTrace();
					cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
					cisResult.setErrorMessage(CISConstants.SMS_FAILED);
				}
				
			}
			 
			
			// get current availability
			 cisResult = successDAO.getAvailablility(transactionId);
		
			 cisResult = successDAO.getUpdateAvailablility(transactionId);
		
	     } 
	     
			// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 logger.info("Database time for payment status service:: " +result );
			  
		 return cisResult;
		}

	}

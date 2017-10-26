package com.od;


import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		 
		 //DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss aa");
		 Calendar cal = Calendar.getInstance();
		 System.out.println(dateFormat.format(cal.getTime()));
		 
		 String createDate=dateFormat.format(cal.getTime());
	  		 
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
	    	 float total=0;
	    	 String type="";
	    	 String  suppEmail="";
	    	 String suppCell="";
	    	 String suppLand="";
	    	 Date reservationDate=null;
	    	
			ArrayList<Object> roomDetails = new ArrayList<Object>();
			
			StringBuilder stringBuilder = new StringBuilder();
			StringBuilder msgstringBuilder = new StringBuilder();
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
			     reservationDate=details.get(i).reservationDate;
			     String convertNullValue = CISConstants.NULLVALUE_CONVERTION;
			     String result = "";
			     total=qty*price;
			    	 
			    	 String message=
				    		 "Title :"+title+""+
				    		
				    		 "Quantity :"+qty+""+
				    		 "Price :"+price+"";
				    		 
			    	 if (checkIn == null) {
				    		
				    		// "<p>Total Price :"+totalPrice+"<p/>";
				      result="<tr style='border-bottom: 1px solid #ccc;padding:10px;'><td style='padding: 8px; text-align:center;'>"+title+"</td><td style='padding: 8px; text-align:center;'>"+convertNullValue+"</td><td style='padding: 8px; text-align:center;'>"+convertNullValue+"</td><td style='padding: 8px; text-align:center;'>"+reservationDate+"</td><td style='padding: 8px; text-align:center;'>"+qty+"</td><td style='padding: 8px; text-align:center;'>1 Adult</td><td style='padding: 8px; text-align:center;'>"+price+"</td><td style='padding: 8px; text-align:center;'>N0 Extra Charges</td><td style='padding: 8px; text-align:center;'>"+total+"</td></tr>";
				    	
			    	 }
			    	 
			    	 if (reservationDate == null) {
			    		 result="<tr style='border-bottom: 1px solid #ccc;padding:10px;'><td style='padding: 8px; text-align:center;'>"+title+"</td><td style='padding: 8px; text-align:center;'>"+checkIn+"</td><td style='padding: 8px; text-align:center;'>"+checkOut+"</td><td style='padding: 8px; text-align:center;'>"+convertNullValue+"</td><td style='padding: 8px; text-align:center;'>"+qty+"</td><td style='padding: 8px; text-align:center;'>1 Adult</td><td style='padding: 8px; text-align:center;'>"+price+"</td><td style='padding: 8px; text-align:center;'>N0 Extra Charges</td><td style='padding: 8px; text-align:center;'>"+total+"</td></tr>";	 
			    	 }
			    	 
				     stringBuilder.append(result);
				     msgstringBuilder.append(message);
				     finalString = stringBuilder.toString();
				     finalStringsms = msgstringBuilder.toString();
				 	 roomDetails.add(roomDetaisModel);
			    
				}
			
			     System.out.println(finalString);
			
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
			
				 cisResult=sendMail.sendPaymentstatus(paymentEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate,title,checkIn,checkOut,price,totalPrice,qty);
				// cisResult=sendMail.sendPaymentstatusTest(paymentEmail,firstName,transactionId,roomDetails,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
			    	
				 cisResult=sendMail.sendAdminSuccessMail(firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate,title,checkIn,checkOut,price,totalPrice,qty);
			
				 cisResult=sendMail.sendSupplierSuccessMail(suppEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,createDate,title,checkIn,checkOut,price,totalPrice,qty);
				 try {
						//cisResult=smsCommunicaiton.sendMessages(phoneNumber,parkName,address,city,finalStringsms);
					 cisResult=smsCommunicaiton.sendMessages(phoneNumber,parkName,address,city,finalStringsms,totalPrice);
						
					 } catch (Throwable e) {
							
							e.printStackTrace();
							cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
							cisResult.setErrorMessage(CISConstants.SMS_FAILED);
						} 
			 
			 }else if(cod.equalsIgnoreCase(CISConstants.COD)){
				
				cisResult=sendMail.sendPaymentstatusCOD(paymentEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate,title,checkIn,checkOut,price,totalPrice,qty);
				/// cisResult=sendMail.sendPaymentstatusTest(paymentEmail,firstName,transactionId,finalString,streetAddress,city,state,pin,parkName,suppCell,suppEmail);
				    
				cisResult=sendMail.sendAdminSuccessMailCOD(firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,suppEmail,createDate,title,checkIn,checkOut,price,totalPrice,qty);
		    	
				cisResult=sendMail.sendSupplierSuccessMailCOD(suppEmail,firstName,transactionId,finalString,totalPrice,streetAddress,city,state,pin,parkName,suppCell,createDate,title,checkIn,checkOut,price,totalPrice,qty);
				try {
					//cisResult=smsCommunicaiton.sendMessagesCOD(phoneNumber,parkName,address,city,title,qty,checkIn,checkOut,totalPrice);
					cisResult=smsCommunicaiton.sendMessagesCOD(phoneNumber,parkName,address,city,finalStringsms,totalPrice);
					
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

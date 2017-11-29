package com.od;


import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.digest.DigestUtils;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODCreateUserBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODCreateUserDAO createUserDAO=(ODCreateUserDAO)ctx.getBean("createUserDAO");
	  
	/**
	 * @param create user
	 * @return 1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	public CISResults createUser(ODCreateUserModel createUser) throws Throwable {
		
		 // Capture service Start time
	       	 EmailCommunication sendMail=new EmailCommunication();
	         CISResults cisResults=new CISResults();
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
	         List<PackageDetails> facilityList=null;	
			 final Logger logger = Logger.getLogger(ODCreateUserBL.class);
			 String title="";
			 float price=0;
			 String typeCode="";
			 String type="";
			 float rate=0;
			 int quantity=0;
			
			 String createDate=time.getTimeZone();
			 int parkId=createUser.getParkId();
			 String sessionId = UUID.randomUUID().toString();
	         String userId=DigestUtils.sha256Hex(sessionId);
	         String upToNCharacters = userId.substring(0, Math.min(userId.length(), 6));
	         userId=upToNCharacters;
	         String sessionId2 = UUID.randomUUID().toString();
	         String reservationId=DigestUtils.sha256Hex(sessionId2);
	         String upToNCharacters2 = reservationId.substring(0, Math.min(reservationId.length(),8));
	         reservationId=upToNCharacters2;
	          
	        //  cisResults = createUserDAO.getAvailablility(parkId);

		     // To get list items
			 int packageSize= createUser.getPackageList().size();
			 
			
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONEIND);
		     formatter.setTimeZone(obj);
		  
			 // cisResults = createUserDAO.createUser(userId,createUser.getFirstName(),createUser.getLastName(),createUser.getEmailId(),createUser.getPhoneNumber1(),createUser.getPhoneNumber2(),createUser.getAddress1(),createUser.getAddress2(),createUser.getCity(),createUser.getState(),createUser.getPincode(),createDate,createUser.getReservationDate(),createUser.getAdults(),createUser.getChild(),createUser.getOriginalAmount(),createUser.getDiscountAmount(),createUser.getCollectAmount(),createUser.getCouponCode());
            
		     cisResults = createUserDAO.createUser(userId,createUser.getFirstName(),createUser.getLastName(),createUser.getEmailId(),createUser.getPhoneNumber1(),createUser.getPhoneNumber2(),createUser.getAddress1(),createUser.getAddress2(),createUser.getCity(),createUser.getState(),createUser.getPincode(),createDate,createUser.getReservationDate(),createUser.getAdults(),createUser.getChild());

		     if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
             {
		    	 // list of packages
		    	 for (int i = 0; i < packageSize; i++)
		    	 {
		    		 title = createUser.getPackageList().get(i).title;
		    		 price = createUser.getPackageList().get(i).price;
		    		 typeCode =  createUser.getPackageList().get(i).typeCode;
		    		 quantity =  createUser.getPackageList().get(i).quantity;
		    		 type =  createUser.getPackageList().get(i).type;
		    		 float originalamount = createUser.getPackageList().get(i).originalamount;
		    		  float discountamount = createUser.getPackageList().get(i).discountamount;
		    		  
		    		  float collectamount = createUser.getPackageList().get(i).collectamount;
		    		  int packageId = createUser.getPackageList().get(i).packageId;
		    		 
		    		  
					cisResults = createUserDAO.createUserDetails(reservationId,parkId,packageId,title,price,typeCode,quantity,type,createUser.getFromDate(),createUser.getToDate(),createUser.getReservationDate(),createUser.getTotalPrice(),createUser.getStatus(),createDate,discountamount,originalamount,collectamount);
				 
		    	 }
			
             }

		     if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
             {	
		    	 
		    float originalAmount = 0;
			float discountAmount = 0;
			float collectAmount = 0;
			String couponCode = " ";
			int parkid = createUser.getParkId();
			int adults = createUser.getAdults();
			int child = createUser.getChild();
			String fName=createUser.getFirstName();
			String emailId=createUser.getEmailId();
			String phone=createUser.getPhoneNumber1();
			originalAmount=createUser.getOriginalAmount();
			discountAmount=createUser.getDiscountAmount();
			collectAmount=originalAmount-discountAmount;
	
			cisResults = createUserDAO.createUserHeader(userId,parkid,reservationId,fName,phone,emailId,createUser.getReservedDate(),createDate,adults,child,originalAmount,discountAmount,collectAmount,couponCode);
             }
			
			 String serviceEndTime=time.getTimeZone();
			 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Database time for create user service:: " +result );

			 return cisResults;
		}

	}

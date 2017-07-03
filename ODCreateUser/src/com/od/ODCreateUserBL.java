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
	
	// private static final AtomicInteger count = new AtomicInteger(12600002); 
	// private static final AtomicInteger count2 = new AtomicInteger(1994343);  
	  
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
			
			// FacilityDetails facilitydetails=new FacilityDetails();
			 String title="";
			 float price=0;
			 String typeCode="";
			 String type="";
			 float rate=0;
			 int quantity=0;
			
			 String createDate=time.getTimeZone();
			 int parkId=createUser.getParkId();
			 String email=createUser.getEmailId();
		   	 String room=createUser.getFaciltiyTypecode();	 
		   	 float roomPrice=createUser.getTotalPrice();
		     String firstName=createUser.getFirstName();
		     Date checkIn=createUser.getFromDate();
		     Date checkOut=createUser.getToDate();
		    // SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
		    
			// int userId = count.incrementAndGet();
		      String sessionId = UUID.randomUUID().toString();
	          String userId=DigestUtils.sha256Hex(sessionId);
	          String upToNCharacters = userId.substring(0, Math.min(userId.length(), 6));
	          userId=upToNCharacters;
	          
		     //int reservationId = count2.incrementAndGet();
	          String sessionId2 = UUID.randomUUID().toString();
	           String reservationId=DigestUtils.sha256Hex(sessionId2);
	           String upToNCharacters2 = reservationId.substring(0, Math.min(reservationId.length(),8));
	           reservationId=upToNCharacters2;
		     // To get list items
			 int packageSize= createUser.getPackageList().size();
			 
			 for (int i = 0; i < packageSize; i++)
			 {
				 title = createUser.getPackageList().get(i).title;
				 price = createUser.getPackageList().get(i).price;
				 typeCode =  createUser.getPackageList().get(i).typeCode;
				 quantity =  createUser.getPackageList().get(i).quantity;
				 type =  createUser.getPackageList().get(i).type;
								 
				 cisResults = createUserDAO.createUser2(reservationId,parkId,title,price,typeCode,quantity,type,createUser.getFromDate(),createUser.getToDate(),createUser.getTotalPrice(),createUser.getStatus(),createDate);
					  
			 }
			
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE2);
		     formatter.setTimeZone(obj);
		  
		     
			  cisResults = createUserDAO.createUser(userId,createUser.getFirstName(),createUser.getLastName(),createUser.getEmailId(),createUser.getPhoneNumber1(),createUser.getPhoneNumber2(),createUser.getAddress1(),createUser.getAddress2(),createUser.getCity(),createUser.getState(),createUser.getPincode(),createDate);
			
			 // cisResults = createUserDAO.createUser2(reservationId,createUser.getParkId(),createUser.getUserType(),createUser.getFaciltiyTypecode(),createUser.getFromDate(),createUser.getToDate(),createUser.getQty(),createUser.getTotalPrice(),createUser.getStatus(),createDate);
			 // cisResults = createUserDAO.createUser2(reservationId,parkId,createUser.getUserType(),Facilitytitle,Facilityprice,Facilitycode,Roomtitle,Roomprice,RoomQuantity,createUser.getFromDate(),createUser.getToDate(),createUser.getTotalPrice(),createUser.getStatus(),createDate);
						
			  cisResults = createUserDAO.createUser3(userId,reservationId,createUser.getReservedDate(),createDate);
			
			// cisResults = createUserDAO.createFacilityDetails(parkId,facilityCode,rate,qty);
			 
			// cisResults.setFacilityList(facilityList);
			 
			 /* FacilityDetails  type=(FacilityDetails)cisResults.getResultObject();
			  String facilityType=type.getFacilityType();
			  float price=type.getPrice();*/
				
			 
			 
			/* if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
			   {
				  cisResults=sendMail.sendPackageMail(email,reservationId,firstName,Facilitytitle,Facilityprice,FacilityQuantity,Roomtitle,Roomprice,RoomQuantity);
			   }*/
			 
			 
			// cisResults  = createUserDAO.pay();
			 
			 // Capture Service End time
			 
			 String serviceEndTime=time.getTimeZone();
			 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("Database time for create user service:: " +result );

			 return cisResults;
		}

	}

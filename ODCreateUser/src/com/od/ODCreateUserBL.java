package com.od;


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

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class ODCreateUserBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODCreateUserDAO createUserDAO=(ODCreateUserDAO)ctx.getBean("createUserDAO");
	
	 private static final AtomicInteger count = new AtomicInteger(100001); 
	  
	  
	/**
	 * @param create user
	 * @return 1 in case of error or 0 if successful
	 */
	public CISResults createUser(ODCreateUserModel createUser) {
		
		 // Capture service Start time
		
	         TimeCheck time=new TimeCheck();
	         testServiceTime seriveTimeCheck=new testServiceTime();
	         String serviceStartTime=time.getTimeZone();
		 			
			 final Logger logger = Logger.getLogger(ODCreateUserBL.class);
			// int parkId = count.incrementAndGet();
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE2);
		     formatter.setTimeZone(obj);
		   //  String ODDate=formatter.format(currentdate.getTime());
		     /* String sessionId = UUID.randomUUID().toString();
		      String userId=DigestUtils.sha1Hex(sessionId);
		      String upToNCharacters = userId.substring(0, Math.min(userId.length(), 8));
		      userId=upToNCharacters;
		      String reservationId=DigestUtils.sha1Hex(sessionId);
		      String upToNCharacters2 = userId.substring(0, Math.min(userId.length(), 6));
		      reservationId=upToNCharacters2;*/
		     TimeCheck time1=new TimeCheck();
		      String createDate=time.getTimeZone();
		      
		     Random rnd = new Random();
		     int userId = 100000 + rnd.nextInt(900000);
		     
		     Random rnd2 = new Random();
		     int reservationId = 100000000 + rnd.nextInt(900000000);
		     
			  CISResults cisResults = createUserDAO.createUser(userId,createUser.getFirstName(),createUser.getLastName(),createUser.getPhoneNumber1(),createUser.getPhoneNumber2(),createUser.getAddress1(),createUser.getAddress2(),createUser.getCity(),createUser.getState(),createUser.getPincode(),createDate);
			  cisResults = createUserDAO.createUser2(reservationId,createUser.getParkId(),createUser.getUserType(),createUser.getFaciltiyTypecode(),createUser.getFromDate(),createUser.getToDate(),createUser.getQty(),createUser.getTotalPrice(),createUser.getStatus(),createDate);
			  cisResults = createUserDAO.createUser3(userId,reservationId,createUser.getReservedDate(),createDate);
				
			   // Capture Service End time

			    String serviceEndTime=time.getTimeZone();
			    long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			    logger.info("Database time for create user service:: " +result );

			 return cisResults;
		}

	}

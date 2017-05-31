package com.od;


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
					
		final Logger logger = Logger.getLogger(ODPaymentSuccessBL.class);
			 
	     cisResult = successDAO.paymentSuccess(transactionId,status);
	    
	     
	     if(status.equalsIgnoreCase(CISConstants.STATUS1)){
	    	cisResult = successDAO.paymentEmail(transactionId);
			String paymentEmail="";
			ODPaymentSuccessModel  emailId=(ODPaymentSuccessModel)cisResult.getResultObject();
			paymentEmail=emailId.getEmailId();
			
				 
			cisResult=sendMail.sendPaymentstatus(paymentEmail);
	    	
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

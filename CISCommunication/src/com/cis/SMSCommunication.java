package com.cis;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class SMSCommunication {
	public CISResults sendMessages(String phoneNumber) throws Throwable {
		// TODO Auto-generated method stub
		final Logger logger = Logger.getLogger(SMSCommunication.class);
		CISResults cisResult=new CISResults();
		String postData="";
         String retval = "";
         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
         // TODO: Remove hard coded data.
         String Username =	CISConstants.USERNAME;
         String Password =	CISConstants.PASSWORD;
         String SenderID = 	CISConstants.SENDERID; 
         String resp="Y";
         //String Type=		CISConstants.TYPE;
        
         String Message = "Your payment was successful " ;
         postData += "username=" + Username + "&pass=" + Password + "&senderid=" +           
        		 SenderID +"&message=" +Message + "&dest_mobileno="+phoneNumber+"&response="+resp;
		 URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
		 HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
         urlconnection.setRequestMethod("POST");
         urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
         urlconnection.setDoOutput(true);
         OutputStreamWriter out = new            
         OutputStreamWriter(urlconnection.getOutputStream());
         out.write(postData);
         out.close();
         BufferedReader in = new BufferedReader( new  InputStreamReader(urlconnection.getInputStream()));
         String decodedString;
         while ((decodedString = in.readLine()) != null) {
               retval += decodedString;
         }
         in.close();
         logger.info("SMS STATUS: "+retval);  
         // Get Status Of SMS 
         
       /*  DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
         InputSource src = new InputSource();
         src.setCharacterStream(new StringReader(retval));

         Document doc = builder.parse(src);
         String status = doc.getElementsByTagName("status").item(0).getTextContent();
         String messageId = doc.getElementsByTagName("messageid").item(0).getTextContent();
         
       //  System.out.println(status);
        // System.out.println(messageId);
         // TODO: Remove hard coded data.
         String  wrongNumber= "-13";
         String noBal = "-2";
         String statusSucess="0";
        
         if(status.equalsIgnoreCase(wrongNumber))
         {   //System.out.println("SMS FAILED DUE TO WRONG NUMBER ENTER.");
        	  cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
  			  cisResult.setErrorMessage(CISConstants.WRONG_PHONE_NUMBER);
         }
         if(status.equalsIgnoreCase(noBal))  
         {
        	// System.out.println("SMS FAILED DUE TO No Balance in account.");    	 
        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
  			 cisResult.setErrorMessage(CISConstants.PHONE_NUMBER_SERVER_ISSUE);	 
         }
         if(status.equalsIgnoreCase(statusSucess))
         {
        	// System.out.println("SMS FAILED ");
        	 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
         }     */
         return cisResult;
	}

	public CISResults sendFailureMessages(String phoneNumber) throws Throwable{

		 final Logger logger = Logger.getLogger(SMSCommunication.class);
		 CISResults cisResult=new CISResults();
		 String postData="";
         String retval = "";
         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
         // TODO: Remove hard coded data.
         String Username =	CISConstants.USERNAME;
         String Password =	CISConstants.PASSWORD;
         String SenderID = 	CISConstants.SENDERID; 
         String resp="Y";
         //String Type=		CISConstants.TYPE;
        
         String Message = "Sorry, your payment is un-successful " ;
         postData += "username=" + Username + "&pass=" + Password + "&senderid=" +           
        		 SenderID +"&message=" +Message + "&dest_mobileno="+phoneNumber+"&response="+resp;
		 URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
		 HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
         urlconnection.setRequestMethod("POST");
         urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
         urlconnection.setDoOutput(true);
         OutputStreamWriter out = new            
         OutputStreamWriter(urlconnection.getOutputStream());
         out.write(postData);
         out.close();
         BufferedReader in = new BufferedReader( new  InputStreamReader(urlconnection.getInputStream()));
         String decodedString;
         while ((decodedString = in.readLine()) != null) {
               retval += decodedString;
         }
         in.close();
         logger.info("SMS STATUS: "+retval);  
         
		return cisResult;
	}
	
	
}

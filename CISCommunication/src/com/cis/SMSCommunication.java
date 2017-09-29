package com.cis;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.json.JSONSerializer;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.od.ParkAddress;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class SMSCommunication {
	public CISResults sendMessages(String phoneNumber, String parkName, ParkAddress address, String city, String finalString,float totalPrice) throws Throwable {
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
        // String Key="167320AnSc8m60597a0a95";
         String Key=CISConstants.key;
         String sender="ABCDEF";
         String route="4";
         int country=0;
         //String Type=		CISConstants.TYPE;
        
         //String Message = "Your payment was successful " ;
         String Message= "Your payment was successful "+parkName+", "+city+" "+
			
			"Park details : "+finalString+
			"Total price : "+totalPrice;
        
         postData += "authkey=" + Key + "&mobiles=" + phoneNumber + "&message=" +           
        		 Message +"&sender=" +sender + "&route="+route+"&country="+country;
         
		// URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
         URL url = new URL("https://control.msg91.com/api/sendhttp.php?");
		 
 //https://control.msg91.com/api/sendhttp.php?authkey=YourAuthKey&mobiles=919999999990,919999999999&message=message&sender=ABCDEF&route=4&country=0
		 
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
         
        // String statusSucess="200";
         // Get Status Of SMS 
         
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
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
         }     
         return cisResult;
	}

	
	/*public CISResults sendMessages(String phoneNumber, String parkName, ParkAddress address, String city, String title, int qty, Date checkIn, Date checkOut, float totalPrice) throws Throwable {
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
        // String Key="167320AnSc8m60597a0a95";
         String Key=CISConstants.key;
         String sender="ABCDEF";
         String route="4";
         int country=0;
         //String Type=		CISConstants.TYPE;
        
         //String Message = "Your payment was successful " ;
         String Message= "Your payment was successful "+parkName+", "+city+" "+
			"CheckIn Date :"+checkIn+
			"CheckOut Date :"+checkOut+
			"Facility quantity :"+qty+
			"Facility Type :"+title+
			"Total Price : "+totalPrice;
         postData += "username=" + Username + "&pass=" + Password + "&senderid=" +           
        		 SenderID +"&message=" +Message + "&dest_mobileno="+phoneNumber+"&response="+resp;
         postData += "authkey=" + Key + "&mobiles=" + phoneNumber + "&message=" +           
        		 Message +"&sender=" +sender + "&route="+route+"&country="+country;
         
		// URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
         URL url = new URL("https://control.msg91.com/api/sendhttp.php?");
		 
 //https://control.msg91.com/api/sendhttp.php?authkey=YourAuthKey&mobiles=919999999990,919999999999&message=message&sender=ABCDEF&route=4&country=0
		 
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
         
        // String statusSucess="200";
         // Get Status Of SMS 
         
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
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
         }     
         return cisResult;
	}*/
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
         
         // String Key="167320AnSc8m60597a0a95";
         String Key=CISConstants.key;
         String sender="ABCDEF";
         String route="4";
         int country=0;
         //String Type=		CISConstants.TYPE;
        
         String Message = "Sorry, your payment is un-successful " ;
        /* postData += "username=" + Username + "&pass=" + Password + "&senderid=" +           
        		 SenderID +"&message=" +Message + "&dest_mobileno="+phoneNumber+"&response="+resp;
		 URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");*/
         
         postData += "authkey=" + Key + "&mobiles=" + phoneNumber + "&message=" +           
        		 Message +"&sender=" +sender + "&route="+route+"&country="+country;
         
		// URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
         URL url = new URL("https://control.msg91.com/api/sendhttp.php?");
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

	public CISResults sendMessagesCOD(String phoneNumber, String parkName,
			ParkAddress address, String city, String finalString,float totalPrice) throws Throwable {
		//String phone="9440069067";
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
         // String Key="167320AnSc8m60597a0a95";
         String Key=CISConstants.key;
         String sender="ABCDEF";
         String route="4";
         int country=0;
          String Message= "Your COD was registered "+parkName+", "+city+" "+
			"Park details :"+finalString+
			"Total price : "+totalPrice;
			
       
         postData += "authkey=" + Key + "&mobiles=" + phoneNumber + "&message=" +           
        		 Message +"&sender=" +sender + "&route="+route+"&country="+country;
         
		// URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
         URL url = new URL("https://control.msg91.com/api/sendhttp.php?");
		 
 //https://control.msg91.com/api/sendhttp.php?authkey=YourAuthKey&mobiles=919999999990,919999999999&message=message&sender=ABCDEF&route=4&country=0
		 
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
         cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
      
         return cisResult;
	}

	/*public CISResults sendMessagesCOD(String phoneNumber, String parkName,
			ParkAddress address, String city, String title, int qty,
			Date checkIn, Date checkOut, float totalPrice) throws Throwable {
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
         // String Key="167320AnSc8m60597a0a95";
         String Key=CISConstants.key;
         String sender="ABCDEF";
         String route="4";
         int country=0;
         //String Type=		CISConstants.TYPE;
        
         //String Message = "Your payment was successful " ;
         String Message= "Your COD was registered "+parkName+", "+city+" "+
			"CheckIn Date :"+checkIn+
			"CheckOut Date :"+checkOut+
			"Facility quantity :"+qty+
			"Facility Type :"+title+
			"Total Price : "+totalPrice;
         postData += "username=" + Username + "&pass=" + Password + "&senderid=" +           
        		 SenderID +"&message=" +Message + "&dest_mobileno="+phoneNumber+"&response="+resp;
         postData += "authkey=" + Key + "&mobiles=" + phoneNumber + "&message=" +           
        		 Message +"&sender=" +sender + "&route="+route+"&country="+country;
         
		// URL url = new URL("http://123.63.33.43/blank/sms/user/urlsmstemp.php?");
         URL url = new URL("https://control.msg91.com/api/sendhttp.php?");
		 
 //https://control.msg91.com/api/sendhttp.php?authkey=YourAuthKey&mobiles=919999999990,919999999999&message=message&sender=ABCDEF&route=4&country=0
		 
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
         cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
      
         return cisResult;
	}*/
	
		public CISResults sendSMS(String phoneNumber) throws Throwable {
			// TODO Auto-generated method stub
			CISResults cisResult=new CISResults();
			String postData="";
	         String retval = "";
	         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
	         // TODO: Remove hard coded data.
	         // String Key="167320AnSc8m60597a0a95";
	         String Key=CISConstants.key;
	         String sender="OUTINGDAY";
	         int time=10;
	         int otpLength=5;
	       //  String Message= "Your otp "+otpNumber+"";
	         //String otp="otpNumber";                     
	     			
	               postData += "authkey=" + Key + "&mobile=" +phoneNumber + "&sender=" +sender+ "&otp_expiry="+time+ "&otp_length="+otpLength;
	              URL url = new URL("https://control.msg91.com/api/sendotp.php?");
	              
//	              /https://control.msg91.com/api/sendotp.php?authkey=168330ATcoDwWh598345fa&mobile=8686846199&sender=OUTINGDAY&otp_expiry=10&otp_length=5   
	     	//&otp=2786	 
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
	         System.out.println("SMS STATUS: "+retval);
	      
	       //  JSONObject json = (JSONObject) JSONSerializer.toJSON(retval); 
	      //   JSONParser parser = new JSONParser();

	         
	         
	        // String type = json.getString("type");
	         
	        
	         JSONObject jsonObj = new JSONObject(retval);
	         String name = jsonObj.getString("type");
	         System.out.println(name);
	         
	         if(name.equalsIgnoreCase("success"))
	           {
	          	// System.out.println("SMS FAILED ");
	          	 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	           }
	         else{
	        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	         }
	         
	        /* // Get Status Of SMS 
	         
	           DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	           InputSource src = new InputSource();
	           src.setCharacterStream(new StringReader(retval));

	           Document doc = builder.parse(src);
	           String status = doc.getElementsByTagName("status").item(0).getTextContent();
	           String messageId = doc.getElementsByTagName("messageid").item(0).getTextContent();
	           
	         //  System.out.println(status);
	          // System.out.println(messageId);
	           // TODO: Remove hard coded data.
	           String  wrongNumber= "202";
	           String noBal = "301";
	           String statusSucess="success";
	          
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

		public String sendRegisterSMS(String contact, String firstName) throws Throwable {
			// TODO Auto-generated method stub
			CISResults cisResult=new CISResults();
			String postData="";
	         String retval = "";
	         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
	         // TODO: Remove hard coded data.
	         // String Key="167320AnSc8m60597a0a95";
	         String Key=CISConstants.key;
	         String sender="ABCDEF";
	         String route="4";
	         int country=0;
	         String Message= "Hi "+firstName+" , you are successfully registered" ;
	     			
	               postData += "authkey=" + Key + "&mobiles=" + contact + "&message=" +           
	             		 Message +"&sender=" +sender + "&route="+route+"&country="+country;
	              URL url = new URL("https://control.msg91.com/api/sendhttp.php?");
	     		 
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
	         System.out.println("SMS STATUS: "+retval);
	         
	
	          cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		      return "";
		}


		public CISResults verifyOtp(String phoneNumber, String otp) throws JSONException, Throwable {
			// TODO Auto-generated method stub


			CISResults cisResult=new CISResults();
			String postData="";
	         String retval = "";
	         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
	         // TODO: Remove hard coded data.
	         // String Key="167320AnSc8m60597a0a95";
	         String Key=CISConstants.key;
	         String sender="OUTINGDAY";
	         int time=10;
	         int otpLength=5;
	       //  String Message= "Your otp "+otpNumber+"";
	         //String otp="otpNumber";                     
	     			
	               postData += "authkey=" + Key + "&mobile=" +phoneNumber + "&otp=" +otp+ "&otp_expiry="+time+ "&otp_length="+otpLength;
	              URL url = new URL("https://control.msg91.com/api/verifyRequestOTP.php?");
	              
//	            
	             // https://control.msg91.com/api/verifyRequestOTP.php?authkey=168330ATcoDwWh598345fa&mobile=8686846199&otp=4201    
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
	         System.out.println("SMS STATUS: "+retval);
	      
	       //  JSONObject json = (JSONObject) JSONSerializer.toJSON(retval); 
	      //   JSONParser parser = new JSONParser();

	         
	         
	        // String type = json.getString("type");
	         
	        
	         JSONObject jsonObj = new JSONObject(retval);
	         String name = jsonObj.getString("type");
	         System.out.println(name);
	         
	         if(name.equalsIgnoreCase("success"))
	           {
	          	// System.out.println("SMS FAILED ");
	          	 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	           }
	         else  if(name.equalsIgnoreCase("error")){
	        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	         }
	         
	 	      
		      return cisResult;
		}


		public CISResults sendSMSManually(String contact, int otpNumber) throws Throwable {


			CISResults cisResult=new CISResults();
			String postData="";
	         String retval = "";
	         //KAP SYSTEMS PROVIDERS LOGIN DETAILS DEMO ACCOUNT DETAILS
	         // TODO: Remove hard coded data.
	         // String Key="167320AnSc8m60597a0a95";
	         String Key=CISConstants.key;
	         String sender="OUTINGDAY";
	         int time=10;
	         int otpLength=5;
	       //  String Message= "Your otp "+otpNumber+"";
	         //String otp="otpNumber";                     
	     			
	               postData += "authkey=" + Key + "&mobile=" +contact + "&sender=" +sender+ "&otp_expiry="+time+ "&otp_length="+otpLength;
	              URL url = new URL("https://control.msg91.com/api/sendotp.php?");
	              
//	              /https://control.msg91.com/api/sendotp.php?authkey=168330ATcoDwWh598345fa&mobile=8686846199&sender=OUTINGDAY&otp_expiry=10&otp_length=5   
	     	//&otp=2786	 
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
	         System.out.println("SMS STATUS: "+retval);
	      
	       //  JSONObject json = (JSONObject) JSONSerializer.toJSON(retval); 
	      //   JSONParser parser = new JSONParser();

	         
	         
	        // String type = json.getString("type");
	         
	        
	         JSONObject jsonObj = new JSONObject(retval);
	         String name = jsonObj.getString("type");
	         System.out.println(name);
	         
	         if(name.equalsIgnoreCase("success"))
	           {
	          	// System.out.println("SMS FAILED ");
	          	 cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	           }
	         else{
	        	 cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	         }
	         
	        /* // Get Status Of SMS 
	         
	           DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	           InputSource src = new InputSource();
	           src.setCharacterStream(new StringReader(retval));

	           Document doc = builder.parse(src);
	           String status = doc.getElementsByTagName("status").item(0).getTextContent();
	           String messageId = doc.getElementsByTagName("messageid").item(0).getTextContent();
	           
	         //  System.out.println(status);
	          // System.out.println(messageId);
	           // TODO: Remove hard coded data.
	           String  wrongNumber= "202";
	           String noBal = "301";
	           String statusSucess="success";
	          
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

	
}

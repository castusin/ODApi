package com.cis;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCommunication {
	
	public String sendMailWithAuth(String host, String user, String password,
	        String port, String to, String body, String subject) throws Exception{
	   
	    
	    Properties props = System.getProperties();

	      props.put("mail.smtp.user", user);
	      props.put("mail.smtp.password", password);
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);
	      props.put("mail.debug", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "false");
	      props.put("mail.smtp.EnableSSL.enable", "false");

	      Session session = Session.getInstance(props, null);
	      session.setDebug(true);

	      MimeMessage message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(user));

	      // To get the array of addresses    
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


	      message.setSubject(subject);
	    
	      message.setContent(body, "text/html");

	  
	      Transport transport = session.getTransport("smtp");
	      try {
	          transport.connect(host, user, password);
	          transport.sendMessage(message, message.getAllRecipients());
	          Transport.send(message);
	          transport.close();
	         
	        
	      } finally {
	         
	      }
	      return "0";
	    
	    
	}
	
	

	public CISResults sendPaymentFailure(String paymentEmail) {
		CISResults cisResult = new CISResults();
		//String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Outing Day</b><br />"+
                 
                "<p>Failed payment. "+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outing Day Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,paymentEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	

	public CISResults sendPaymentstatusCOD(String paymentEmail,
			String firstName, 
			String transactionId, String finalString,float totalPrice,
			String streetAddress, String city, String state, int pin,
			String parkName, String suppCell, String suppEmail) {
		
		String emailid="udaykatikala@gmail.com";
				
		CISResults cisResult = new CISResults();
	
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='width:700px'>\n" +
                "<div style='float:left;width:350px'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - NH210293696613</p><p>Booking Date - Tue, 15 July 14 03:18 PM</p></div><div style='float:right;width:350px'><img style='float:right;' src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='width:700px;clear:both;background-color:blue;height:2px;'></div>\n"+
                "<p >Dear <b style='color:#000'>"+firstName+"</b><a style='float:right' href='#'>print Booking Confirmation</a><br />"+
                "<p>Cash develiery sucesfully applyied, you will get call ASAP<br />"+
                "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
                "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
                "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
                "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
                "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
                "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
                "<p><b>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#ccc;color:#000;font-weight:500;line-height:24px;padding:10px 15px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p><b>"+parkName+", "+city+"  </b><br />"+
				"<p>"+streetAddress+"<br />"+
				"<p>"+city+", IN<br />"+
				"<p>Contact : "+suppCell+"<br />"+
				"<p>Fax : <br />"+
				"<p>E-mail : "+suppEmail+" <br /><br />"+
				"<p><b>Primary Guest :</b>"+firstName+" <br />"+
				
				"<p><b>Park details : "+finalString+"</b>"+
				"<p><b>Total price : "+totalPrice+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,paymentEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}


	public CISResults sendAdminSuccessMailCOD(String firstName, String transactionId, String finalString,float totalPrice,String streetAddress, String city,
			String state, int pin, String parkName, String suppCell,
			String suppEmail) {
		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='width:700px'>\n" +
                "<div style='float:left;width:350px'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - NH210293696613</p><p>Booking Date - Tue, 15 July 14 03:18 PM</p></div><div style='float:right;width:350px'><img style='float:right;' src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='width:700px;clear:both;background-color:blue;height:2px;'></div>\n"+
                "<p >Dear <b style='color:#000'>"+firstName+"</b><a style='float:right' href='#'>print Booking Confirmation</a><br />"+
                "<p>Cash develiery sucesfully applyied, you will get call ASAP<br />"+
                "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
                "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
                "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
                "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
                "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
                "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
                "<p><b>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#ccc;color:#000;font-weight:500;line-height:24px;padding:10px 15px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p><b>"+parkName+", "+city+"  </b><br />"+
				"<p>"+streetAddress+"<br />"+
				"<p>"+city+", IN<br />"+
				"<p>Contact : "+suppCell+"<br />"+
				"<p>Fax : <br />"+
				"<p>E-mail : "+suppEmail+" <br /><br />"+
				"<p><b>Primary Guest :</b>"+firstName+" <br />"+
				
				"<p><b>Park details : "+finalString+"</b>"+
				"<p><b>Total price : "+totalPrice+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}



	public CISResults sendSupplierSuccessMailCOD(String suppEmail,
			String firstName, 
			String transactionId, String finalString,float totalPrice,
			String streetAddress, String city, String state, int pin,
			String parkName, String suppCell) {
		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='width:700px'>\n" +
                "<div style='float:left;width:350px'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - NH210293696613</p><p>Booking Date - Tue, 15 July 14 03:18 PM</p></div><div style='float:right;width:350px'><img style='float:right;' src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='width:700px;clear:both;background-color:blue;height:2px;'></div>\n"+
                "<p >Dear <b style='color:#000'>"+firstName+"</b><a style='float:right' href='#'>print Booking Confirmation</a><br />"+
                "<p>Cash develiery sucesfully applyied, you will get call ASAP<br />"+
                "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
                "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
                "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
                "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
                "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
                "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
                "<p><b>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#ccc;color:#000;font-weight:500;line-height:24px;padding:10px 15px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p><b>"+parkName+", "+city+"  </b><br />"+
				"<p>"+streetAddress+"<br />"+
				"<p>"+city+", IN<br />"+
				"<p>Contact : "+suppCell+"<br />"+
				"<p>Fax : <br />"+
				"<p>E-mail : "+suppEmail+" <br /><br />"+
				"<p><b>Primary Guest :</b>"+firstName+" <br />"+
				
				"<p><b>Park details : "+finalString+"</b>"+
				"<p><b>Total price : "+totalPrice+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,suppEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}


	public CISResults sendPaymentstatus(String paymentEmail, String firstName,
			 String transactionId,String finalString,float totalPrice, String streetAddress,
			 String city, String state, int pin, String parkName,
			 String suppCell, String suppEmail, String createDate) {

	     	CISResults cisResult = new CISResults();
	     
	     	
			String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='width:700px'>\n" +
                "<div style='float:left;width:350px'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - "+transactionId +"</p><p>Booking Date - "+createDate +"</p></div><div style='float:right;width:350px'><img style='float:right;' src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='width:700px;clear:both;background-color:blue;height:2px;'></div>\n"+
                "<p >Dear <b style='color:#000'>"+firstName+"</b><a style='float:right' href='#'>print Booking Confirmation</a><br />"+
                "<p><b>Your Booking is confirmed.</b> "+
                "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
                "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
                "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
                "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
                "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
                "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
                "<p><b>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#ccc;color:#000;font-weight:500;line-height:24px;padding:10px 15px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p><b>"+parkName+", "+city+"  </b><br />"+
				"<p>"+streetAddress+"<br />"+
				"<p>"+city+", IN<br />"+
				"<p>Contact : "+suppCell+"<br />"+
				"<p>Fax : <br />"+
				"<p>E-mail : "+suppEmail+" <br /><br />"+
				"<p><b>Primary Guest :</b>"+firstName+" <br />"+
				
				"<p><b>Park details : "+finalString+"</b>"+
				"<p><b>Total price : "+totalPrice+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,paymentEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendAdminSuccessMail(String firstName, String transactionId, String finalString,float totalPrice, String streetAddress, String city,
			String state, int pin, String parkName, String suppCell,
			String suppEmail, String createDate) {

		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='width:700px'>\n" +
                "<div style='float:left;width:350px'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - "+transactionId +"</p><p>Booking Date - "+createDate +"</p></div><div style='float:right;width:350px'><img style='float:right;' src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='width:700px;clear:both;background-color:blue;height:2px;'></div>\n"+
                "<p >Dear <b style='color:#000'>"+firstName+"</b><a style='float:right' href='#'>print Booking Confirmation</a><br />"+
                "<p><b>Your Booking is confirmed.</b> "+
                "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
                "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
                "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
                "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
                "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
                "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
                "<p><b>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#ccc;color:#000;font-weight:500;line-height:24px;padding:10px 15px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p><b>"+parkName+", "+city+"  </b><br />"+
				"<p>"+streetAddress+"<br />"+
				"<p>"+city+", IN<br />"+
				"<p>Contact : "+suppCell+"<br />"+
				"<p>Fax : <br />"+
				"<p>E-mail : "+suppEmail+" <br /><br />"+
				"<p><b>Primary Guest :</b>"+firstName+" <br />"+
				
				"<p><b>Park details : "+finalString+"</b>"+
				"<p><b>Total price : "+totalPrice+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}


	public CISResults sendSupplierSuccessMail(String suppEmail,
			String firstName, 
			String transactionId, String finalString,float totalPrice,
			String streetAddress, String city, String state, int pin,
			String parkName, String suppCell, String createDate) {


		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body style='width:700px'>\n" +
                "<div style='float:left;width:350px'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - "+transactionId +"</p><p>Booking Date - "+createDate +"</p></div><div style='float:right;width:350px'><img style='float:right;' src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='width:700px;clear:both;background-color:blue;height:2px;'></div>\n"+
                "<p >Dear <b style='color:#000'>"+firstName+"</b><a style='float:right' href='#'>print Booking Confirmation</a><br />"+
                "<p><b>Your Booking is confirmed.</b> "+
                "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
                "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
                "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
                "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
                "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
                "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
                "<p><b>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#ccc;color:#000;font-weight:500;line-height:24px;padding:10px 15px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p><b>"+parkName+", "+city+"  </b><br />"+
				"<p>"+streetAddress+"<br />"+
				"<p>"+city+", IN<br />"+
				"<p>Contact : "+suppCell+"<br />"+
				"<p>Fax : <br />"+
				"<p>E-mail : "+suppEmail+" <br /><br />"+
				"<p><b>Primary Guest :</b>"+firstName+" <br />"+
				
				"<p><b>Park details : "+finalString+"</b>"+
				"<p><b>Total price : "+totalPrice+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,suppEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}



	public String sendRegisterMail(String firstName, String lastName, String emailId) {

		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Dear "+firstName+"</b><br />"+
                 
                "<p><b>Successfully registered.</b> "+
               

				"<br />\n"+
				"<br />\n"+
				

                
                
				"<p><b>Inclusions </b><br />"+
				 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
					
				"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
                
                
				"<p><b>Hotel Cancellation Policy </b><br />"+
				 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
					
				"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
				"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
				
				"<p><b>General Hotel Policy </b><br />"+
				 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
					
				"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
				"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
				"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
				"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
				"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
				"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
				"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
				"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
				
				
				"<p><b>OutingDay Contact Info </b><br />"+
				 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
					
				"<p>Anay Web Solutions., "+
				"<p>1-5-95/21 sri Lakshmi nagar colony  "+
				"<p>Old alwal"+
				"<p>Secunderabad, "+
				"<p>Hyderabad, "+
				"<p>500010, "+
				"<p>India "+
				
				"<p>Email	:	connect@outinday.com "+
				"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

				"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
				
				
                
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outingday.com<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return "";
	}



	public CISResults sendPaymentstatusTest(String paymentEmail,
			String firstName, String transactionId,
			String finalString, String streetAddress, String city,
			String state, int pin, String parkName, String suppCell,
			String suppEmail) {

		String emailId="udaykatikala@gmail.com";
		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
            "<title></title>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
             "<p>Dear "+firstName+"</b><br />"+
             
            "<p><b>Your booking is confirmed.</b> "+
            "<p>Thank you for using outingday.com to book your  accommodation.</b><br />"+
            "<p>For your reference, your OutingDay Booking ID is :"+transactionId +"</b><br />"+
            "<p>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </b><br />"+
            "<p>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </b><br />"+
            "<p><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b><br />"+
            "<p><b>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br /><br />"+
            "<p><b>Team OutingDay.com</b><br /> "+
			"<p>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </b><br /><br />"+
           
				"<p><b>Hotel Details </b><br />"+
			    "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
			
			"<p><b>"+parkName+", "+city+"  </b><br />"+
			"<p>"+streetAddress+"<br />"+
			"<p>"+city+", IN<br />"+
			"<p>Contact : "+suppCell+"<br />"+
			"<p>Fax : <br />"+
			"<p>E-mail : "+suppEmail+" <br /><br />"+
			"<p><b>Primary Guest :</b>"+firstName+" <br />"+
			
			
			
			"<p><b>Park Details :"+finalString+"</b><br />"+
			
			
            
            "<br />\n"+
            "<br />\n"+
            
            
			"<p><b>Inclusions </b><br />"+
			 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
				
			"<p>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </b><br /></b><br />"+
            
            
			"<p><b>Hotel Cancellation Policy </b><br />"+
			 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
				
			"<p>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </b><br />"+
			"<p>You can cancel your booking by sending an email to Connect@OutingDay.com </b><br /><br />"+
			
			"<p><b>General Hotel Policy </b><br />"+
			 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
				
			"<p>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </b><br />"+
			"<p>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </b><br />"+
			"<p>It is mandatory for guests to present valid photo identification at the time of check-in.  </b><br />"+
			"<p>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </b><br />"+
			"<p>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </b><br />"+
			"<p>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </b><br />"+
			"<p>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br />"+
			"<p>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </b><br /><br />"+
			
			
			"<p><b>OutingDay Contact Info </b><br />"+
			 "<b>-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</b> "+
				
			"<p>Anay Web Solutions., "+
			"<p>1-5-95/21 sri Lakshmi nagar colony  "+
			"<p>Old alwal"+
			"<p>Secunderabad, "+
			"<p>Hyderabad, "+
			"<p>500010, "+
			"<p>India "+
			
			"<p>Email	:	connect@outinday.com "+
			"<p>Telephone	:	<Mobile NUmber> </b><br /></b><br />"+

			"<p><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </b><br /></b><br />"+
			
			
            
            "  Thanks,<br />\n" +
            "<br />\n"+
            " Outingday.com<br />\n" +

            "  <br />\n" +

            "</body>\n" +
            "</html>";
String subject = CISConstants.SUBJECT;
 try {
	 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
  
 } catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return cisResult;
}



	public CISResults sendForgotMail(String emailId, int otpNumber) {

		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Outing Day</b><br />"+
                 
				"<p>Your OTP : "+otpNumber+"<br />"+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Outing Day Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	
	
	
	



}


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
			String parkName, String suppCell, String suppEmail, String createDate, String title, Date checkIn, Date checkOut, float price, float totalPrice2, int qty) {
		
		//paymentEmail="udaykatikala@gmail.com";
				
		CISResults cisResult = new CISResults();
	
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style='float:left;'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - <b>"+transactionId +"</b></p><p>Booking Date - "+createDate +"</p></div>"+
                "<div style='float:right;'><img  src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='clear:both;background-color:blue;height:2px;'></div>\n"+
                "<div style='padding-bottom:20px;'><p style='float:left;margin-bottom:10px;'>Dear <b style='color:#000'>"+firstName+"</b></p></div>"+
                "<p style='background-color:#8eafe4;padding:15px;text-align:center;font-weight:bold;font-size:18px;'>&#x2714; &nbsp; Your Booking is confirmed. </p>"+
                "<p style='color:#000'>Thank you for using outingday.com to book your "+parkName+" accommodation.</p>"+
                "<p style='color:#000'>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b></p>"+
                "<p style='color:#000'>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </p>"+
                "<p style='color:#000'>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </p>"+
                "<p style='color:#000'><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b></p>"+
                "<b style='color:#000'>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br />"+
                "<b style='color:#000'>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#e2eff8;color:#333;font-weight:700;line-height:24px;padding:10px 10px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </p>"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				
				"<b style='color:#000'>"+parkName+", "+city+"  </b>"+
				"<p style='color:#000'>"+streetAddress+"</p>"+
				"<p style='color:#000'>"+city+", IN</p><br />"+
				"<p style='color:#000'>Contact : "+suppCell+"</p>"+
				"<p style='color:#000'>Fax : </p>"+
				"<p style='color:#000'>E-mail : "+suppEmail+" </p><br />"+
				
				//"<b style='color:#000'>Park details : "+finalString+"</b>"+
				/*"<p style='color:#000'><b>Primary Guest :</b>"+firstName+"</p>"+
				
				"<b style='color:#000'>Park details : "+finalString+"</b>"+
				"<b style='color:#000'>Total price : "+totalPrice+"</b><br />"+

 
 				"<b style='color:#000'>Primary Guest :"+firstName+"</b><br />"+
 				"<b style='color:#000'>Room Category :"+title+"</b><br />"+*/
 				"<b style='color:#000;'>Primary Guest :</b><p style='color:#000;display:inline;'>&nbsp;"+firstName+"</p><br/><br/>"+
				"<b style='color:#000'>Room Category :</b><p style='color:#000;display:inline;'>&nbsp;"+title+"</p>"+
				"<p style='text-align:right;color:#424242;'>All prices indicated below are in INR</p>"+
				 "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<table style='border-collapse: collapse;width: 100%;' ><tr style='border-bottom: 1px solid #FFD700;padding:10px;'><th style='padding: 8px; text-align:center;'>Room</th><th style='padding: 8px; text-align:center;'>Check In</th><th style='padding: 8px; text-align:center;'>Check Out</th><th style='padding: 8px; text-align:center;'>Reservation Date</th><th style='padding: 8px; text-align:center;'>#Quantity</th><th style='padding: 8px; text-align:center;'>Travelers</th><th style='padding: 8px; text-align:center;'>Daily Rate</th><th style='padding: 8px; text-align:center;'>Extra Charges</th><th>Total</th>"+finalString+"<!--<tr><td colspan='8' style='padding: 8px; text-align:right;'>Accomodation charges collected on behalf of hotel :</td><td style='padding: 8px; text-align:center;'>"+price+"</td></tr><tr> <td colspan='8' style='padding: 8px; text-align:right;''>E-Coupon Amount : </td><td style='padding: 8px; text-align:center;'> - 0</td></tr>--><tr style='background:#fdf7dd;padding:8px;text-align:right;color:#333;font-size:18px;font-weight:bold;'> <td colspan='8' style='text-align:right;'>Grand Total: </td><td style='padding: 8px; text-align:center;'>"+totalPrice+"</td></tr></table> "+// "<table style='border-collapse: collapse;width: 100%;' >"+finalString+"</table>"+
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
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
			String suppEmail, String createDate, String title, Date checkIn, Date checkOut, float price, float totalPrice2, int qty) {
		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style='float:left;'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - <b>"+transactionId +"</b></p><p>Booking Date - "+createDate +"</p></div>"+
                "<div style='float:right;'><img  src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='clear:both;background-color:blue;height:2px;'></div>\n"+
                "<div style='padding-bottom:20px;'><p style='float:left;margin-bottom:10px;'>Dear <b style='color:#000'>"+firstName+"</b></p></div>"+
                "<p style='background-color:#8eafe4;padding:15px;text-align:center;font-weight:bold;font-size:18px;'>&#x2714; &nbsp; Your Booking is confirmed. </p>"+
                "<p style='color:#000'>Thank you for using outingday.com to book your "+parkName+" accommodation.</p>"+
                "<p style='color:#000'>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b></p>"+
                "<p style='color:#000'>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </p>"+
                "<p style='color:#000'>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </p>"+
                "<p style='color:#000'><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b></p>"+
                "<b style='color:#000'>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br />"+
                "<b style='color:#000'>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#e2eff8;color:#333;font-weight:700;line-height:24px;padding:10px 10px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </p>"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				
				"<b style='color:#000'>"+parkName+", "+city+"  </b>"+
				"<p style='color:#000'>"+streetAddress+"</p>"+
				"<p style='color:#000'>"+city+", IN</p><br />"+
				"<p style='color:#000'>Contact : "+suppCell+"</p>"+
				"<p style='color:#000'>Fax : </p>"+
				"<p style='color:#000'>E-mail : "+suppEmail+" </p><br />"+
				
				//"<b style='color:#000'>Park details : "+finalString+"</b>"+
				/*"<p style='color:#000'><b>Primary Guest :</b>"+firstName+"</p>"+
				
				"<b style='color:#000'>Park details : "+finalString+"</b>"+
				"<b style='color:#000'>Total price : "+totalPrice+"</b><br />"+

 
 				"<b style='color:#000'>Primary Guest :"+firstName+"</b><br />"+
 				"<b style='color:#000'>Room Category :"+title+"</b><br />"+*/
 				"<b style='color:#000;'>Primary Guest :</b><p style='color:#000;display:inline;'>&nbsp;"+firstName+"</p><br/><br/>"+
				"<b style='color:#000'>Room Category :</b><p style='color:#000;display:inline;'>&nbsp;"+title+"</p>"+
				"<p style='text-align:right;color:#424242;'>All prices indicated below are in INR</p>"+
				 "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<table style='border-collapse: collapse;width: 100%;' ><tr style='border-bottom: 1px solid #FFD700;padding:10px;'><th style='padding: 8px; text-align:center;'>Room</th><th style='padding: 8px; text-align:center;'>Check In</th><th style='padding: 8px; text-align:center;'>Check Out</th><th style='padding: 8px; text-align:center;'>Reservation Date</th><th style='padding: 8px; text-align:center;'>#Quantity</th><th style='padding: 8px; text-align:center;'>Travelers</th><th style='padding: 8px; text-align:center;'>Daily Rate</th><th style='padding: 8px; text-align:center;'>Extra Charges</th><th>Total</th>"+finalString+"<!--<tr><td colspan='8' style='padding: 8px; text-align:right;'>Accomodation charges collected on behalf of hotel :</td><td style='padding: 8px; text-align:center;'>"+price+"</td></tr><tr> <td colspan='8' style='padding: 8px; text-align:right;''>E-Coupon Amount : </td><td style='padding: 8px; text-align:center;'> - 0</td></tr>--><tr style='background:#fdf7dd;padding:8px;text-align:right;color:#333;font-size:18px;font-weight:bold;'> <td colspan='8' style='text-align:right;'>Grand Total: </td><td style='padding: 8px; text-align:center;'>"+totalPrice+"</td></tr></table> "+// "<table style='border-collapse: collapse;width: 100%;' >"+finalString+"</table>"+
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
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
			String parkName, String suppCell, String createDate, String title, Date checkIn, Date checkOut, float price, float totalPrice2, int qty) {
		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style='float:left;'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - <b>"+transactionId +"</b></p><p>Booking Date - "+createDate +"</p></div>"+
                "<div style='float:right;'><img  src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='clear:both;background-color:blue;height:2px;'></div>\n"+
                "<div style='padding-bottom:20px;'><p style='float:left;margin-bottom:10px;'>Dear <b style='color:#000'>"+firstName+"</b></p></div>"+
                "<p style='background-color:#8eafe4;padding:15px;text-align:center;font-weight:bold;font-size:18px;'>&#x2714; &nbsp; Your Booking is confirmed. </p>"+
                "<p style='color:#000'>Thank you for using outingday.com to book your "+parkName+" accommodation.</p>"+
                "<p style='color:#000'>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b></p>"+
                "<p style='color:#000'>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </p>"+
                "<p style='color:#000'>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </p>"+
                "<p style='color:#000'><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b></p>"+
                "<b style='color:#000'>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br />"+
                "<b style='color:#000'>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#e2eff8;color:#333;font-weight:700;line-height:24px;padding:10px 10px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </p>"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				
				"<b style='color:#000'>"+parkName+", "+city+"  </b>"+
				"<p style='color:#000'>"+streetAddress+"</p>"+
				"<p style='color:#000'>"+city+", IN</p><br />"+
				"<p style='color:#000'>Contact : "+suppCell+"</p>"+
				"<p style='color:#000'>Fax : </p>"+
				"<p style='color:#000'>E-mail : "+suppEmail+" </p><br />"+
				
				//"<b style='color:#000'>Park details : "+finalString+"</b>"+
				/*"<p style='color:#000'><b>Primary Guest :</b>"+firstName+"</p>"+
				
				"<b style='color:#000'>Park details : "+finalString+"</b>"+
				"<b style='color:#000'>Total price : "+totalPrice+"</b><br />"+

 
 				"<b style='color:#000'>Primary Guest :"+firstName+"</b><br />"+
 				"<b style='color:#000'>Room Category :"+title+"</b><br />"+*/
 				"<b style='color:#000;'>Primary Guest :</b><p style='color:#000;display:inline;'>&nbsp;"+firstName+"</p><br/><br/>"+
				"<b style='color:#000'>Room Category :</b><p style='color:#000;display:inline;'>&nbsp;"+title+"</p>"+
				"<p style='text-align:right;color:#424242;'>All prices indicated below are in INR</p>"+
				 "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<table style='border-collapse: collapse;width: 100%;' ><tr style='border-bottom: 1px solid #FFD700;padding:10px;'><th style='padding: 8px; text-align:center;'>Room</th><th style='padding: 8px; text-align:center;'>Check In</th><th style='padding: 8px; text-align:center;'>Check Out</th><th style='padding: 8px; text-align:center;'>Reservation Date</th><th style='padding: 8px; text-align:center;'>#Quantity</th><th style='padding: 8px; text-align:center;'>Travelers</th><th style='padding: 8px; text-align:center;'>Daily Rate</th><th style='padding: 8px; text-align:center;'>Extra Charges</th><th>Total</th>"+finalString+"<!--<tr><td colspan='8' style='padding: 8px; text-align:right;'>Accomodation charges collected on behalf of hotel :</td><td style='padding: 8px; text-align:center;'>"+price+"</td></tr><tr> <td colspan='8' style='padding: 8px; text-align:right;''>E-Coupon Amount : </td><td style='padding: 8px; text-align:center;'> - 0</td></tr>--><tr style='background:#fdf7dd;padding:8px;text-align:right;color:#333;font-size:18px;font-weight:bold;'> <td colspan='8' style='text-align:right;'>Grand Total: </td><td style='padding: 8px; text-align:center;'>"+totalPrice+"</td></tr></table> "+// "<table style='border-collapse: collapse;width: 100%;' >"+finalString+"</table>"+
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
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
			 String suppCell, String suppEmail, String createDate, String title, Date checkIn, Date checkOut, float price, float totalPrice2, int qty) {
		CISResults cisResult = new CISResults();
		
		//paymentEmail="udaykatikala@gmail.com";
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style='float:left;'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - <b>"+transactionId +"</b></p><p>Booking Date - "+createDate +"</p></div>"+
                "<div style='float:right;'><img  src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='clear:both;background-color:blue;height:2px;'></div>\n"+
                "<div style='padding-bottom:20px;'><p style='float:left;margin-bottom:10px;'>Dear <b style='color:#000'>"+firstName+"</b></p></div>"+
                "<p style='background-color:#8eafe4;padding:15px;text-align:center;font-weight:bold;font-size:18px;'>&#x2714; &nbsp; Your Booking is confirmed. </p>"+
                "<p style='color:#000'>Thank you for using outingday.com to book your "+parkName+" accommodation.</p>"+
                "<p style='color:#000'>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b></p>"+
                "<p style='color:#000'>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </p>"+
                "<p style='color:#000'>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </p>"+
                "<p style='color:#000'><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b></p>"+
                "<b style='color:#000'>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br />"+
                "<b style='color:#000'>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#e2eff8;color:#333;font-weight:700;line-height:24px;padding:10px 10px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </p>"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				
				"<b style='color:#000'>"+parkName+", "+city+"  </b>"+
				"<p style='color:#000'>"+streetAddress+"</p>"+
				"<p style='color:#000'>"+city+", IN</p><br />"+
				"<p style='color:#000'>Contact : "+suppCell+"</p>"+
				"<p style='color:#000'>Fax : </p>"+
				"<p style='color:#000'>E-mail : "+suppEmail+" </p><br />"+
				
				//"<b style='color:#000'>Park details : "+finalString+"</b>"+
				/*"<p style='color:#000'><b>Primary Guest :</b>"+firstName+"</p>"+
				
				"<b style='color:#000'>Park details : "+finalString+"</b>"+
				"<b style='color:#000'>Total price : "+totalPrice+"</b><br />"+

 
 				"<b style='color:#000'>Primary Guest :"+firstName+"</b><br />"+
 				"<b style='color:#000'>Room Category :"+title+"</b><br />"+*/
 				"<b style='color:#000;'>Primary Guest :</b><p style='color:#000;display:inline;'>&nbsp;"+firstName+"</p><br/><br/>"+
				"<b style='color:#000'>Room Category :</b><p style='color:#000;display:inline;'>&nbsp;"+title+"</p>"+
				"<p style='text-align:right;color:#424242;'>All prices indicated below are in INR</p>"+
				 "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<table style='border-collapse: collapse;width: 100%;' ><tr style='border-bottom: 1px solid #FFD700;padding:10px;'><th style='padding: 8px; text-align:center;'>Room</th><th style='padding: 8px; text-align:center;'>Check In</th><th style='padding: 8px; text-align:center;'>Check Out</th><th style='padding: 8px; text-align:center;'>Reservation Date</th><th style='padding: 8px; text-align:center;'>#Quantity</th><th style='padding: 8px; text-align:center;'>Travelers</th><th style='padding: 8px; text-align:center;'>Daily Rate</th><th style='padding: 8px; text-align:center;'>Extra Charges</th><th>Total</th>"+finalString+"<!--<tr><td colspan='8' style='padding: 8px; text-align:right;'>Accomodation charges collected on behalf of hotel :</td><td style='padding: 8px; text-align:center;'>"+price+"</td></tr><tr> <td colspan='8' style='padding: 8px; text-align:right;''>E-Coupon Amount : </td><td style='padding: 8px; text-align:center;'> - 0</td></tr>--><tr style='background:#fdf7dd;padding:8px;text-align:right;color:#333;font-size:18px;font-weight:bold;'> <td colspan='8' style='text-align:right;'>Grand Total: </td><td style='padding: 8px; text-align:center;'>"+totalPrice+"</td></tr></table> "+// "<table style='border-collapse: collapse;width: 100%;' >"+finalString+"</table>"+
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
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
			String suppEmail, String createDate, String title, Date checkIn, Date checkOut, float price, float totalPrice2, int qty) {

		CISResults cisResult = new CISResults();
		String emailId=CISConstants.ADMINEMAILID;
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style='float:left;'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - <b>"+transactionId +"</b></p><p>Booking Date - "+createDate +"</p></div>"+
                "<div style='float:right;'><img  src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='clear:both;background-color:blue;height:2px;'></div>\n"+
                "<div style='padding-bottom:20px;'><p style='float:left;margin-bottom:10px;'>Dear <b style='color:#000'>"+firstName+"</b></p></div>"+
                "<p style='background-color:#8eafe4;padding:15px;text-align:center;font-weight:bold;font-size:18px;'>&#x2714; &nbsp; Your Booking is confirmed. </p>"+
                "<p style='color:#000'>Thank you for using outingday.com to book your "+parkName+" accommodation.</p>"+
                "<p style='color:#000'>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b></p>"+
                "<p style='color:#000'>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </p>"+
                "<p style='color:#000'>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </p>"+
                "<p style='color:#000'><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b></p>"+
                "<b style='color:#000'>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br />"+
                "<b style='color:#000'>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#e2eff8;color:#333;font-weight:700;line-height:24px;padding:10px 10px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </p>"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				
				"<b style='color:#000'>"+parkName+", "+city+"  </b>"+
				"<p style='color:#000'>"+streetAddress+"</p>"+
				"<p style='color:#000'>"+city+", IN</p><br />"+
				"<p style='color:#000'>Contact : "+suppCell+"</p>"+
				"<p style='color:#000'>Fax : </p>"+
				"<p style='color:#000'>E-mail : "+suppEmail+" </p><br />"+
				
				//"<b style='color:#000'>Park details : "+finalString+"</b>"+
				/*"<p style='color:#000'><b>Primary Guest :</b>"+firstName+"</p>"+
				
				"<b style='color:#000'>Park details : "+finalString+"</b>"+
				"<b style='color:#000'>Total price : "+totalPrice+"</b><br />"+

 
 				"<b style='color:#000'>Primary Guest :"+firstName+"</b><br />"+
 				"<b style='color:#000'>Room Category :"+title+"</b><br />"+*/
 				"<b style='color:#000;'>Primary Guest :</b><p style='color:#000;display:inline;'>&nbsp;"+firstName+"</p><br/><br/>"+
				"<b style='color:#000'>Room Category :</b><p style='color:#000;display:inline;'>&nbsp;"+title+"</p>"+
				"<p style='text-align:right;color:#424242;'>All prices indicated below are in INR</p>"+
				 "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<table style='border-collapse: collapse;width: 100%;' ><tr style='border-bottom: 1px solid #FFD700;padding:10px;'><th style='padding: 8px; text-align:center;'>Room</th><th style='padding: 8px; text-align:center;'>Check In</th><th style='padding: 8px; text-align:center;'>Check Out</th><th style='padding: 8px; text-align:center;'>Reservation Date</th><th style='padding: 8px; text-align:center;'>#Quantity</th><th style='padding: 8px; text-align:center;'>Travelers</th><th style='padding: 8px; text-align:center;'>Daily Rate</th><th style='padding: 8px; text-align:center;'>Extra Charges</th><th>Total</th>"+finalString+"<!--<tr><td colspan='8' style='padding: 8px; text-align:right;'>Accomodation charges collected on behalf of hotel :</td><td style='padding: 8px; text-align:center;'>"+price+"</td></tr><tr> <td colspan='8' style='padding: 8px; text-align:right;''>E-Coupon Amount : </td><td style='padding: 8px; text-align:center;'> - 0</td></tr>--><tr style='background:#fdf7dd;padding:8px;text-align:right;color:#333;font-size:18px;font-weight:bold;'> <td colspan='8' style='text-align:right;'>Grand Total: </td><td style='padding: 8px; text-align:center;'>"+totalPrice+"</td></tr></table> "+// "<table style='border-collapse: collapse;width: 100%;' >"+finalString+"</table>"+
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
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
			String parkName, String suppCell, String createDate, String title, Date checkIn, Date checkOut, float price, float totalPrice2, int qty) {


		CISResults cisResult = new CISResults();
	
    	
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<div style='float:left;'><h2>Hotel/Resort Confirmation</h2><b>Voucher</b><p>Outing Day Booking ID - <b>"+transactionId +"</b></p><p>Booking Date - "+createDate +"</p></div>"+
                "<div style='float:right;'><img  src='http://od.castusinfo.com/assets/images/outingday_strip.jpg' width='180' alt='outingday'></div>"+
                "<div  style='clear:both;background-color:blue;height:2px;'></div>\n"+
                "<div style='padding-bottom:20px;'><p style='float:left;margin-bottom:10px;'>Dear <b style='color:#000'>"+firstName+"</b></p></div>"+
                "<p style='background-color:#8eafe4;padding:15px;text-align:center;font-weight:bold;font-size:18px;'>&#x2714; &nbsp; Your Booking is confirmed. </p>"+
                "<p style='color:#000'>Thank you for using outingday.com to book your "+parkName+" accommodation.</p>"+
                "<p style='color:#000'>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b></p>"+
                "<p style='color:#000'>Kindly note, your booking is <b> CONFIRMED</b> and you are not required to contact the hotel or  OutingDay.com to reconfirm the same. </p>"+
                "<p style='color:#000'>You will need to carry a printout of this e-mail and present it at the hotel at the time of check-in. </p>"+
                "<p style='color:#000'><b>Please note that you will receive the invoice for your booking on the day of checkout on the email ID using which the booking will be made. In case of no-show, no invoice will be generated. </b></p>"+
                "<b style='color:#000'>We hope you have a pleasant stay and look forward to assisting you again! </b><br /><br />"+
                "<b style='color:#000'>Team OutingDay.com</b><br /> "+
				"<p style='text-align:center;background-color:#e2eff8;color:#333;font-weight:700;line-height:24px;padding:10px 10px;'>THIS IS YOUR HOTEL CONFIRMATION VOUCHER.A PRINTED COPY OF THIS MUST BE PRESENTED AT THE HOTEL AT THE TIME OF CHECK-IN. </p>"+
               
 				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Details </p>"+
 			    "<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				
				"<b style='color:#000'>"+parkName+", "+city+"  </b>"+
				"<p style='color:#000'>"+streetAddress+"</p>"+
				"<p style='color:#000'>"+city+", IN</p><br />"+
				"<p style='color:#000'>Contact : "+suppCell+"</p>"+
				"<p style='color:#000'>Fax : </p>"+
				"<p style='color:#000'>E-mail : "+suppEmail+" </p><br />"+
				
				//"<b style='color:#000'>Park details : "+finalString+"</b>"+
				/*"<p style='color:#000'><b>Primary Guest :</b>"+firstName+"</p>"+
				
				"<b style='color:#000'>Park details : "+finalString+"</b>"+
				"<b style='color:#000'>Total price : "+totalPrice+"</b><br />"+

 
 				"<b style='color:#000'>Primary Guest :"+firstName+"</b><br />"+
 				"<b style='color:#000'>Room Category :"+title+"</b><br />"+*/
 				"<b style='color:#000;'>Primary Guest :</b><p style='color:#000;display:inline;'>&nbsp;"+firstName+"</p><br/><br/>"+
				"<b style='color:#000'>Room Category :</b><p style='color:#000;display:inline;'>&nbsp;"+title+"</p>"+
				"<p style='text-align:right;color:#424242;'>All prices indicated below are in INR</p>"+
				 "<div  style='background-color:#2c3091;height:2px;'></div>\n"+
				
				"<table style='border-collapse: collapse;width: 100%;' ><tr style='border-bottom: 1px solid #FFD700;padding:10px;'><th style='padding: 8px; text-align:center;'>Room</th><th style='padding: 8px; text-align:center;'>Check In</th><th style='padding: 8px; text-align:center;'>Check Out</th><th style='padding: 8px; text-align:center;'>Reservation Date</th><th style='padding: 8px; text-align:center;'>#Quantity</th><th style='padding: 8px; text-align:center;'>Travelers</th><th style='padding: 8px; text-align:center;'>Daily Rate</th><th style='padding: 8px; text-align:center;'>Extra Charges</th><th>Total</th>"+finalString+"<!--<tr><td colspan='8' style='padding: 8px; text-align:right;'>Accomodation charges collected on behalf of hotel :</td><td style='padding: 8px; text-align:center;'>"+price+"</td></tr><tr> <td colspan='8' style='padding: 8px; text-align:right;''>E-Coupon Amount : </td><td style='padding: 8px; text-align:center;'> - 0</td></tr>--><tr style='background:#fdf7dd;padding:8px;text-align:right;color:#333;font-size:18px;font-weight:bold;'> <td colspan='8' style='text-align:right;'>Grand Total: </td><td style='padding: 8px; text-align:center;'>"+totalPrice+"</td></tr></table> "+// "<table style='border-collapse: collapse;width: 100%;' >"+finalString+"</table>"+
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
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
				"<table align='center' style='border:1px solid #ccc;width:760px;'><tr><td>"+
				"<table align='center'><tr><td><a href='#'><img src='http://od.castusinfo.com/assets/images/email_banner.jpg' width='100%' ></a></td></tr></table>"+
				"<table ><tr><td style='color:#000;padding:10px 0px;'>Dear <b>"+firstName+"</b>,<p>Welcome to OutingDay!</p><p>Just like you, millions of happy travellers have started their journeys right here on OutingDay. Whatever your idea of travel, you’ll find OutingDay is the right choice.</p><a href='#'><img src='http://od.castusinfo.com/assets/images/outingday_email.png'></a></td></tr><tr><td  style='color:#000;padding:10px 0px;'>We are delighted to have you onboard.<a href='#'> Click here</a> to explore now.</td></tr></table>"+
				"<table ><tr><td style='color:#000;padding: 24px 22px 24px 0px;'><a href='#'><img src='http://od.castusinfo.com/assets/images//explore.gif'></a></td><td style='color:#000; padding: 24px 22px 24px 0px;'><b>EXPLORE</b><p style='color:#000'>Explore all outing choices and get ready to experience your city like never before </p></td></tr><tr><td style='color:#000;padding:10px 0px;'><a href='#'><img src='http://od.castusinfo.com/assets/images//purchase.gif'></a></td><td style='color:#000;padding: 24px 22px 24px 0px;'><b>PURCHASE</b><p style='color:#000'>Choose and buy the best from our extensive outings</p></td></tr><tr><td style='color:#000;padding:10px 0px;'><a href='#'><img src='http://od.castusinfo.com/assets/images//savemoney.gif'></a></td><td style='color:#000; padding: 24px 22px 24px 0px;'><b>SAVE MONEY</b><p style='color:#000'>With discounts and special offers save big and have great experiences</p></td></tr></table>"+
				"<table><tr ><td style='padding:20px 0px;'><b>Best regards</b>,<br/>OutingDay <br/></td></tr></table>"+
				"<table style='background:#ededed;color:rgb(139,139,139);padding:15px 0px;width:100%;' ><tr><td><a href='#'><img src='http://od.castusinfo.com/assets/images/mail.png' alt='email' width='32' style='margin: -10px 10px !important;'></a><span>connect@outingday.com</span></td><td><a href='https://www.facebook.com/outingday/'><img src='http://od.castusinfo.com/assets/images/fb.png' width='32' style='padding: 5px;'></a><a href='#'><img src='http://od.castusinfo.com/assets/images/twitter.png' width='32' style='padding: 5px;'></a><a href='#'><img src='http://od.castusinfo.com/assets/images/youtube.png' width='32' style='padding: 5px;'></a><a href='#'><img src='http://od.castusinfo.com/assets/images/blog.png' width='32' style='padding: 5px;'></a></td></tr></table>"+
				"<table><tr><td><a href='#'>Click here</a> to view our contact details</td><td style='padding:10px 0px;'>Read our <a href='#'>Privacy Policy</a>, <a href='#'>Unsubscribe </a></td></tr></table>"+
				"</td></tr></table>"+
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
            "<p>Thank you for using outingday.com to book your "+parkName+"  accommodation.</b><br />"+
            "<p>For your reference, your OutingDay Booking ID is :<b>"+transactionId +"</b><br />"+
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



	public CISResults sendUpdatedPasswordMail(String userName) {

		CISResults cisResult = new CISResults();
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                /*"<p>Dear "+userName+"</b><br />"+*/
                
                "<p><b>Your password updated successfully.</b> "+
                 
 				
 			
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Inclusions </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>Service Fee of INR 250 will be applicable for any change in Hotel Check-In dates.Any rate difference found will be charged separately. </p>"+
                
                
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>Hotel Cancellation Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>NON-REFUNDABLE rate: 100% of the total cost will be charged in case of cancellation </p>"+
				"<p style='color:#000'>You can cancel your booking by sending an email to Connect@OutingDay.com </p>"+
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>General Hotel Policy </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div>"+
				
				"<p style='color:#000'>If your booking involves a night stay Complementary Breakfast will  be applicable as per hotel policy. </p>"+
				"<p style='color:#000'>The primary guest checking in to the hotel must be at least 18 years of age. Children accompanying adults must be between 1-12 years. </p>"+
				"<p style='color:#000'>It is mandatory for guests to present valid photo identification at the time of check-in.  </p>"+
				"<p style='color:#000'>The inclusion of 'extra bed' with a booking is facilitated with a folding cot or a mattress as an extra bed. </p>"+
				"<p style='color:#000'>Early check-in or late check-out is subject to availability and may be chargeable by the hotel. The standard check-in time is 2PM local time and the standard check-out time is 12PM local time. After booking you will be sent an email confirmation with hotel phone number. You can contact the hotel directly for early check-in or late check-out. </p>"+
				"<p style='color:#000'>The room tariff includes all taxes unless specifically mentioned. The amount paid for the room does not include charges for optional services and facilities (such as room service, mini bar, snacks or telephone calls). These will be charged at the time of check-out. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission. Accommodation can be denied to guests posing as a 'couple' if suitable proof of identification is not presented at check-in. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				"<p style='color:#000'>The hotel reserves the right of admission for local residents. Accommodation can be denied to guests residing in the same city. OutingDay will not be responsible for any check-in denied by the hotel due to the aforesaid reason. </p>"+
				
				
				"<p style='font-size:16px;font-weight:bold;color:#2c3091;'>OutingDay Contact Info </p>"+
				"<div  style='background-color:#2c3091;height:2px;'></div><br/>"+
				"<table><tr><td style='text-align:left;width: 300px !important;'><b>Anay Web Solutions.,</b><br>sri Lakshmi nagar colony,<br>Old alwal<br>Secunderabad,<br>Hyderabad - 500010,<br>India, <br></td><td style='text-align:right;float:right;'>Email:connect@outinday.com <br>Telephone:<Mobile NUmber><br /></td></tr></table>"+

				"<p style='clear:both;color:#000'><b>Note:</b> Please do not reply to this email. It has been sent from an email account that is not monitored. To ensure that you receive communication related to your booking from outingday.com, please add connect@outingday.com to your contact list and address book. </p><br />"+
				"</body>\n" +
                "</html>";

				String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,userName, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}


	
	
	
	



}


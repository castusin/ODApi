package com.cis;

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
	
	public CISResults sendStaffMail(String staffEmail) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Arcturus Care </b><br />"+
                 
  				"<p>Your schedule has been created. "+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,staffEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}
	
	
	public CISResults sendPatientMail(String patientEmail) {
		// TODO Auto-generated method stub
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Arcturus Care </b><br />"+
                 
  				"<p>Your schedule has been created. "+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,patientEmail, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}
	
	
	public CISResults sendAdminMail() {
		// TODO Auto-generated method stub
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
                 "<p>Arcturus Care </b><br />"+
                 
                "<p>Your schedule has been created. "+
                 
                "<br />\n"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

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

	public CISResults sendPaymentstatus(String paymentEmail, String firstName, String roomType, Date checkIn, Date checkOut, int qty, float price) {
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
                 "<p>Hello "+firstName+"</b><br />"+
                 
                "<p>Your payment is successful. "+
                 
                
  				"<p>RoomType : "+roomType+"</b><br />"+
  				"<p>CheckIn Date :"+checkIn+"</b><br />"+
				"<p>CheckOut Date :"+checkOut+"</b><br />"+
				"<p>Quantity :"+qty+"</b><br />"+
				"<p>Price : "+price+"</b><br />"+
                
                "<br />\n"+
                "<br />\n"+
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

	public CISResults sendFacilityMail(String facilityCode, float rate, String email, String room, float roomPrice) {
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
                 
 				"<p>Room Type "+room+"</b><br />"+
 				"<p>Room Price "+roomPrice+"</b><br />"+
 				"<p>Extra Facilities "+facilityCode+"</b><br />"+
 				"<p> Facilities Price"+rate+"</b><br />"+
 				
                
                 
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
		 String result = sendMailWithAuth(CISConstants.EMAILHOST,CISConstants.EMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,email, msg, subject);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}
}


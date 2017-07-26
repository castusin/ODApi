package com.od;

/**
 * User Login Service
 * 
 * @author Castus Info Solutions
 *
 */
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.cis.CISResults;


public class LoginWebservice {

	static Logger logger = Logger.getLogger(LoginWebservice.class);
	LoginBL loginPBL=new LoginBL();

	public CISResults login(String username,String password) throws Throwable {
		 CISResults cisResult = loginPBL.login(username,password);
		 logger.info(" DigitalHealthCare:loginWS :"+cisResult);
		return cisResult;
	}
}
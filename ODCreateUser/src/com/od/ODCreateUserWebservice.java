package com.od;


import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODCreateUserWebservice {
	
	static Logger logger = Logger.getLogger(ODCreateUserWebservice.class);
	ODCreateUserBL createUserBL=new ODCreateUserBL();

	/**
	 * @param create user
	 * @return 1 in case of error or 0 if successful
	 * @throws Throwable 
	 */
	public CISResults createUser(ODCreateUserModel createUser) throws Throwable {
		
		 CISResults cisResults = createUserBL.createUser(createUser);	
		 logger.info("create user Webservice " +cisResults );
		 return cisResults;
	}

}

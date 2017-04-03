package com.od;



import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODSaveParkInfoWebservice {
	static Logger logger = Logger.getLogger(ODSaveParkInfoWebservice.class);
	ODSaveParkInfoBL saveParkInfoBL=new ODSaveParkInfoBL();

	public CISResults saveParkInfo(ODGetParkInfoModel saveParkInfo) {
		 CISResults cisResult = saveParkInfoBL.saveParkInfo(saveParkInfo);	
		 logger.info("Digital HealthCare Webservice " +cisResult );
		 return cisResult;
	}

}

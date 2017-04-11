package com.od;



import org.apache.log4j.Logger;

import com.cis.CISResults;


public class ODSaveParkInfoWebservice {
	static Logger logger = Logger.getLogger(ODSaveParkInfoWebservice.class);
	ODSaveParkInfoBL saveParkInfoBL=new ODSaveParkInfoBL();

	public CISResults saveParkInfo(ODSaveParkInfoModel saveParkInfo) {
		 CISResults CISResults = saveParkInfoBL.saveParkInfo(saveParkInfo);	
		 logger.info("save parkInfo Webservice " +CISResults );
		 return CISResults;
	}

}

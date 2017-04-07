package com.od;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

public class ODSaveParkInfoDAO extends JdbcDaoSupport {

	public CISResults saveParkInfo(String appId, String parktype,
			String parkSubtype, String metro, String localArea,
			String streetAddress, String city, String state, String pin,
			String name, String description, String details,int parkId, int odRating,
			int sponsoredFeaturedFlag,  String overviewText, String faq,
			String latitude, String longitude, String typeString,
			String natureString, String subCategoryString,
			String durationString, String maxPeople, String ODDate,
			String popularity, Float minCost1, Float minCost1People,
			Float minCost2, Float minCost2People, Float minCost3,
			Float minCost3People, Float specialOfferPercentage,
			Float specialRate, String photoUrl) {
		
		ODGetParkInfoModel parksInfo=new ODGetParkInfoModel();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSINFO,appId,parktype,parkSubtype,metro,localArea, streetAddress,  city,  state,  pin,
					 name,  description,  details, parkId, odRating,
					 sponsoredFeaturedFlag,  overviewText,  faq,
					 latitude,  longitude,  typeString,
					 natureString,  subCategoryString,
					 durationString,  maxPeople,  ODDate,
					 popularity,  minCost1,  minCost1People,
					 minCost2,  minCost2People,  minCost3,
					 minCost3People,  specialOfferPercentage,
					 specialRate,  photoUrl);
			//cisResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}

   		return cisResults;  
	}

	

}





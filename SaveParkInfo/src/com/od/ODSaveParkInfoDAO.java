package com.od;

import java.sql.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

public class ODSaveParkInfoDAO extends JdbcDaoSupport {

	public CISResults saveParkInfo(String appId, String parktype,
			String parkSubcategory, String metro, String localArea,
			String streetAddress, String city, String state, String pin,
			String name, String description, String details,int parkId, int odRating,
			int sponsoredFeaturedFlag,  String overviewText, String faq,
			String latitude, String longitude, String typeString,
			String natureString, String subCategoryString,
			String durationString, String maxPeople, String ODDate,
			String popularity, Float minCost1, Float minCost1People,
			Float minCost2, Float minCost2People, Float minCost3,
			Float minCost3People, Float specialOfferPercentage,
			Float specialRate, String photoUrl, String imagefoldername) {
		
		ODSaveParkInfoModel parksInfo=new ODSaveParkInfoModel();
		CISResults CISResults=new CISResults();
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		try{
			getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSINFO,appId,parktype,parkSubcategory,metro,localArea, streetAddress,  city,  state,  pin,
					 name,  description,  details, parkId, odRating,
					 sponsoredFeaturedFlag,  overviewText,  faq,
					 latitude,  longitude,  typeString,
					 natureString,  subCategoryString,
					 durationString,  maxPeople,  ODDate,
					 popularity,  minCost1,  minCost1People,
					 minCost2,  minCost2People,  minCost3,
					 minCost3People,  specialOfferPercentage,
					 specialRate,  photoUrl,imagefoldername);
			//CISResults.setResultObject(result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			CISResults.setErrorMessage("Failed At DataAccess");
		}

   		return CISResults;  
	}


	/*public List<ODParkRoomsModel> saveParkRooms(int parkId,
			String roomTypeCode, String rommTypeDescription, String maxPeople,
			String maxAdults, String maxKids, String maxQty,
			String regularPrice, String oDDate) {
		CISResults CISResults=new CISResults();
		 List<ODParkRoomsModel> parkRooms = null;
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate};
		try{
			 getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSROOMS,parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			CISResults.setErrorMessage("Failed At DataAccess");
		}

  		return parkRooms;  
	}*/


	public List<ODParkFacilitiesModel> saveParkFacilities(int parkId,
			String facilityTypeCode, String facilityTypeDescription,
			String ticketType, int maxQty, int currentAvailableQty, Float price) {
		CISResults CISResults=new CISResults();
		 List<ODParkFacilitiesModel> parkFacilities=null;
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate};
		try{
			 getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSFACILITIES,parkId,facilityTypeCode,facilityTypeDescription,ticketType,maxQty,currentAvailableQty,price);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			CISResults.setErrorMessage("Failed At DataAccess");
		}

 		return parkFacilities;  
	}


	public List<ODParkPricingModel> saveParkFacilities(int parkId,
			String roomTypeCode, Date fromDate, Date toDate, float currentPrice) {
		CISResults CISResults=new CISResults();
		 List<ODParkPricingModel> parkPricing=null;
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		//Object[] inputs = new Object[]{parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate};
		try{
			 getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSPRICING,parkId,roomTypeCode,fromDate,toDate,currentPrice);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			CISResults.setErrorMessage("Failed At DataAccess");
		}

		return parkPricing;  
	}


	public List<ODParkRoomsModel> saveParkRooms(int parkId,
			List<ODParkRoomsModel> parkRooms) {
		CISResults CISResults=new CISResults();
		 List<ODParkRoomsModel> parkRoom = null;
		CISResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		//Object[] inputs = new Object[]{parkId,roomTypeCode,rommTypeDescription,maxPeople,maxAdults,maxKids,maxQty,regularPrice,oDDate};
		try{
			 getJdbcTemplate().update(ODSaveParkInfoQuery.SQL_SAVEPARKSROOMS,parkId);
	
			} catch (DataAccessException e) {
			e.printStackTrace();
		
			CISResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			CISResults.setErrorMessage("Failed At DataAccess");
		}

 		return parkRoom;  
	}

}





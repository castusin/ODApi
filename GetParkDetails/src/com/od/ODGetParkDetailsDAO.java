
package com.od;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

import com.cis.CISConstants;
import com.cis.CISResults;


public class ODGetParkDetailsDAO extends JdbcDaoSupport {


	public CISResults getParksDetails(String parkId) {
		
		ODGetParkDetailsModel parksDetails=new ODGetParkDetailsModel();
		ODParkDetailsService parkDetailslist = new ODParkDetailsService();
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{parkId};
		
		try{
			List res =getJdbcTemplate().query(ODGetParkDetailsQuery.SQL_GETPARKSDETAILS,inputs,new ODGetParkDetailsMapper());
	
			cisResults.setResultObject(res);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed At DataAccess");
		}
		return cisResults;  
	}
		
		public List<ODParkDetailsService>  getParksListDetails(String parkId) {
			
			ODGetParkDetailsModel parksDetails=new ODGetParkDetailsModel();
			List<ODParkDetailsService> parkDetailslist = null;
			CISResults cisResults=new CISResults();
			cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
			Object[] inputs = new Object[]{parkId};
			try{
				parkDetailslist= getJdbcTemplate().query(ODGetParkDetailsQuery.SQL_GETPARKSDETAILSLIST,inputs,new ODParkDetailsServiceMapper());
		
				
			} catch (DataAccessException e) {
				e.printStackTrace();
			
				cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
				cisResults.setErrorMessage("Failed At DataAccess");
			}

	   		return parkDetailslist;  
		}

}




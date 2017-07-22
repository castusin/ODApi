package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
/**
 * Mapper class for Session
 * 
 * @author Castus Info Solutions
 *
 */
@SuppressWarnings("rawtypes")
public class SessionsMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sessions digiSession = new Sessions();	
		digiSession.setUserId(rs.getString("User_id"));
		digiSession.setSessionId(rs.getString("Session_id"));
		digiSession.setTimeStamp(rs.getString("Time_stamp"));
		digiSession.setDeleteInd(rs.getString("Delete_ind"));
		return digiSession;
	}

}

package com.od;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


@SuppressWarnings("rawtypes")
public class ODParkRegistrationMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ODParkRegistrationModel login = new ODParkRegistrationModel();	
		
		

		//login.setPhoneNumber(rs.getString("phone_number"));
		//login.setEmailId(rs.getString("username"));
		login.setPhoneNumber(rs.getString("phone_number"));
		login.setUsername(rs.getString("username"));
		login.setUserId(rs.getString("userid"));
		
		login.setFirstName(rs.getString("first_name"));
		login.setLastName(rs.getString("last_name"));
		login.setUserType(rs.getString("user_type"));
		login.setGoogleFbId(rs.getString("google_fb_id"));
		login.setProfilePicUrl(rs.getString("profile_pic_url"));
		login.setUserGender(rs.getString("user_gender"));
		login.setUserRole(rs.getString("user_role"));
		login.setCreationDate(rs.getString("creation_date"));
		login.setCreatedBy(rs.getString("created_by"));
		login.setUpdatedBy(rs.getString("updated_by"));
		login.setUpdationDate(rs.getString("updation_date"));
		login.setPasswordLastChangedOn(rs.getString("password_last_changed_on"));
		login.setLastLoginDatetime(rs.getString("last_login_datetime"));
		
		return login;
	}

}
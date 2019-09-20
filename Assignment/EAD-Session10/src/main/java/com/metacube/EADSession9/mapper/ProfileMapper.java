package com.metacube.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADSession9.mode.commands.ProfileCommands;


public class ProfileMapper implements RowMapper<ProfileCommands> {

	@Override
	public ProfileCommands mapRow(ResultSet resultSet, int i) throws SQLException {
		
		ProfileCommands profile = new ProfileCommands();
		
		profile.setName(resultSet.getString("name"));
		profile.setEmail(resultSet.getString("email"));
		profile.setPhoneNumber(resultSet.getString("phoneNumber"));
		profile.setVehicleNumber(resultSet.getString("vehicleNumber"));
		profile.setOrganization(resultSet.getString("organization"));
		
		return profile;
	}

}

package com.metacube.EADSession9.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.EADSession9.mode.commands.EmployeeCommands;


public class EmployeeMapper implements RowMapper<EmployeeCommands>{
	
	@Override
	public EmployeeCommands mapRow(ResultSet resultSet, int i ) throws SQLException{
		
		System.out.println("hello ");
		
		if(resultSet==null)
			return null;
		
		
		EmployeeCommands emp = new EmployeeCommands();
		
		emp.setEmpId(resultSet.getInt("empId"));
		emp.setName(resultSet.getString("name"));
		emp.setEmail(resultSet.getString("email"));
		emp.setGender(resultSet.getString("gender"));
		emp.setPhoneNumber(resultSet.getString("phoneNumber"));
		emp.setOrganization(resultSet.getString("organization"));
		
		return emp;
	}
	
}

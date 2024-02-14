package com.bascode.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserModel(
				rs.getLong("user_id"),
				rs.getString("user_name"),
				rs.getString("user_email")
				);
	}

}

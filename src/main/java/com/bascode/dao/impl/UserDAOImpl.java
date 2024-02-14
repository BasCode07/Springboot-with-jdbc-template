package com.bascode.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bascode.dao.UserDAO;
import com.bascode.model.UserMapper;
import com.bascode.model.UserModel;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(UserModel userModel) {
		String SAVE_USER_SQL = """
				INSERT INTO jdbc_tbl(user_name,user_email) VALUES(?,?)""";
		
	  return jdbcTemplate.update(SAVE_USER_SQL,
			  userModel.getUserName(),userModel.getUserEmail());
	}

	@Override
	public List<UserModel> findAll() {
		String FIND_ALL_USER = """
				SELECT user_id, user_name, user_email
				FROM jdbc_tbl
				LIMIT 100
				""";
		return jdbcTemplate.query(FIND_ALL_USER, new UserMapper());
	}

	@Override
	public Optional<UserModel> findById(long id) {
		String FIND_ONE_USER = """
				SELECT user_id,user_name,user_email
				FROM jdbc_tbl WHERE user_id=?
				""";
		return jdbcTemplate.query(FIND_ONE_USER, new UserMapper(),id)
				.stream()
				.findFirst();
	}

	@Override
	public int updateUser(UserModel userModel, long id) {
		String UPDATE_ONE = """
				UPDATE jdbc_tbl SET user_name=?, user_email=?
				WHERE user_id=?
				""";
		return jdbcTemplate.update(UPDATE_ONE, 
				userModel.getUserName(), userModel.getUserEmail(), id
				);
	}

	@Override
	public int deleteUser(long id) {
		String DELETE_ONE = """
				DELETE FROM jdbc_tbl WHERE user_id=?
				""";
		return jdbcTemplate.update(DELETE_ONE,id);
	}

}

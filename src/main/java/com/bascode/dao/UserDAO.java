package com.bascode.dao;

import java.util.List;
import java.util.Optional;

import com.bascode.model.UserModel;

public interface UserDAO {
	
	int save(UserModel userModel);
	List<UserModel> findAll(); 
	Optional<UserModel> findById(long id);
	int updateUser(UserModel userModel, long id);
	int deleteUser(long id);

}

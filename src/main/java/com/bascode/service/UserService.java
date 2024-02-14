package com.bascode.service;

import java.util.List;
import java.util.Optional;

import com.bascode.model.UserModel;

public interface UserService {
	
	int create(UserModel userModel);
	List<UserModel> findAllUser();
	Optional<UserModel> findOneUser(long id);
	String updateOneUser(UserModel userModel, long id);
	String deleteOneUser(long id);

}

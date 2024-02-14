package com.bascode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bascode.dao.impl.UserDAOImpl;
import com.bascode.model.UserModel;
import com.bascode.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAOImpl userDAOImpl;

	@Override
	public int create(UserModel userModel) {
	 return	userDAOImpl.save(userModel);
	
	}

	@Override
	public List<UserModel> findAllUser() {
	  return userDAOImpl.findAll();
	  }

	@Override
	public Optional<UserModel> findOneUser(long id) {
	   UserModel checkUser = userDAOImpl.findById(id)
	    	.stream()
	    	.findFirst()
	    	.orElseThrow(() -> new RuntimeException("No user found"));
	   return Optional.of(checkUser);
		
	}

	@Override
	public String updateOneUser(UserModel userModel, long id) {
	 UserModel existingUser =	userDAOImpl.findById(id)
		.orElseThrow(() -> new RuntimeException("No user available with id "+id));
	    existingUser.setUserName(userModel.getUserName());
	    existingUser.setUserEmail(userModel.getUserEmail());
	    userDAOImpl.updateUser(userModel, id);
		return "User with id "+id+" updeted successfully";
	}

	@Override
	public String deleteOneUser(long id) {
		
				userDAOImpl.findById(id)
		.orElseThrow(()-> new RuntimeException("No user found"));
		userDAOImpl.deleteUser(id);
		return "user with id "+id+" deleted successfully";
	}
	
	

}

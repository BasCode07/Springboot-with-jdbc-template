package com.bascode.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bascode.model.UserModel;
import com.bascode.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public int createUser(@RequestBody UserModel userModel){
	  return userServiceImpl.create(userModel);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserModel>> getAllUser(){
		return ResponseEntity.ok(userServiceImpl.findAllUser());
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<UserModel>> findById(@PathVariable("id") long id){
		return ResponseEntity.ok(userServiceImpl.findOneUser(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUser(@RequestBody UserModel userModel,
			@PathVariable("id") long id){
		return ResponseEntity.ok(userServiceImpl.updateOneUser(userModel, id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		return ResponseEntity.ok(userServiceImpl.deleteOneUser(id));
	}
	
	
	
}

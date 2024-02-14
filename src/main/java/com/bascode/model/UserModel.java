package com.bascode.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserModel {
	@JsonProperty("userId")
	private long userId;
	
	@JsonProperty("userName")
	private String userName;
	
	
	@JsonProperty("userEmail")
	private String userEmail;


}

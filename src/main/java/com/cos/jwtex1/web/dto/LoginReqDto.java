package com.cos.jwtex1.web.dto;

import com.cos.jwtex1.domain.User;

import lombok.Data;

@Data
public class LoginReqDto {
	private String username;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.role("USER")
				.build();
	}
}

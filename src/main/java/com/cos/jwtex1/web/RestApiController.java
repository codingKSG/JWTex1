package com.cos.jwtex1.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.jwtex1.domain.User;
import com.cos.jwtex1.domain.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestApiController {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	@GetMapping({"/",""})
	public String home() {
		return "<h1>Home</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>user</h1>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>admin</h1>";
	}
	
	@PostMapping("/join")
	public User join(@RequestBody User user) {
		String rowPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rowPassword);
		
		user.setRole("USER");
		user.setPassword(encPassword);
		return userRepository.save(user);
		
	}
	
}

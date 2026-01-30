package com.resort.solution.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.resort.solution.entity.Admin;
import com.resort.solution.entity.User;
import com.resort.solution.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.registerUser(user);
	}
	
	@GetMapping("/getById")
	public User getUserByIds(@RequestParam Integer userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String email , @RequestParam String password){
		return userService.loginUser(email, password);
	}
	
	@PostMapping("/update")
	public User register(@RequestParam Integer userId ,@RequestBody User user) {
		return userService.updateUserProfile(userId, user);
	}
	
	@PutMapping("/offState")
	public ResponseEntity<?> offStateUser(@RequestParam Integer userId) {
		boolean changed = userService.deactivateUser(userId);
		if(!changed) {
			return ResponseEntity.ok(Map.of("message" , "User not found..."));
		}
		return ResponseEntity.ok(Map.of("message" , "User state OFF successfully..."));
	}
	@PutMapping("/OnState")
	public ResponseEntity<?> onStateUser(@RequestParam Integer userId) {
		boolean changed = userService.activateUser(userId);
		if(!changed) {
			return ResponseEntity.ok(Map.of("message" , "User not found..."));
		}
		return ResponseEntity.ok(Map.of("message" , "User state ACTIVATED successfully..."));
	}
	
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(@RequestParam Integer userId) {
		boolean deleted = userService.deleteUser(userId);
		if(!deleted) {
			return ResponseEntity.ok(Map.of("message" , "User not found..."));
		}
		return ResponseEntity.ok(Map.of("message" , "User deleted successfully..."));
	}
	
}

//•	register
//•	login
//•	view/update profile
//•	deactivate account

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
import com.resort.solution.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public Admin login(@RequestParam String email , @RequestParam String password) {
		return adminService.loginAdmin(email, password);
	}
	
	@GetMapping("/getById")
	public Admin getAdminByIds(@RequestParam Integer adminId) {
		return adminService.getAdminById(adminId);
	}
	
	@PutMapping("/updateAdmin")
	public Admin updateProfile(@RequestParam Integer adminId , @RequestBody Admin admin) {
		return adminService.updateAdminProfile(adminId, admin);
	}
	
	@PostMapping("/register")
	public Admin registeringrAdmin(@RequestBody Admin admin) {
		return adminService.registerAdmin(admin);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteAdmins(@RequestParam Integer adminId) {
		boolean deleted = adminService.deleteAdmin(adminId);
		if(!deleted) {
			return ResponseEntity.ok(Map.of("message" , "Admin not Deleted.."));
		}
		return ResponseEntity.ok(Map.of("message" , "Admin Deleted.."));
	}

}


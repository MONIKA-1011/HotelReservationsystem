package com.hotelmanagementsystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagementsystem.model.Admin;
import com.hotelmanagementsystem.service.AdminService;


@CrossOrigin(origins="http://localhost:4200")
@RestController //is controller which provides different end points to access the services 
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}
	
	//Register
			@PostMapping("/register")
			public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody  Admin admin)
			{
				
				return new ResponseEntity<Admin>(adminService.saveAdmin(admin),HttpStatus.CREATED);
			}
		//Login
			@PostMapping("/login")
			public  ResponseEntity<Admin> loginAdmin( @RequestBody Admin admin)
			{
			 	return new ResponseEntity<Admin>(adminService.loginAdmin(admin),HttpStatus.OK);
			
			
			}
			

}

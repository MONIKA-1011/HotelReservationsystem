package com.hotelmanagementsystem.service;

import com.hotelmanagementsystem.model.Admin;

public interface AdminService {
	Admin saveAdmin(Admin admin);
	Admin loginAdmin(Admin admin);
	
}

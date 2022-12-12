package com.hotelmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.Admin;
import com.hotelmanagementsystem.repository.AdminRepository;
import com.hotelmanagementsystem.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
		
		 public AdminServiceImpl(AdminRepository adminRepository) {
			super();
			this.adminRepository = adminRepository;
		}
	 

	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return this.adminRepository.findByAdminEmailIdAndAdminPassword(admin.adminEmailId,admin.adminPassword).orElseThrow(()->new ResourceNotFoundException("Admin ", "Id",admin.adminEmailId+"and password "+admin.adminPassword ));
	}
}

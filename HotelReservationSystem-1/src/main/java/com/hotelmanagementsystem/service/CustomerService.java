package com.hotelmanagementsystem.service;

import java.util.List;

import com.hotelmanagementsystem.model.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	List<Customer> getCustomer();
	Customer getCustomerById(long customerId);
	void deleteCustomerById(long customerId);
}

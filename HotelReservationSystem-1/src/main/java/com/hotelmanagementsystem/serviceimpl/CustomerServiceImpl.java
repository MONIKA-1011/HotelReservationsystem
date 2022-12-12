package com.hotelmanagementsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.Customer;
import com.hotelmanagementsystem.repository.CustomerRepository;
import com.hotelmanagementsystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}


	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}


	@Override
	public Customer getCustomerById(long customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","CustomerId",customerId)); 
		

	}


	@Override
	public void deleteCustomerById(long customerId) {
		// TODO Auto-generated method stub
		customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","CustomerId",customerId)); 
		customerRepository.deleteById(customerId);
	
	}
}

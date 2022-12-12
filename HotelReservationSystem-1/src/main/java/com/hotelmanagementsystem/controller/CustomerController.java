package com.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagementsystem.model.Customer;
import com.hotelmanagementsystem.service.CustomerService;

@CrossOrigin(origins="http://localhost:8089")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	 
	public CustomerController(CustomerService customerService) {
		super();
		this. customerService =  customerService;
	}
	

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody  Customer  customer)
	{
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Customer> getCustomer()
	{
		return customerService.getCustomer();
	}
	
	@GetMapping("{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") long  customerId)
	{
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") long  customerId)
	{
		 customerService.deleteCustomerById(customerId);
		return new ResponseEntity<String>(" Customer deleted successfully",HttpStatus.OK);
	}
	
	
}

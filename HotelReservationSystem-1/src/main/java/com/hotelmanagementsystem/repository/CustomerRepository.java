package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagementsystem.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}

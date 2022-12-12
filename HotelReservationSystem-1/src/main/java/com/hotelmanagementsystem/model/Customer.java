package com.hotelmanagementsystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="first_name")
	@NotEmpty
	@Size(min=3 , message="firstName must contain atleast 3 characters")
	private String firstName;
	
	@Column(name="last_name")
	@NotEmpty
	@Size(min=3 , message="lastName must contain atleast 3 characters")
	private String lastName;	
	
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
	@Column(name="district")
	@NotEmpty
	@Size(min=3 , message="district must contain atleast 3 characters")
    private String district;

	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Booking> booking;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	
	public Customer()
	{
		
	}

	public Customer(long customerId,
			@NotEmpty @Size(min = 3, message = "firstName must contain atleast 3 characters") String firstName,
			@NotEmpty @Size(min = 3, message = "lastName must contain atleast 3 characters") String lastName,
			@NotEmpty @Size(min = 10, max = 10, message = "phoneNumber must contain  10 digits") String phoneNumber,
			@NotEmpty @Size(min = 3, message = "district must contain atleast 3 characters") String district,
			List<Booking> booking) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.booking = booking;
	}



}

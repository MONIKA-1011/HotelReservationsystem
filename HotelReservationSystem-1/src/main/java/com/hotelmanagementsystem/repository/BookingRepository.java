package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagementsystem.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}

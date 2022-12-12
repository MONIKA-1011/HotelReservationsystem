package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagementsystem.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}

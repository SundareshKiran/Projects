package com.domain.filghtreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.filghtreservation.entities.Passenger;

public interface PassengerRepositry extends JpaRepository<Passenger, Long> {

}

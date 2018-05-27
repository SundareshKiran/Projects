package com.domain.filghtreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domain.filghtreservation.entities.Reservation;

public interface ReservationRepositry extends JpaRepository<Reservation, Long> {

}

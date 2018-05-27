package com.domain.filghtreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.filghtreservation.dto.ReservationUpdateRequest;
import com.domain.filghtreservation.entities.Reservation;
import com.domain.filghtreservation.repos.ReservationRepositry;

@RestController
public class ReservationRestController {

	@Autowired	
	ReservationRepositry reservationRepositry;
	
	
	@RequestMapping("/reservations/{id}")
	public Reservation reservationRepositry(@PathVariable("id")Long id) {
		return reservationRepositry.findOne(id);
		
	}
	
	@RequestMapping("/reservations")
	public Reservation updateResrvation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepositry.findOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		return reservationRepositry.save(reservation);
		
	}
}

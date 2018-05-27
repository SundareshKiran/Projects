package com.domain.filghtreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.filghtreservation.dto.ReservationRequest;
import com.domain.filghtreservation.entities.Flight;
import com.domain.filghtreservation.entities.Reservation;
import com.domain.filghtreservation.repos.FlightRepositry;
import com.domain.filghtreservation.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepositry flightRepositry;

	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightID") Long flightID, ModelMap modelMap) {
		Flight flight = flightRepositry.findOne(flightID);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {

		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Successfully Reserved" + reservation.getId());
		return "reservationConfirmation";

	}
}

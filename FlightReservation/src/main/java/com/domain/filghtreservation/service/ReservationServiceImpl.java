package com.domain.filghtreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.domain.filghtreservation.dto.ReservationRequest;
import com.domain.filghtreservation.entities.Flight;
import com.domain.filghtreservation.entities.Passenger;
import com.domain.filghtreservation.entities.Reservation;
import com.domain.filghtreservation.repos.FlightRepositry;
import com.domain.filghtreservation.repos.PassengerRepositry;
import com.domain.filghtreservation.repos.ReservationRepositry;
import com.domain.filghtreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Value("${com.domain.flightreservation.dirpath}")
	private  String ITINERARY_DIR;

	@Autowired
	 FlightRepositry flightRepositry;
	
	@Autowired
	 PassengerRepositry passengerRepositry;
	
	@Autowired
	ReservationRepositry reservationRepositry; 
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Long flightId = request.getFlightId();
		Flight flight = flightRepositry.findOne(flightId);
		
		Passenger passenger= new Passenger(); 
		
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		
		Passenger savedpassenger = passengerRepositry.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedpassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedResveration = reservationRepositry.save(reservation);
		
		String filePath = ITINERARY_DIR+savedResveration.getId()+".pdf";
		pdfGenerator.generateItinerary(savedResveration, filePath);
		
		
		return savedResveration;
	}

}

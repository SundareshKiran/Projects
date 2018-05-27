package com.domain.filghtreservation.service;

import com.domain.filghtreservation.dto.ReservationRequest;
import com.domain.filghtreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}

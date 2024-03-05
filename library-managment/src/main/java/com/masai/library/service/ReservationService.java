package com.masai.library.service;

public interface ReservationService {
	 public void placeReservation(Long memberId, Long bookId);
	 public void processReservationsForBook(Long bookId);
}

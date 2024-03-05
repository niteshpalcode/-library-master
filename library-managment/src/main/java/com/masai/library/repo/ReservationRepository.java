package com.masai.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.library.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByBookIdOrderByReservationDate(Long bookId);

}

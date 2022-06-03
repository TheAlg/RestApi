package com.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.reservation.models.reservation;

public interface reservationRepository extends JpaRepository <reservation, Long> {

}

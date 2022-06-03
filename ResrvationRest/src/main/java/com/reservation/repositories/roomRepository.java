package com.reservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.models.chambre;

public interface roomRepository extends JpaRepository <chambre, Long>{

}

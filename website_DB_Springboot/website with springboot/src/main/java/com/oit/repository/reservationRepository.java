package com.oit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oit.entity.reservation;
@Repository
public interface reservationRepository extends JpaRepository<reservation, Integer> {

}

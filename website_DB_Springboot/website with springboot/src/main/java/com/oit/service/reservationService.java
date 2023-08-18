package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oit.entity.reservation;

import com.oit.repository.reservationRepository;

@Service
public class reservationService {
	
	@Autowired
	reservationRepository repository;
	public void reservation(reservation r) {
		repository.save(r);
		
	}

}

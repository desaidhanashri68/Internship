package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oit.entity.contact;
import com.oit.repository.contactRepository;

@Service
public class contactService {
	
	@Autowired
	private contactRepository cRepository;
	public void contact(contact c) {
		cRepository.save(c);	
		
	}

}

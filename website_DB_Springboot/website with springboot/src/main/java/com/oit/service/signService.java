package com.oit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.oit.entity.signup;
import com.oit.repository.signRepository;

@Service
public class signService {
	
	@Autowired
	private signRepository signRepo;
	
	public void signup(signup s) {
		signRepo.save(s);
		
	}
	
}

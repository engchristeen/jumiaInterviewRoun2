package com.jumia.quiz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jumia.quiz.model.customer;

@Service
public interface CustomerService {
	
	public List<customer> getAllcustomer();

}

package com.jumia.quiz.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.quiz.Dao.customerDao;
import com.jumia.quiz.model.customer;
import com.jumia.quiz.service.CustomerService;

@Service
public class CustomerSerivceImpl implements CustomerService{

	@Autowired
	customerDao custDao ;
	
	@Override
	public List getAllcustomer() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List allcustomersNumers =  custDao.getAllCustomer();
		
		
		
		return allcustomersNumers ; 
	}
	

}

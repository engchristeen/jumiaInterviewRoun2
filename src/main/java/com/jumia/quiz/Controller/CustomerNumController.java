package com.jumia.quiz.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jumia.quiz.Dao.Impl.customerDaoImpl;
import com.jumia.quiz.service.CustomerService;


@RestController
@CrossOrigin
public class CustomerNumController {

	@Autowired
	private CustomerService custservice ;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(customerDaoImpl.class);

	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/getCustomerData/", method = RequestMethod.GET )
	public  List GetAllDepartmentResouces() {
		
		logger.info("started getting customer data ");
		List customerData = custservice.getAllcustomer();
        
       
		logger.info("started getting customer data ");
        return customerData;

		
		
	}
}

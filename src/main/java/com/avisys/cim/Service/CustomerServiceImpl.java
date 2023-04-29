package com.avisys.cim.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.Repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auo-generated method stub
		//calling JpaRepository interface method save() to save the customer into database
		return customerRepository.save(customer);
		
		
		
	   
		
		
		
	}

}

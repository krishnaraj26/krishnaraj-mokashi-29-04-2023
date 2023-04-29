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
	@Override
	public String DeleteByMobileNumber(String mobileNo) {
		//calling custom Finder Method to get the id of customer by his mobile number
		
		Long id = customerRepository.findByMobileNumber(mobileNo).getId();
		
		customerRepository.deleteById(id);//deleting the instance of customer by his id
		
		return "Customer deleted having id as "+id +" having mobile No"+mobileNo;
	}

}

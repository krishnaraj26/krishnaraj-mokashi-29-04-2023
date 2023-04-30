package com.avisys.cim.Service;

import java.util.List;
import java.util.Optional;

import com.avisys.cim.Customer;

public interface CustomerService {

	//method to add Customer into database
	Customer addCustomer(Customer customer);
	
	//method to delete Customer by mobile Number from database
	String DeleteByMobileNumber(String mobileNo);
	
	Customer findCustomer(Long id,String mobileNumber);
	
	List<Customer> findCustomerByFirstName(String firstName);
	
	List<Customer> findCustomerByLastName(String lastName);
	
	List<Customer> findCustomerByFirstNameAndLastName(String firstName,String lastName);
	
	Customer findCustomerByMobileNumber(String mobileNumber);
	
	List<Customer> findCustomerByFirstNameAndMobileNumber(String firstName,String mobileNumber);
	
	List<Customer> findCustomerBylastNameAndMobileNumber(String lastName,String mobileNumber);
	
	List<Customer> findCustomerByFirstNameAndlastNameAndMobileNumber(String firstName,String lastName,String mobileNumber);
	
	List<Customer> findAllCustomers();
	
}

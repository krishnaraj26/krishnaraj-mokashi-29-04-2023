package com.avisys.cim.Service;

import java.util.List;

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
	
	@Override
	public List<Customer> findCustomerByFirstName(String firstName) {
		
		
		//calling method to get customer by firstname
		return customerRepository.findByFirstName(firstName);
	}
	@Override
	public List<Customer> findCustomerByLastName(String lastName) {
	
		//calling method to get customer by lastname
		return customerRepository.findByLastName(lastName);
	}
	@Override
	public List<Customer> findCustomerByFirstNameAndLastName(String firstName,String lastName) {
		//calling method to get customer by firstname and lastname
		return customerRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	@Override
	public Customer findCustomerByMobileNumber(String mobileNumber) {
		
		//calling method to get customer by mobileNumber
		return customerRepository.findByMobileNumber(mobileNumber);
	}
	@Override
	public List<Customer> findCustomerByFirstNameAndMobileNumber(String firstName, String mobileNumber) {
		//calling method to get customer by firstname and mobileNumber 
		return customerRepository.findByFirstNameAndMobileNumber(firstName, mobileNumber);
	}
	@Override
	public List<Customer> findCustomerBylastNameAndMobileNumber(String lastName, String mobileNumber) {
		//calling method to get customer by lastname and mobileNumber 
		return customerRepository.findByLastNameAndMobileNumber(lastName, mobileNumber);
	}
	@Override
	public List<Customer> findCustomerByFirstNameAndlastNameAndMobileNumber(String firstName, String lastName,
			String mobileNumber) {
		//calling method to get customer by firstname and lastname and mobileNumber 
		return customerRepository.findByFirstNameAndLastNameAndMobileNumber(firstName, lastName, mobileNumber);
	}
	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		
		//finding all customers
		return customerRepository.findAll();
	}

}

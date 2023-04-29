package com.avisys.cim.Service;

import com.avisys.cim.Customer;

public interface CustomerService {

	//method to add Customer into database
	Customer addCustomer(Customer customer);
	
	//method to delete Customer by mobile Number from database
	String DeleteByMobileNumber(String mobileNo);
}

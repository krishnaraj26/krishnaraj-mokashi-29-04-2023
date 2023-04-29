 package com.avisys.cim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisys.cim.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
Customer findByMobileNumber(String mobileNo);
	
}

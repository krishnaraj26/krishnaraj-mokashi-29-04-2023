 package com.avisys.cim.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avisys.cim.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
Customer findByMobileNumber(String mobileNo);

@Query("select distinct c from Customer c where LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%'))")
List<Customer> findByFirstName(@Param("firstName") String firstName);

@Query("select distinct c from Customer c where LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%'))")
List<Customer> findByLastName(@Param("lastName") String lastName);

@Query("select distinct c from Customer c where "
		+ "LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%')) AND "
		+ "LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%'))")
List<Customer> findByFirstNameAndLastName(
		@Param("firstName") String firstName,@Param("lastName") String lastName);


@Query("select distinct c from Customer c where LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%'))"
		+ "AND c.mobileNumber=:mobileNumber"
		)
List<Customer> findByFirstNameAndMobileNumber(@Param("firstName") String firstName,@Param("mobileNumber") String mobileNumber);

@Query("select distinct c from Customer c where LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%'))"
		+ "AND c.mobileNumber=:mobileNumber"
		)
List<Customer> findByLastNameAndMobileNumber(@Param("lastName") String lastName,@Param("mobileNumber") String mobileNumber);

@Query("select distinct c from Customer c where "
		+ "LOWER(c.firstName) like LOWER(CONCAT('%',:firstName,'%')) AND "
		+ "LOWER(c.lastName) like LOWER(CONCAT('%',:lastName,'%'))"
		+ "AND c.mobileNumber=:mobileNumber")
List<Customer> findByFirstNameAndLastNameAndMobileNumber(
		@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("mobileNumber") String mobileNumber);



	
}

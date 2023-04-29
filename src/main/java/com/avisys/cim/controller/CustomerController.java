package com.avisys.cim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.Dto.ResponseDto;
import com.avisys.cim.Service.CustomerService;
import com.avisys.cim.exception.ErrorResponse;

@RestController//combination of two annotation @Controller + @ResponseBody
@RequestMapping("/customer")//to map the url with class method
public class CustomerController {

	@Autowired//to inject dependencies on required
	private CustomerService customerService;
	
	
	public CustomerController() {
		System.out.println("Inside ctor of"+getClass().getName());
	}

	@PostMapping("/add")//post method to add customer
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
	{
              System.out.println("in method of customerAdding");		
		try {
			//if Mobile Number found is unique it will add customer into database
			return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
		}catch(RuntimeException e){
			//if  duplicate mobileNumber was found then error will occur
			return new ResponseEntity<>(new ErrorResponse("Customer Insertion Failed",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	//Deleting customer by his mobileNumber
	@DeleteMapping("/delete/{mobileNo}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String mobileNo)
	{
		System.out.println("in delete Customer Method ");
		
		try {
			//deleting a customer by his mobile Number
			return new ResponseEntity<>(new ResponseDto(customerService.DeleteByMobileNumber(mobileNo)),HttpStatus.OK);
			
		}catch (RuntimeException e)
		{
			//if mobile number was not found then it will throw error of no mobile number found
			return new ResponseEntity<>(new ErrorResponse("Mobile Number not found",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		
	
		
		
		
	}
	
	
	
}

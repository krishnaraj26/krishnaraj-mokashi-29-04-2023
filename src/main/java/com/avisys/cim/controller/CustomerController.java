package com.avisys.cim.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/search")
	public ResponseEntity<?> findByFirstName(@RequestParam(required = false) String firstName
			,@RequestParam(required = false) String lastName , @RequestParam(required = false) String mobileNumber
			
			)
	{
		try {
			//finding customer given firstname , lastname, and mobilenumber
			if(firstName!=null && lastName!=null && mobileNumber!=null)
			{
				return new ResponseEntity<>(customerService.findCustomerByFirstNameAndlastNameAndMobileNumber(firstName, lastName, mobileNumber),HttpStatus.OK);
			}
			
			
			else if(firstName!=null && lastName!=null)
			{
				//finding customer given firstname , lastname
				return new ResponseEntity<>(customerService.findCustomerByFirstNameAndLastName(firstName,lastName),HttpStatus.OK);
		    }
			else if(firstName!=null && mobileNumber!=null)
			{//finding customer given firstname , mobileNumber
				return new ResponseEntity<>(customerService.findCustomerByFirstNameAndMobileNumber(firstName,mobileNumber),HttpStatus.OK);

			}
			else if (lastName!=null && mobileNumber!=null)
			{
				//finding customer given lastname , mobileNumber
				return new ResponseEntity<>(customerService.findCustomerBylastNameAndMobileNumber(lastName, mobileNumber),HttpStatus.OK);
			}
			else if(lastName!=null)
			{
				//finding customer given lastname 
				return new ResponseEntity<>(customerService.findCustomerByLastName(lastName),HttpStatus.OK);

			}
			else if(firstName!=null)
			{
				//finding customer given firstname 
				return new ResponseEntity<>(customerService.findCustomerByFirstName(firstName),HttpStatus.OK);
			}
			else if(mobileNumber!=null)
			{
				
				//finding customer given mobikenumber
				return new ResponseEntity<>(customerService.findCustomerByMobileNumber(mobileNumber),HttpStatus.OK);
			}
			//finding all customers
			else return new ResponseEntity<>(customerService.findAllCustomers(),HttpStatus.OK);
			
		
		}
		catch(RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("customer not found",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// functionality to update mobile number of given id with given new mobile number
	@PutMapping("/update/{id}")
	public  ResponseEntity<?>  updateMobileNumber(@PathVariable Long id, @RequestParam String mobileNumber)
	{
		 Customer c  = customerService.findCustomer(id,mobileNumber);
		 if(c!=null)
		return new ResponseEntity<>(c,HttpStatus.OK );
		 else 
		 return new ResponseEntity<>(new ErrorResponse("Customer not found"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}

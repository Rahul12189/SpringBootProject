package com.mybootproject.playground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Customer;
import com.mybootproject.playground.repository.CustomerRepository;

@RestController
public class CustomerController {

	//GET
	//POST
	//PUT
	//DELETE 
	@Autowired
	private CustomerRepository customerRepository;
	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}

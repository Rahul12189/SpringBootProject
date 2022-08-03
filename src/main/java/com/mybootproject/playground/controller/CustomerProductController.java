package com.mybootproject.playground.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Customer;
import com.mybootproject.playground.model.CustomerProduct;
import com.mybootproject.playground.model.Product;
import com.mybootproject.playground.repository.CustomerProductRepository;
import com.mybootproject.playground.repository.CustomerRepository;
import com.mybootproject.playground.repository.ProductRepository;

@RestController
public class CustomerProductController {

	@Autowired
	private CustomerProductRepository customerProductRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/purchase/customer/product/{cid}/{pid}")
	public CustomerProduct purchaseAPi(@RequestBody CustomerProduct customerProduct,
							@PathVariable("cid") Long cid, 
							@PathVariable("pid") Long pid) {
		
		Optional<Customer> optionalC = customerRepository.findById(cid);
		
		if(!optionalC.isPresent())
			throw new RuntimeException("Invalid Customer ID!!");
		
		Customer customer = optionalC.get();
		
		Optional<Product> optionalP = productRepository.findById(pid);
		if(!optionalP.isPresent())
			throw new RuntimeException("Invalid Product ID!!");
		
		Product product = optionalP.get();
		
		customerProduct.setProduct(product);
		customerProduct.setCustomer(customer);
		
		customerProduct.setDateOfPurchase(LocalDate.now());
		
		return customerProductRepository.save(customerProduct);
	}
	
	/*
	 * Fetch all customer who have purchased given Product: {pid} : List<Customer>
	 */
	@GetMapping("/customer/product/{pid}")
	public List<Customer> getCustomerByProduct(@PathVariable("pid") Long pid) {
		List<Customer> list = customerProductRepository.getCustomerByProduct(pid);
		return list; 
	}
	/*
	 * Fetch products purchased by given customer: {cid} : List<Product>
	 */
	@GetMapping("/product/customer/{cid}")
	public List<Customer> getProductByCustomer() {
		return null;
	}
	/*
	 * Fetch customer that have purchased a product sold by given vendor: {vid} : List<Customer>
	 */
	@GetMapping("/customer/vendor/{vid}")
	public List<Customer> getCustomerByVendor(){
		return null;
	}
	/*
	 * Fetch Customer that have purchased the products belonging to given category: {cid} : List<Customer>
	 */
	@GetMapping("/customer/category/{cid}")
	public List<Customer> getCustomerByCategory(){
		return null;
	}
}








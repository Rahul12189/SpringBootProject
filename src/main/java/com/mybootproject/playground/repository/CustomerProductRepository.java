package com.mybootproject.playground.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootproject.playground.model.Customer;
import com.mybootproject.playground.model.CustomerProduct;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long>{

	@Query("select cp.customer from CustomerProduct cp where cp.product.id=?1")
	List<Customer> getCustomerByProduct(Long pid);

}

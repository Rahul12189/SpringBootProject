package com.mybootproject.playground.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybootproject.playground.model.Vendor;
import com.mybootproject.playground.repository.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/vendor/city/{city}")
	public List<Vendor> getVendorByCity(@PathVariable("city") String city) {
		List<Vendor> list = vendorRepository.getByCity(city);
		return list;
	}
	
	@PostMapping("/vendor")
	public Vendor postVendor(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
}

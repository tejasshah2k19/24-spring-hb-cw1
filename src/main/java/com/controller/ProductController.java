package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepo; 
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody ProductEntity productEntity){
		
		//database save ! 
		productRepo.save(productEntity);
		
		return ResponseEntity.ok(productEntity);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts(){
		
		List<ProductEntity> products  = productRepo.findAll(); 
		return ResponseEntity.ok(products);
	}
	
	//    /product/create   /product/all 
	
	



}

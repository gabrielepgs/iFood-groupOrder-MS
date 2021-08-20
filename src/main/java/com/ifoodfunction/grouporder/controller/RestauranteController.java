package com.ifoodfunction.grouporder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifoodfunction.grouporder.domain.Restaurante;
import com.ifoodfunction.grouporder.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)	
	public ResponseEntity<?> find (@PathVariable Integer id) {
		
		Restaurante obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
				
	}

}
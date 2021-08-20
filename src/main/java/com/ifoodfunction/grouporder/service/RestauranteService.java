package com.ifoodfunction.grouporder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifoodfunction.grouporder.domain.Restaurante;
import com.ifoodfunction.grouporder.repositories.RestauranteRepository;
import com.ifoodfunction.grouporder.services.exception.ObjectNotFoundException;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restaurante;
	
	public Restaurante buscar(Integer id) {

		Optional<Restaurante> obj = restaurante.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Restaurante.class.getName()));
	
	}
}
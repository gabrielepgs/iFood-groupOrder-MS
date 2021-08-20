package com.ifoodfunction.grouporder;

import java.util.Arrays;

import com.ifoodfunction.grouporder.domain.Plano;
import com.ifoodfunction.grouporder.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ifoodfunction.grouporder.domain.Produto;
import com.ifoodfunction.grouporder.domain.Restaurante;
import com.ifoodfunction.grouporder.repositories.ProdutoRepository;
import com.ifoodfunction.grouporder.repositories.RestauranteRepository;


@SpringBootApplication
public class GrouporderApplication implements CommandLineRunner{
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PlanoRepository planoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GrouporderApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		//Configura os dados dos planos
		Plano pl1 = new Plano(null, "Básico", "Plano Básico", "12%", 100.0);
		Plano pl2 = new Plano(null, "Entrega", "Plano com Entrega incluída", "27%", 180.0);

		//Configura os dados dos restaurantes
		Restaurante rest1 = new Restaurante(null, "Pizzaria Creck", "Pizzaria");
		Restaurante rest2 = new Restaurante(null, "Pizzaria Casa Nova", "Pizzaria");
		Restaurante rest3 = new Restaurante(null, "Rodriguês Pizzaria Vegana", "Pizzaria");

		//Configura os planos para cada restaurante
		rest1.setPlano(pl1);
		rest2.setPlano(pl2);
		rest3.setPlano(pl2);

		//Configura os dados dos produtos
		Produto p1 = new Produto(null, "Pizza Mussarela", "Mussarela, tomate e orégano", 40.00, rest1);
		Produto p2 = new Produto(null, "Pizza Calabresa","Calabresa e mussarela", 39.00, rest1);
		Produto p3 = new Produto(null, "Pizza Mussarela","Mussarela, tomate e orégano", 55.00, rest2);
		Produto p4 = new Produto(null, "Pizza Frango com Catupiry","Frango e catupiry", 40.00, rest2);
		Produto p5 = new Produto(null, "Pizza Mussarela Vegana","Mussarela vegana, tomate e orégano", 50.00, rest3);
		Produto p6 = new Produto(null, "Pizza de Legumes","Brócolis, beringela, palmito, tomate e mussarela vegana", 45.00, rest3);

		//Persiste os dados configurados no banco de dados H2
		planoRepository.saveAll(Arrays.asList(pl1, pl2));
		restauranteRepository.saveAll(Arrays.asList(rest1, rest2, rest3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

	}
}

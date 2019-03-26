package com.ibk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ibk.services.repository.UsuarioRepository;

import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SpringRestIbkApplication implements CommandLineRunner{

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestIbkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		customerRepository.save(new Customer("Jack", "Smith"));
//		customerRepository.save(new Customer("Adam", "Johnson"));
//		customerRepository.save(new Customer("Kim", "Smith"));
//		customerRepository.save(new Customer("David", "Williams"));
//		customerRepository.save(new Customer("Peter", "Davis"));
		//mascotaRepository.save(new Mascota("M", "casa", "pitbull", "pequenio"));
		//mascotaRepository.save(new Mascota("M", "pantano", "pequines", "pequenio"));
	}
}

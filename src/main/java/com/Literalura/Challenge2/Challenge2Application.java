package com.Literalura.Challenge2;

import com.Literalura.Challenge2.principal.Principal;
import com.Literalura.Challenge2.repository.LiborRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Challenge2Application.class, args);
	}

	@Autowired
	LiborRepository repository;

	@Override
	public void run(String... args) throws Exception {
		Principal principal=new Principal(repository);
		principal.ejecutar();
	}
}

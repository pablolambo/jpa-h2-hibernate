package com.example.demoRESTweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoResTwebApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DemoResTwebApplication.class, args);
	}

}

/*
 * zamienic poprzednie zadanie ze studentami z resta na cos takiego z baza h2
 * https://www.baeldung.com/spring-boot-hibernate
 * poradnik
 *
 *
 * list<Student> -> h2
 * REST -> odwoluje sie do bazy h2, robia to samo
 * h2 ma dane poczatkowe z import.sql
 * Student ma adres, relacja z inna tabela
 *
 * GET (rest) zwracajacy liste Studentow o jakims kryterium np imie
 *
 *
 *  */
package com.example.customer.SpringCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.Map;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}

}

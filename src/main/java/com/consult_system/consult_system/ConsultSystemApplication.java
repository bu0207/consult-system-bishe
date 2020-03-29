package com.consult_system.consult_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.consult_system")
@EntityScan(basePackages = {"com.consult_system"})
@EnableJpaRepositories(basePackages = {"com.consult_system"})
@EnableJpaAuditing
public class ConsultSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultSystemApplication.class, args);
	}

}

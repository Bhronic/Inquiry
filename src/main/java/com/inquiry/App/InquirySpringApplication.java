package com.inquiry.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.inquiry.*"})
@EntityScan(basePackages = {"com.inquiry.model"})
@EnableJpaRepositories("com.inquiry.repository")
public class InquirySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(InquirySpringApplication.class, args);
	}

}

package com.cybage;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cybage.dao.DiscountDAO;
import com.cybage.model.Discount;
@Configuration
@SpringBootApplication(scanBasePackages={"com.cybage","com.cybage.model", "com.cybage.controller", "com.cybage.service", "com.cybage.dao"})
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.cybage.model"})
@EnableJpaRepositories(basePackages= {"com.cybage.dao"})
public class DiscountAssignmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DiscountAssignmentApplication.class, args);
		System.out.println("angular spring boot application started.");
		
	}

}

package com.soa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.soa.mapper")
@EnableEurekaClient
@EnableCircuitBreaker
public class service_user {

	public static void main(String[] args) {
		SpringApplication.run(service_user.class, args);
	}


}

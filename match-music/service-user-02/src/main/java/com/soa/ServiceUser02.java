package com.soa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.soa.mapper")
@EnableEurekaClient
public class ServiceUser02 {

	public static void main(String[] args) {
		SpringApplication.run(ServiceUser02.class, args);
	}

}

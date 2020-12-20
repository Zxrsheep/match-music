package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class Feign_user {

	public static void main(String[] args) {
		SpringApplication.run(Feign_user.class, args);
	}

}

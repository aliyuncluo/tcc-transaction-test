package com.cluo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TccTransactionProvider1Application {

	public static void main(String[] args) {
		SpringApplication.run(TccTransactionProvider1Application.class, args);
	}

}

package com.cluo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
//@ComponentScan(basePackages="com.cluo")
public class TccTransactionBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccTransactionBusinessApplication.class, args);
	}

}

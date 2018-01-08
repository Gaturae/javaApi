package com.gbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class DatamathApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatamathApplication.class, args);
	}
}

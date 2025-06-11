package com.my.admin.app.demo.adminapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAdminappApplication {

	public static void main(String[] args) {
		running();
		SpringApplication.run(DemoAdminappApplication.class, args);
	}

	private static void running() {
		// use logger instead of System.out.println in production code
		// logger.info("Running");
		System.out.println("Running");
	}

}

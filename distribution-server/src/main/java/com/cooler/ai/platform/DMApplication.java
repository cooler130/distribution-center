package com.cooler.ai.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:applicationContext.xml")
public class DMApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMApplication.class, args);
	}
}

package com.soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(value = "com.soft")
@ImportResource(value = {"classpath:providers.xml"})
public class SpringDubborestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDubborestApplication.class, args);
	}

}

package com.trains.steve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
public class SteveTrainsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteveTrainsApplication.class, args);
	}

}

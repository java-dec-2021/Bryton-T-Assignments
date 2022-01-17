package com.bryton.dojos_and_ninjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.bryton.dojos_and_ninjas"})
public class DojosAndNinjasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojosAndNinjasApplication.class, args);
	}

}

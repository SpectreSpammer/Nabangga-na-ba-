package com.rnit.Nabangga_na_ba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.rnit.nabangga_na_ba")
public class NabanggaNaBaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NabanggaNaBaApplication.class, args);
	}

}

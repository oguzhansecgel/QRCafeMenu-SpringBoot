package com.cafem.CafeMenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.turkcell.tcell.exception.annotations.EnableException;

@SpringBootApplication
@EnableException
public class CafeMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeMenuApplication.class, args);
	}

}

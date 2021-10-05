package com.myownapp.masteringjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MasteringjwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasteringjwtApplication.class, args);
	}

}

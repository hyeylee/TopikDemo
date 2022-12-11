package org.zerock.topik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopikApplication {

	public static void main(String[] args) {

		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(TopikApplication.class, args);
	}

}

package br.edu.infnet.eduardo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EduardoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduardoApplication.class, args);
		new Loader().loadData();
	}

}

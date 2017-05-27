package pl.oskarpolak.newspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NewspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewspringApplication.class, args);
		ConfigurableApplicationContext app = SpringApplication.run(NewspringApplication.class, args);

	}
}

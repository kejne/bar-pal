package se.fehlhaber.barpal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class BarpalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarpalApplication.class, args);
	}
}

package hr.fer.opp.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Stars the Spring application.
 */
@SpringBootApplication
public class Application {

	/**
	 * The main method.
	 *
	 * @param args command lines arguments; not used
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

package org.school.classeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Cette classe est le point d'entrée de l'application StudentApi. Elle initialise et démarre
 * l'application Spring Boot.
 *
 * @author Yassine FATHI
 * @version 0.0.1-SNAPSHOT
 */
@SpringBootApplication
public class ClassApiApplication {

	/**
	 * Le point d'entrée principal de l'application.
	 *
	 * @param args Les arguments de ligne de commande (non utilisés dans cette application).
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClassApiApplication.class, args);
	}
}

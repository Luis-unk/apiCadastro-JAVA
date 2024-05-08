package br.com.criandoapi.projetoJAVA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoJavaApplication.class, args);
	}

}

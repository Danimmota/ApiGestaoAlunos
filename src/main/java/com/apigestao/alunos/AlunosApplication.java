package com.apigestao.alunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // esta anotação irá dar funcionalidade a class BaseEntity para fazer o gerenciamento de auditoria
public class AlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunosApplication.class, args);
	}

}

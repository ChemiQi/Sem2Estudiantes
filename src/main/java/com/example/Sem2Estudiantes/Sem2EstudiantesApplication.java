package com.example.Sem2Estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@Import(BeanValidatorPluginsConfiguration.class)
public class Sem2EstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sem2EstudiantesApplication.class, args);
	}

}

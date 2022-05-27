package curso.spring.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//Preparando os recursos do projeto
@SpringBootApplication
@EntityScan(basePackages = {"curso.spring.rest.api.model"})
@ComponentScan(basePackages = {"curso.*"})//Para as injeções de dependência
@EnableJpaRepositories(basePackages = {"curso.spring.rest.api.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration
public class CursospringrestapiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CursospringrestapiApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CursospringrestapiApplication.class);
	}

}

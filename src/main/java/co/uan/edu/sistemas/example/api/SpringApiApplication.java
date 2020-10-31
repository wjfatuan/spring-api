package co.uan.edu.sistemas.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

// import liquibase.integration.spring.SpringLiquibase;

@SpringBootApplication
public class SpringApiApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurer() {

			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config.setBasePath("/api/v1");
				config.exposeIdsFor(Data.class);
				config.setDefaultMediaType(MediaType.APPLICATION_JSON);
				config.useHalAsDefaultJsonMediaType(false);
			}
		};
	}

	// @Bean
	// public SpringLiquibase liquibase() {
	// 	SpringLiquibase liquibase = new SpringLiquibase();
	// 	liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
	// 	return liquibase;
	// }

	// @Bean
	// public CommandLineRunner demo(DataRepository repository) {
	// 	return (args) -> {
	// 		// save a few customers
	// 		repository.save(new Data("student", "{'name':'John','code':'12345'}"));
	// 		repository.save(new Data("student", "{'name':'Jack','code':'12345'}"));
	// 		repository.save(new Data("teacher", "{'name':'Kim','code':'12345'}"));
	// 		repository.save(new Data("teacher", "{'name':'David','code':'12345'}"));

	// 		// fetch all data
	// 		log.info("Data found with findAll():");
	// 		log.info("-------------------------------");
	// 		for (Data data : repository.findAll()) {
	// 			log.info(data.toString());
	// 		}
	// 		log.info("");

	// 		// fetch an individual customer by ID
	// 		Data data = repository.findById(1L);
	// 		log.info("Data found with findById(1L):");
	// 		log.info("--------------------------------");
	// 		log.info(data.toString());
	// 		log.info("");

	// 		// fetch data by name
	// 		log.info("Data found with findByName('student'):");
	// 		log.info("--------------------------------------------");
	// 		repository.findByName("student").forEach(student -> {
	// 			log.info(student.toString());
	// 		});
	// 		log.info("");
	// 	};
	// }

}

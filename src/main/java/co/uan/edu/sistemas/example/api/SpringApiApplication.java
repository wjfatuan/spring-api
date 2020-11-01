package co.uan.edu.sistemas.example.api;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

// import liquibase.integration.spring.SpringLiquibase;

@SpringBootApplication
public class SpringApiApplication {

	// private static final Logger log = LoggerFactory.getLogger(SpringApiApplication.class);

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

}

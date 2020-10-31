package co.uan.edu.sistemas.example.api;

import com.zaxxer.hikari.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Profile("heroku")
@Configuration
public class DatabaseConfig {

  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Bean
  public DataSource dataSource() {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl);
      return new HikariDataSource(config);
  }
}
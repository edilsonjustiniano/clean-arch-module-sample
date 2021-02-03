package module.dataprovider.aurora.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "module.dataprovider")
@EnableJpaRepositories(basePackages = "module.dataprovider.aurora")
public class DBConfig {

}

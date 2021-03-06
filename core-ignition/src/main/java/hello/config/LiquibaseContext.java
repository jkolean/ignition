package hello.config;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.sql.DataSource;

import liquibase.integration.spring.SpringLiquibase;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Use liquibase to set up the Database for the application
 *
 * <pre>
 * Create an empty schema called 'ignition' to get things rolling
 * </pre>
 *
 * @author jameskolean
 *
 */
@Configuration
@Slf4j
public class LiquibaseContext {
	@Autowired
	private DataSource dataSource;
	@Resource
	private Environment environment;

	public LiquibaseContext() {
		log.debug("Creating LiquibaseContext");
	}

	@Bean(name = "liquibase")
	public SpringLiquibase liquibase() {
		final SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog(environment.getRequiredProperty("liquibase.change-log"));
		liquibase.setChangeLogParameters(new HashMap<String, String>());
		liquibase.setContexts(environment.getRequiredProperty("liquibase.contexts"));
		return liquibase;
	}
}

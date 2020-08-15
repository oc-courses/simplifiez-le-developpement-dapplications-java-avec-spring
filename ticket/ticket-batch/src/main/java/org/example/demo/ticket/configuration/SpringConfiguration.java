package org.example.demo.ticket.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

// Scan dans le code de ticket-batch.Main
@Configuration
@ImportResource({
    "classpath:/org/example/demo/ticket/batch/batchContext.xml"
})
public class SpringConfiguration {
	@Autowired
	DataSource dataSource;

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}

	@Bean("namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getNamedParamJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}

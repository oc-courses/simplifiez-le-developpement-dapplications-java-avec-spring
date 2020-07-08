package org.example.demo.ticket.webapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan(basePackages = "org.example.demo.ticket")
@ImportResource(locations = "classpath:/org/example/demo/ticket/webapp/webappContext.xml")
public class SpringConfiguration {
	
	@Autowired
	@Qualifier("dataSourceTicket")
	private DataSource dataSource;

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(@Qualifier("dataSourceTicket") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean("namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate getNamedParamJdbcTemplate( @Qualifier("dataSourceTicket") DataSource dataSource ) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}

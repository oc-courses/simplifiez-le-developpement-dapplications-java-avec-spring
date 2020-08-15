package org.example.demo.ticket.webapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
@ComponentScan(basePackages = "org.example.demo.ticket", excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SpringConfiguration.class)  )
@ImportResource(locations = "classpath:/org/example/demo/ticket/webapp/webappTestContext.xml")
public class SpringTestConfiguration {
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

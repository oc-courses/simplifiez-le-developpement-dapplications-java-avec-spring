package org.example.demo.ticket.webapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "org.example.demo.ticket")
@ImportResource(locations = "classpath:/org/example/demo/ticket/webapp/webappContext.xml")
public class SpringConfiguration {

}

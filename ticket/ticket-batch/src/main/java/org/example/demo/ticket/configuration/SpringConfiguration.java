package org.example.demo.ticket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// Scan dans le code de ticket-batch.Main
@Configuration
@ImportResource(locations = "classpath:/org/example/demo/ticket/batch/batchContext.xml")
public class SpringConfiguration {

}

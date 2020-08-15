package org.example.demo.ticket.webapp.rest.resource.projet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.demo.ticket.webapp.configuration.SpringTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@SpringJUnitWebConfig(classes = SpringTestConfiguration.class)
public class ProjetResourceIntegrationJerseyTest {

	private static final String PROJECTS_URL= "http://localhost:8080/ticket-webapp/projets";

	private static final String TICKETS_URL = "http://localhost:8080/ticket-webapp/tickets/search/";
	
	MockMvc mockMvc;
	
//	WebApplicationContext wac;

	@BeforeEach
	public void setup(WebApplicationContext wac) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
//	public void setup() {
//		this.mockMvc = MockMvcBuilders.standaloneSetup(new ProjetResource()).build();
//	}

	@Test
	@Disabled("Not Ready yet")
	public void testgetProjets() throws Exception {
		this.mockMvc.perform(get("/ticket-webapp/projets").accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk())
							.andExpect(content().contentType("application/json"))
							.andExpect(jsonPath("$.name").value("Lee"));
	}
	
	
	@Test
	public void givenGetAllProjects_whenCorrectRequest_thenResponseCodeSuccess()
			throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet(PROJECTS_URL);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}
	
	@Test
	public void givenGetAllTickets_whenCorrectRequest_thenResponseCodeSuccess()
			throws ClientProtocolException, IOException {

		HttpUriRequest request = new HttpGet(TICKETS_URL);

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
	}
}

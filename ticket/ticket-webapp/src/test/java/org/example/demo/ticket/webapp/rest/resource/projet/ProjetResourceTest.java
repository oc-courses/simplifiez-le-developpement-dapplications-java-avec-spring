package org.example.demo.ticket.webapp.rest.resource.projet;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



@SpringJUnitWebConfig(locations = "test-servlet-context.xml")
public class ProjetResourceTest {

	MockMvc mockMvc;

	@BeforeEach
	public void setup(WebApplicationContext wac) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void getAccount() throws Exception {
		this.mockMvc.perform(get("/accounts/1").accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk())
							.andExpect(content().contentType("application/json"));
							//.andExpect(jsonPath("$.name").value("Lee"));
	}
}

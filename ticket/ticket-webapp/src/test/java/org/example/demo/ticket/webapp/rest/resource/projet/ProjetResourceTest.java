package org.example.demo.ticket.webapp.rest.resource.projet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.example.demo.ticket.webapp.configuration.SpringTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@SpringJUnitWebConfig(classes = SpringTestConfiguration.class)
public class ProjetResourceTest {

	MockMvc mockMvc;

	@BeforeEach
//	public void setup(WebApplicationContext wac) {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//	}
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new ProjetResource()).build();
	}

	@Test
	@Disabled("Not Ready yet")
	public void testgetProjets() throws Exception {
		this.mockMvc.perform(get("/projets").accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk())
							.andExpect(content().contentType("application/json"))
							.andExpect(jsonPath("$.name").value("Lee"));
	}
}

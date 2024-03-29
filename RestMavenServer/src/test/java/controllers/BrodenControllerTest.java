package controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BrodenControllerTest {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testList() throws Exception {
		this.mockMvc
				.perform(
						get("/broden")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].naam").value("Wit"))
				.andExpect(jsonPath("$.[0].prijs").value(0.25))
				.andExpect(jsonPath("$.[1].naam").value("Bruin"))
				.andExpect(jsonPath("$.[1].prijs").value(0.4));
	}

}

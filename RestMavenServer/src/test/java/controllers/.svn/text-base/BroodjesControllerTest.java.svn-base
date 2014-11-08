package controllers;

import java.math.BigDecimal;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import broodjes.Broodje;
import daos.BrodenDao;
import daos.BroodjesDao;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BroodjesControllerTest {
	private static ObjectWriter jsonWriter;

	@Autowired
	private WebApplicationContext context;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private BroodjesDao broodjesDao;
	@Autowired
	private BrodenDao brodenDao;

	private MockMvc mockMvc;

	@BeforeClass
	public static void initialSetup() {
		jsonWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
	}

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testBroodjes() throws Exception {
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$", Matchers
								.hasSize(broodjesDao.getBroodjes().size())));
	}

	@Test
	public void testCreateBroodje() throws Exception {
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(4)));

		Broodje broodje = new Broodje("5");
		broodje.setNaam("testBroodje");
		broodje.setPrijs(new BigDecimal(5.25));
		broodje.setBrood(brodenDao.getBrood("Wit"));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/broodjes")
								.contentType(
										MediaType
												.parseMediaType("application/json;charset=UTF-8"))
								.content(jsonWriter.writeValueAsString(broodje)))
				.andExpect(MockMvcResultMatchers.status().isOk());

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)));

		mongoTemplate.remove(broodje);
	}

	@Test
	public void testBroodje() throws Exception {
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes/1")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.naam").value(
								"TestBroodje"))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.prijs").value(3.25))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.brood.naam").value(
								"Wit"))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.brood.prijs").value(
								0.25));
	}

	@Test
	public void testUpdateBroodje() throws Exception {
		Broodje broodje = broodjesDao.getBroodje("1");
		broodje.setNaam("broodje");

		mockMvc.perform(
				MockMvcRequestBuilders
						.put("/broodjes/1")
						.contentType(
								MediaType
										.parseMediaType("application/json;charset=UTF-8"))
						.content(jsonWriter.writeValueAsString(broodje)))
				.andExpect(MockMvcResultMatchers.status().isOk());

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes/1")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.naam").value(
								"broodje"))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.prijs").value(3.25))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.brood.naam").value(
								"Wit"))
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.brood.prijs").value(
								0.25));

		broodje.setNaam("TestBroodje");
		broodjesDao.bewerkBroodje(broodje);
	}

	@Test
	public void testDeleteBroodje() throws Exception {
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(4)));

		Broodje broodje = broodjesDao.getBroodje("1");

		mockMvc.perform(
				MockMvcRequestBuilders
						.delete("/broodjes/1")
						.contentType(
								MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk());

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.get("/broodjes")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));

		broodjesDao.addBroodje(broodje);
	}

}

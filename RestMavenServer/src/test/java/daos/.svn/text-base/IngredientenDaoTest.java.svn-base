package daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import broodjes.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class IngredientenDaoTest {
	@Autowired
	private IngredientenDao ingredientenDao;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void getIngredienten() {
		List<Ingredient> ingredienten = ingredientenDao.getIngredienten();
		assertNotNull(ingredienten);
		assertEquals(5, ingredienten.size());
	}

	@Test
	public void addIngredient() {
		Ingredient ingredient = new Ingredient("6", "testIngredient", 0.5,
				"testUrl");
		ingredientenDao.addIngredient(ingredient);

		List<Ingredient> ingredienten = ingredientenDao.getIngredienten();
		assertNotNull(ingredienten);
		assertEquals(6, ingredienten.size());

		mongoTemplate.remove(ingredient);
	}

}

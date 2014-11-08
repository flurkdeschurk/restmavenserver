package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import broodjes.Brood;
import broodjes.Broodje;
import broodjes.Ingredient;
import daos.BrodenDao;
import daos.BroodjesDao;
import daos.IngredientenDao;

public class BroodjesMapperTest {
	// Brood
	private static final String testBroodId = "1";
	private static final String testBroodNaam = "Wit";
	private static final double testBroodPrijs = 0.5;
	private static Brood testBrood;

	// Ingredient
	private static final String testIngredientId = "2";
	private static final String testIngredientNaam = "Kaas";
	private static final double testIngredientPrijs = 0.75;
	private static final String testIngredientImageUrl = "testUrl";
	private static Ingredient testIngredient;

	// Broodje
	private static final String testBroodjeId = "3";
	private static final String testBroodjeCreateId = "1";
	private static final String testBroodjeNaam = "testBroodje";
	private static final String testBroodjeNaamUpdate = "testBroodje getest";
	private static final BigDecimal testBroodjePrijs = new BigDecimal(5.25);
	private static Broodje testBroodje;

	// Maps
	private static Map<String, Object> broodMap;
	private static Map<String, Object> ingredientMap;
	private static Map<String, Object> broodjeMap;

	// Beans
	private static BrodenDao brodenDao;
	private static BroodjesDao broodjesDao;
	private static IngredientenDao ingredientenDao;

	private static BroodjesMapper mapper;

	@BeforeClass
	public static void initialize() {
		testBrood = new Brood(testBroodId, testBroodNaam, testBroodPrijs);

		testIngredient = new Ingredient(testIngredientId, testIngredientNaam,
				testIngredientPrijs, testIngredientImageUrl);

		testBroodje = new Broodje(testBroodjeId);
		testBroodje.setNaam(testBroodjeNaam);
		testBroodje.setPrijs(testBroodjePrijs);
		testBroodje.setBrood(testBrood);
		testBroodje.getBasisBeleg().add(testIngredient);

		broodMap = new HashMap<String, Object>();
		broodMap.put(Brood.Field.NAAM.getNaam(), testBroodNaam);
		broodMap.put(Brood.Field.PRIJS.getNaam(), testBroodPrijs);

		ingredientMap = new HashMap<String, Object>();
		ingredientMap.put(Ingredient.Field.NAAM.getNaam(), testIngredientNaam);
		ingredientMap
				.put(Ingredient.Field.PRIJS.getNaam(), testIngredientPrijs);
		ingredientMap.put(Ingredient.Field.IMAGE_URL.getNaam(),
				testIngredientImageUrl);
		List<Map<String, Object>> testBasisBeleg = new ArrayList<Map<String, Object>>();
		testBasisBeleg.add(ingredientMap);

		broodjeMap = new HashMap<String, Object>();
		broodjeMap.put(Broodje.Field.NAAM.getNaam(), testBroodjeNaamUpdate);
		broodjeMap.put(Broodje.Field.PRIJS.getNaam(), testBroodjePrijs);
		broodjeMap.put(Broodje.Field.BROOD.getNaam(), broodMap);
		broodjeMap.put(Broodje.Field.BASISBELEG.getNaam(), testBasisBeleg);

		brodenDao = mock(BrodenDao.class);
		when(brodenDao.getBrood(testBroodNaam)).thenReturn(testBrood);

		broodjesDao = mock(BroodjesDao.class);
		when(broodjesDao.getBroodjes()).thenReturn(new ArrayList<Broodje>());

		ingredientenDao = mock(IngredientenDao.class);
		when(ingredientenDao.getIngredient(testIngredientNaam)).thenReturn(
				testIngredient);

		mapper = new BroodjesMapper(brodenDao, broodjesDao, ingredientenDao);
	}

	@Test
	public void testCreateNewBroodjeFromInputMap() {
		Broodje broodje = mapper.createNewBroodjeFromInputMap(broodjeMap);

		assertNotNull(broodje);
		assertEquals(testBroodjeCreateId, broodje.getId());
		assertEquals(testBroodjeNaamUpdate, broodje.getNaam());
		assertEquals(testBroodjePrijs, broodje.getPrijs());
		assertEquals(testBrood, broodje.getBrood());
		assertEquals(testIngredient, broodje.getBasisBeleg().get(0));
	}

	@Test
	public void testUpdateBroodjeFromInputMap() {
		mapper.updateBroodjeFromInputMap(testBroodje, broodjeMap);

		assertNotNull(testBroodje);
		assertEquals(testBroodjeId, testBroodje.getId());
		assertEquals(testBroodjeNaamUpdate, testBroodje.getNaam());
		assertEquals(testBroodjePrijs, testBroodje.getPrijs());
		assertEquals(testBrood, testBroodje.getBrood());
		assertEquals(testIngredient, testBroodje.getBasisBeleg().get(0));
	}

}

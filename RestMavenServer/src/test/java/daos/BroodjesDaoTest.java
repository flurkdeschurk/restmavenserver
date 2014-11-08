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

import broodjes.Broodje;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BroodjesDaoTest {
	@Autowired
	private BroodjesDao broodjesDao;
	@Autowired
	private BrodenDao brodenDao;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void testGetBroodjes() {
		List<Broodje> broodjes = broodjesDao.getBroodjes();
		assertNotNull(broodjes);
		assertEquals(4, broodjes.size());
		Broodje broodje = broodjes.get(0);

		assertNotNull(broodje);
		assertEquals("Wit", broodje.getBrood().getNaam());
		assertEquals(true,
				broodje.getBrood().equals(brodenDao.getBroden().get(0)));
	}

	@Test
	public void addBroodje() {
		Broodje broodje = new Broodje("5");

		broodjesDao.addBroodje(broodje);

		List<Broodje> broodjes = broodjesDao.getBroodjes();
		assertNotNull(broodjes);
		assertEquals(5, broodjes.size());

		mongoTemplate.remove(broodje);
	}

}

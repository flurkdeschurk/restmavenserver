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

import broodjes.Brood;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BrodenDaoTest {
	@Autowired
	private BrodenDao brodenDao;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void getBroden() {
		List<Brood> broden = brodenDao.getBroden();
		assertNotNull(broden);
		assertEquals(2, broden.size());
	}

	@Test
	public void addBrood() {
		Brood brood = new Brood("3", "Grijs", 0.5);
		brodenDao.addBrood(brood);

		List<Brood> broden = brodenDao.getBroden();
		assertNotNull(broden);
		assertEquals(3, broden.size());

		mongoTemplate.remove(brood);
	}
}

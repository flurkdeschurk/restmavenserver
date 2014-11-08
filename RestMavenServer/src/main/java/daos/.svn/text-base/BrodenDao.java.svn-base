package daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import broodjes.Brood;

@Repository
public class BrodenDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Brood> getBroden() {
		return mongoTemplate.findAll(Brood.class);
	}
	
	public Brood getBrood(String naam) {
		Query query = new Query(Criteria.where("naam").is(naam));
		return mongoTemplate.findOne(query, Brood.class);
	}
	
	public void addBrood(Brood brood) {
		mongoTemplate.insert(brood, "brood");
	}
	
}

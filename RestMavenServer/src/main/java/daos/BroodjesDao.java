package daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import broodjes.Broodje;

@Repository
public class BroodjesDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Broodje> getBroodjes() {
		return mongoTemplate.findAll(Broodje.class);
	}
	
	public Broodje getBroodje(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Broodje.class);
	}
	
	public void addBroodje(Broodje broodje) {
		mongoTemplate.insert(broodje);
	}
	
	public void bewerkBroodje(Broodje broodje) {
		mongoTemplate.save(broodje);
	}
	
	public void deleteBroodje(Broodje broodje) {
		mongoTemplate.remove(broodje);
	}

}

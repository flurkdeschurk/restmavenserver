package daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import broodjes.Ingredient;

@Repository
public class IngredientenDao {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Ingredient> getIngredienten() {
		return mongoTemplate.findAll(Ingredient.class);
	}
	
	public void addIngredient(Ingredient ingredient) {
		mongoTemplate.insert(ingredient);
	}
	
	public Ingredient getIngredient(String naam) {
		Query query = new Query(Criteria.where("naam").is(naam));
		return mongoTemplate.findOne(query, Ingredient.class);
	}

}

package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import broodjes.Brood;
import broodjes.Broodje;
import daos.BrodenDao;
import daos.BroodjesDao;
import daos.IngredientenDao;

@Service
public class BroodjesMapper {
	private BrodenDao brodenDao;
	private BroodjesDao broodjesDao;
	private IngredientenDao ingredientenDao;

	@Autowired
	BroodjesMapper(BrodenDao brodenDao, BroodjesDao broodjesDao,
			IngredientenDao ingredientenDao) {
		super();
		this.brodenDao = brodenDao;
		this.broodjesDao = broodjesDao;
		this.ingredientenDao = ingredientenDao;
	}

	public Broodje createNewBroodjeFromInputMap(Map<String, Object> inputMap) {
		Broodje broodje = new Broodje((broodjesDao.getBroodjes().size() + 1)
				+ "");
		updateBroodjeFromInputMap(broodje, inputMap);
		return broodje;
	}

	@SuppressWarnings("unchecked")
	public void updateBroodjeFromInputMap(Broodje broodje,
			Map<String, Object> inputMap) {
		broodje.setNaam(inputMap.get(Broodje.Field.NAAM.getNaam()).toString());
		broodje.setPrijs(new BigDecimal(inputMap.get(
				Broodje.Field.PRIJS.getNaam()).toString()));
		broodje.setBrood(brodenDao.getBrood(((Map<String, Object>) inputMap
				.get(Broodje.Field.BROOD.getNaam())).get(
				Brood.Field.NAAM.getNaam()).toString()));

		broodje.getBasisBeleg().clear();
		if (inputMap.get(Broodje.Field.BASISBELEG.getNaam()) != null) {
			for (Map<String, Object> inputIngredient : (ArrayList<Map<String, Object>>) inputMap
					.get(Broodje.Field.BASISBELEG.getNaam())) {
				broodje.getBasisBeleg().add(
						ingredientenDao.getIngredient(inputIngredient.get(
								"naam").toString()));
			}
		}
	}

}

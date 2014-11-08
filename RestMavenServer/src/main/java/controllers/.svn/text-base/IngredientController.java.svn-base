package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import broodjes.Ingredient;
import daos.IngredientenDao;

/**
 * Created by Dieter on 26/01/14.
 */
@Controller
@RequestMapping("/ingredienten")
public class IngredientController {
	@Autowired
	private IngredientenDao ingredientenDao;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Ingredient> list() {
		return ingredientenDao.getIngredienten();
	}
}

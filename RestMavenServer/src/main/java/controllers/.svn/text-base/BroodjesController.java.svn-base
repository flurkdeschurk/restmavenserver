package controllers;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import services.BroodjesMapper;
import broodjes.Broodje;
import daos.BroodjesDao;

/**
 * Created by Dieter on 15/01/14.
 */
@Controller
@RequestMapping("/broodjes")
public class BroodjesController {
	@Autowired
	private BroodjesDao broodjesDao;
	
	@Autowired
	private BroodjesMapper broodjesMapper;

	@RequestMapping(method = GET)
	public @ResponseBody
	List<Broodje> broodjes() {
		return broodjesDao.getBroodjes();
	}

	@RequestMapping(method = POST)
	public @ResponseBody
	void createBroodje(@RequestBody Map<String, Object> broodjeInput) {
		Broodje broodje = broodjesMapper.createNewBroodjeFromInputMap(broodjeInput);
		broodjesDao.addBroodje(broodje);
	}

	@RequestMapping(value = "/{id}", method = GET)
	public @ResponseBody
	Broodje broodje(@PathVariable("id") String id) {
		return broodjesDao.getBroodje(id);
	}

	@RequestMapping(value = "/{id}", method = PUT)
	public @ResponseBody
	void updateBroodje(@PathVariable("id") long id,
			@RequestBody Map<String, Object> broodjeInput) {
		Broodje broodje = broodjesDao.getBroodje(broodjeInput
				.get("id").toString());
		broodjesMapper.updateBroodjeFromInputMap(broodje, broodjeInput);
		broodjesDao.bewerkBroodje(broodje);
	}

	@RequestMapping(value = "/{id}", method = DELETE)
	public @ResponseBody
	void deleteBroodje(@PathVariable("id") String id) {
		broodjesDao.deleteBroodje(broodjesDao.getBroodje(id));
	}

}

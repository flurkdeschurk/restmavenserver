package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import broodjes.Brood;
import daos.BrodenDao;

/**
 * Created by Dieter on 26/01/14.
 */
@Controller
@RequestMapping("/broden")
public class BrodenController {
	@Autowired
	private BrodenDao brodenDao;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Brood> list() {
		return brodenDao.getBroden();
	}
}

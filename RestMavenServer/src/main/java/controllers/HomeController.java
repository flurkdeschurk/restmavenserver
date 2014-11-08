package controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String index(HttpServletResponse response) throws IOException {
		return "index";
	}

	@RequestMapping(value = "/home")
	public String home(HttpServletResponse response) throws IOException {
		return "home";
	}

	@RequestMapping(value = "/list")
	public String list(HttpServletResponse response) throws IOException {
		return "list";
	}

	@RequestMapping(value = "/editNew")
	public String editNew(HttpServletResponse response) throws IOException {
		return "editNew";
	}

	@RequestMapping(value = "/detail")
	public String detail(HttpServletResponse response) throws IOException {
		return "detail";
	}

	@RequestMapping(value = "/compose")
	public String compose(HttpServletResponse response) throws IOException {
		return "compose";
	}
}

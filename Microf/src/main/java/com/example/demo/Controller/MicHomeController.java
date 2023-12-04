package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicHomeController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/michome", method = RequestMethod.GET)
	public String copGet(Model model) {

		List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT * FROM todo");
		model.addAttribute("resultList", resultList);

		return "michome";
	}

	@RequestMapping(path = "/michome", method = RequestMethod.POST)
	public String copPost(String example1, String example2, Model model) {

		List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT * FROM todo");
		model.addAttribute("resultList", resultList);

		model.addAttribute("example1", example1);
		model.addAttribute("example2", example2);

		return "example";
	}

	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String micAdd() {

		return "micadd";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String micEdit() {

		return "micedit";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String micDelete() {

		return "micdel";
	}
}

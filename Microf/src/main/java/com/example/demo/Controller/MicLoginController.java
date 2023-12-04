package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicLoginController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/miclogin", method = RequestMethod.GET)
	public String miclogin(Model model) {
		return "miclogin";
	}

	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String login(String micloginid, String micpw, Model model) throws IOException {

		List<Map<String, Object>> aList;
		aList = jdbcTemplate.queryForList("select * from miclogin where loginid = ? AND password = ?", micloginid,
				micpw);

		int x = aList.size();

		if (x >= 1) {
			return "redirect:/michome";
		} else {
			return "miclogin";
		}

	}
}
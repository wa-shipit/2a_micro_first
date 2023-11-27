package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicUserController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/micuser", method = RequestMethod.GET)
	public String login() {
		return "micuser";
	}

	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String login(String micloginid, String micpw, Model model) {

		if (micloginid.length() > 10 || micpw.length() > 10) {
			String msg = "文字数が多すぎます";
			model.addAttribute("moji", msg);
			return "micuser";
		} else {
			jdbcTemplate.update("INSERT INTO miclogin VALUES (?, ?);",
					micloginid, micpw);
			return "redirect:/miclogin";
		}
	}
}

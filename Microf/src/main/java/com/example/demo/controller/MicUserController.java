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
	public String copGet() {
		return "micuser";
	}

	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String postIns(String loginid, String password, Model model) {

		if (password.length() <= 10 && loginid.length() <= 10) {
			jdbcTemplate.update("INSERT INTO miclogin VALUES (?,?);", loginid, password);
		} else {
			model.addAttribute("msg", "10文字以下にしてください!!!!!!!!!!");
		}

		model.addAttribute("loginid", loginid);
		model.addAttribute("password", password);

		return "micuser";
	}

}
package com.example.demo.controller;

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
	public String Get(Model model) {

		List<Map<String, Object>> todoList;

		todoList = jdbcTemplate.queryForList("SELECT * FROM todo");

		model.addAttribute("Result", todoList);

		return "michome";
	}

	@RequestMapping(path = "/michome", method = RequestMethod.POST)
	public String Post(Model model) {

		return "michome";
	}
}

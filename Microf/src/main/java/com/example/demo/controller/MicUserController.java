package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/micuser")
public class MicUserController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping
	public String showForm() {
		return "micuser";
	}

	@PostMapping
	public String submitForm(@RequestParam String userId, @RequestParam String password, Model model) {
		String sql = "INSERT INTO miclogin (loginid, password) VALUES (?, ?)";
		jdbcTemplate.update(sql, userId, password);

		return "redirect:/miclogin";
	}
}

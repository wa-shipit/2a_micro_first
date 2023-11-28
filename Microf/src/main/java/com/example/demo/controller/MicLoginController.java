package com.example.demo.controller;

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
	public String loginGet() {
		return "miclogin";
	}
	
	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String loginPost(Model model,String micloginid,String micpw) {
		int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM miclogin WHERE loginid = ? AND password = ?", Integer.class, micloginid,micpw);
		if(count == 1) {
			return "redirect:/michome";
		} else {
			model.addAttribute("loginerror", 1);
			return "redirect:/miclogin";
		}
		
	}
}

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
	public String micsinki() {
		return "micuser";
	}

	//INSERT（登録）用メソッド
	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String micsinki(String micloginid, String micpw, String false1,Model model) {

		if(micloginid.length() <= 10 && micpw.length() <= 10) {
			jdbcTemplate.update("INSERT INTO miclogin VALUES (?,?);", micloginid, micpw);
		}else {
			model.addAttribute("false1", "文字数が多すぎます");
			return "micuser";
		}
		return "redirect:/miclogin";
	}
}

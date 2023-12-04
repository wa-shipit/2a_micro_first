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

	//コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/micuser", method = RequestMethod.GET)
	public String parameter1() {
		return "micuser";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String copPost(String parameter1, String parameter2, Model model) {

		//DBに繋ぐならこんな感じ(JdbcTemplate)

		jdbcTemplate.update("INSERT INTO miclogin (loginid,password) VALUES(?,?)", parameter1, parameter2);

		return "redirect:/micuser";
	}
}
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
	public String loginGet() {

		return "micuser";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String loginPost(String micid, String micpw, Model model) {

		String sql = "INSERT INTO miclogin (loginid, password) VALUES (?, ?)";
		jdbcTemplate.update(sql, micid, micpw);

		return "micuser";
	}

}

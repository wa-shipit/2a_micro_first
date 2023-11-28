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
public class MicLoginController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/miclogin", method = RequestMethod.GET)
	public String loginGet() {

		return "miclogin";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String loginPost(String micloginid, String micpw, Model model) {

		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(
				"SELECT * FROM miclogin WHERE loginid = ? AND password = ?",
				micloginid, micpw);

		for (int i = 0; i < 100; i++) {
			System.out.println(resultList);
		}

		if (resultList.size() == 1) {

			return "redirect:/michome";
		} else {

			model.addAttribute("era", "ログインに失敗しました");
			return "miclogin";

		}
	}
}

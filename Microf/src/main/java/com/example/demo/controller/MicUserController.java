package com.example.demo.controller;

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
public class MicUserController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	//コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/micuser", method = RequestMethod.GET)
	public String copGet() {
		return "micuser";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String micuser(String micloginid, String micpw, Model model) throws IOException {

		List<Map<String, Object>> resultList = jdbcTemplate
				.queryForList("SELECT * FROM miclogin WHERE loginid = ? AND password = ?", micloginid, micpw);
		//検索結果の件数を取得
		int count = resultList.size();

		if (count == 0) {
			if (micloginid.length() <= 10 && micpw.length() <= 10) {
				jdbcTemplate.update("INSERT INTO miclogin VALUES(?,?)", micloginid, micpw);
				return "miclogin";
			} else {
				return "micuser";
			}
		}
		return "micuser";
	}
}

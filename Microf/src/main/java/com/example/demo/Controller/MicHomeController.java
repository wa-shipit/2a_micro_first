package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MicHomeController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	//コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/michome", method = RequestMethod.GET)
	public String copGet() {
		return "michome";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/michome", method = RequestMethod.POST)
	public String copPost(Model model) {

		//SELECT文発行(月)
		List<Map<String, Object>> result = jdbcTemplate
				.queryForList("SELECT * FROM todo");

		model.addAttribute("result", result);

		return "michome";
	}
}
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

	//コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/michome", method = RequestMethod.GET)
	public String copGet(Model model) {

		List<Map<String, Object>> todoList = jdbcTemplate.queryForList("SELECT * FROM todo");

		model.addAttribute("List", todoList);

		return "michome";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/michome", method = RequestMethod.POST)
	public String copPost(String michome1, String michome2, Model model) {

		model.addAttribute("michome1", michome1);
		model.addAttribute("michome2", michome2);

		return "michome";
	}
}

package com.example.demo.Controller;

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
	public String showMicHomePage(Model model) {

		List<Map<String, Object>> resultList = jdbcTemplate.queryForList("SELECT month,day,todo FROM todo;");
		model.addAttribute("yotei", resultList);

		return "michome";
	}

	@RequestMapping(path = "/michome", method = RequestMethod.POST)
	public String copPost() {

		return "michome";
	}
}

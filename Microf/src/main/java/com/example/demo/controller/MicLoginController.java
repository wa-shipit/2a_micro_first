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
	
	@RequestMapping(path = "/miclogin", method = RequestMethod.GET)
	public String login() {
		return "miclogin";
	}
	
	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String login(String micloginid,String micpw,Model model) {
	
		if(micloginid.length() > 16 || micpw.length() > 16) {
			String msg = "文字数が多すぎます";
			model.addAttribute("moji", msg);
			return "miclogin";
		}else {
			List<Map<String, Object>> resultList;
			resultList = jdbcTemplate.queryForList("select * from miclogin where loginid = ? and password = ?",micloginid,micpw);

			if(resultList.isEmpty()) {
				String msg = "ログインに失敗しました";
				model.addAttribute("moji", msg);
				return "miclogin";
			}else {
				return "redirect:/michome";
			}
		}		
	}
}

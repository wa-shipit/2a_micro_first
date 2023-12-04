package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class MicLoginController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/miclogin", method = RequestMethod.GET)
	public String showLoginForm() {
		return "miclogin";
	}

	@RequestMapping(path = "/miclogin", method = RequestMethod.POST)
	public String processLogin(String micloginid, String micpw, Model model, HttpSession session) {

		List<Map<String, Object>> userList;
		userList = jdbcTemplate.queryForList("select * from miclogin where loginid = ? and password = ?", micloginid,
				micpw);

		if (!userList.isEmpty() && userList.get(0).get("loginid").equals(micloginid)
				&& userList.get(0).get("password").equals(micpw)) {
			session.setAttribute("loginparam1", micloginid);
			session.setAttribute("loginparam2", micpw);
			return "redirect:/michome";
		} else {
			model.addAttribute("message", "ログインに失敗しました");
			return "miclogin";
		}
	}
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicUserController {

	@Autowired
	JdbcTemplate jdbctemplate;

	@RequestMapping(path = "/micuser", method = RequestMethod.GET)
	public String user() {
		return "micuser";

	}

	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(path = "/micuser", method = RequestMethod.POST)
	public String user(String ID, String PASS) {

		if (jdbctemplate.equals("SELECT miclogin FROM springdb WHERE NAME VALUES == ID, PASS")) {

			//同じ名前がある場合
			return "micuser2";//分岐する

		} else {

			jdbctemplate.update("INSERT INTO miclogin VALUES(?, ?);", ID, PASS);

			//同じ名前がないとき
			return "micuser";//登録完了

		}

	}
}

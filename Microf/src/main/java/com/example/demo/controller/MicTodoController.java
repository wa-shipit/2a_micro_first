package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicTodoController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//コピペ用サンプル(ページ表示用メソッド)
	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String addGet() {
		return "MicTodoadd";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String addPost(String month, String day, String schedule) {
		jdbcTemplate.update("INSERT INTO todo VALUES(?,?,?,?);", "00", month, day, schedule);
		return "MicTodoadd";

		//コピペ用サンプル(ページ表示用メソッド)
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String editGet() {
		return "MicTodoedit";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String editPost(String month, String day, String schedule) {
		jdbcTemplate.update("UPDATE todo SET month = ?, day = ?, todo = ? WHERE month = ? AND day = ? ;", month,
				day, schedule, month, day);
		return "MicTodoedit";

		//コピペ用サンプル(ページ表示用メソッド)
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String delGet() {
		return "MicTododel";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String delPost(String month, String day) {
		jdbcTemplate.update("DELETE FROM todo WHERE month = ? AND day = ?", month, day);
		return "MicTododel";

		//コピペ用サンプル(ページ表示用メソッド)

	}

}

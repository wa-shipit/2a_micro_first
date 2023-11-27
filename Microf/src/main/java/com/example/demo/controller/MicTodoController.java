package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MicTodoController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String micadd() {
		return "micadd";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String micedit() {
		return "micedit";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String micdel() {
		return "micdel";
	}

	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String fourthp(String user_id, String month, String day, String todo, Model model) {

		jdbcTemplate.update("INSERT INTO todo (user_id,month,day,todo) VALUES(?,?,?,?);", user_id,
				month, day, todo);

		return "redirect:/michome";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String tenthPostUpdate(String user_id, String month, String day, String todo,
			Model model) throws IOException {

		//データ更新SQL実行
		jdbcTemplate.update("UPDATE todo SET month=?, day=?, todo=? WHERE user_id=?;", month, day, todo, user_id);

		return "redirect:/michome";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String tenthPostDelete(String day) throws IOException {

		//データ削除SQL実行
		jdbcTemplate.update("DELETE FROM todo WHERE day = ?", day);

		return "redirect:/michome";
	}
}
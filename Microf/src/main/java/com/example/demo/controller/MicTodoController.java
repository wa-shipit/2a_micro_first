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
public class MicTodoController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	//新規登録
	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String add() {
		return "micadd";
	}

	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String add(String month, String day, String todo,Model model) {

		List<Map<String, Object>> resultList;
		resultList = jdbcTemplate.queryForList("SELECT * FROM todo WHERE month = ? AND day = ?",month,day);
		
		if(resultList.isEmpty()) {
			jdbcTemplate.update("INSERT INTO todo(user_id,month,day,todo) VALUES(999999,?,?,?)",month,day,todo);
			return "redirect:/michome";
		}else {
			String msg = "既に登録されています";
			model.addAttribute("moji", msg);
			return "micadd";
		}
	}
	
	//編集
	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String edit() {
		return "micedit";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String edit(String month, String day, String todo) {
		jdbcTemplate.update("UPDATE todo SET todo = ? WHERE month = ? AND day = ?;",todo,month,day);
		return "redirect:/michome";
	}
	
	//削除
	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String del() {
		return "micdel";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String del(String month, String day) {
		jdbcTemplate.update("DELETE FROM todo WHERE month = ? AND day = ?",month,day);
		return "redirect:/michome";
	}
}
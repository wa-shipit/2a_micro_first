package com.example.demo.controller;

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

	//新規登録画面
	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String tourokuGet() {

		return "mictodoadd";
	}

	//新規登録画面（画面から何か入力をした時用）
	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String tourokuPost(String micmonth, String micday, String todo, Model model) {

		String sql = "INSERT INTO todo (user_id,month,day,todo) VALUES (9999,?, ?, ?)";
		jdbcTemplate.update(sql, micmonth, micday, todo);

		return "mictodoadd";
	}

	//編集画面
	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String editGet() {

		return "mictodoedit";
	}

	//編集画面（画面から何か入力をした時用）
	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String editPost(String micmonth, String micday, String todo, Model model) {

		/*		List<Map<String, Object>> irukana = jdbcTemplate.queryForList(
						"SELECT todo FROM todo WHERE todo = ?",
						todo);
		*/
		String sql = "UPDATE todo SET month=?, day=? WHERE todo = ?";
		jdbcTemplate.update(sql, micmonth, micday, todo);

		return "mictodoedit";
	}

	//削除画面
	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String deleteGet() {

		return "mictododelete";
	}

	//削除画面（画面から何か入力をした時用）
	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String deletePost(String micmonth, String micday, String todo, Model model) {

		/*		List<Map<String, Object>> irukana = jdbcTemplate.queryForList(
						"SELECT todo FROM todo WHERE todo = ?",
						todo);
		*/
		String sql = "delete from todo where month = ? and day = ?";
		jdbcTemplate.update(sql, micmonth, micday);

		return "mictododelete";
	}

}

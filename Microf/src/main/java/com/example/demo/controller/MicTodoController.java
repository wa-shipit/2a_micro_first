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

	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String in1( Model model) {
		return "mictodoin";
	}
	
	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String in2(String month, String day, String todo, Model model) {
		// ユーザIDを固定値として設定
		String userId = "999999";

		// 既存の予定が存在するか確認
	    if (isPlanExist(month, day)) {
	        String errorMessage = "同じ日には予定を1つしか登録できません。";
	        model.addAttribute("errorMessage", errorMessage);
	        return "mictodoin";
	    }

		String insertSql = "INSERT INTO todo (user_id, month, day, todo) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(insertSql, userId, month, day, todo);

		return "mictodoin";
	}

	// 既存の予定が存在するか確認するメソッド
	private boolean isPlanExist(String month, String day) {
		String selectSql = "SELECT COUNT(*) FROM todo WHERE month = ? AND day = ?";
		int count = jdbcTemplate.queryForObject(selectSql, Integer.class, month, day);
		return count > 0;
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String ed1(Model model) {
		return "mictododit";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String ed2(String month, String day, String todo, Model model) {
		String updateSql = "UPDATE todo SET todo = ? WHERE month = ? AND day = ?";
		jdbcTemplate.update(updateSql, todo, month, day);

		return "mictododit";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String del1(Model model) {

		return "mictododel";
	}

	@RequestMapping(path="/micedel",method=RequestMethod.POST)
	private String del2(String month, String day, String todo, Model model) {
		// データベースから削除するためのSQL文を作成
		String deleteSql = "DELETE FROM todo WHERE month = ? AND day = ? AND todo = ?";

		// SQLを実行して対象のTodoを削除
		jdbcTemplate.update(deleteSql, month, day, todo);

		return "mictododel";
	}
}

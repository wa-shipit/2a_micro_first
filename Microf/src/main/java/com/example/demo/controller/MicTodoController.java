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

	int firstId = 999999;

	@RequestMapping(path = "/micadd", method = RequestMethod.GET)
	public String micaddGet() {
		return "mictodoadd";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String miceditGet() {
		return "mictodoedit";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String micdelGet() {
		return "mictododel";
	}

	//コピペ用サンプル（画面から何か入力をした時用）
	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String micadd(String user_id, String month, String day, String todo, Model model) {

		//		if ((0 < month && month <= 12) || (0 < day && day <= 31)) {
		//			return "mictodoadd";
		//		}

		//DBに画面から入力されたデータを登録する。
		jdbcTemplate.update(
				"INSERT INTO todo (user_id,month,day,todo) VALUES('999999',?,?,?);", month, day, todo);

		return "mictodoadd";

	}

	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String micedit(String user_id, String month, String day, String todo) {

		//if ((0 < month && month <= 12) || (0 < day && day <= 31)) {
		//	return "mictodoedit";
		//}

		//DBに画面から入力されたデータを更新する。
		jdbcTemplate.update("UPDATE todo (month,day,todo values(?,?,?) where month = ? and day = ?;",
				month, day, todo, month, day);

		return "mictodoedit";

	}

	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String micdel(String user_id, String month, String day, String todo) {

		//if ((0 < month && month <= 12) || (0 < day && day <= 31)) {
		//	return "mictododel";
		//}

		//DBに画面から入力されたデータを削除する。
		jdbcTemplate.update("delete from todo where month = ? AND day = ?", month, day);

		return "mictododel";

	}
}

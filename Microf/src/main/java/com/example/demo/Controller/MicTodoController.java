package com.example.demo.Controller;

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
	public String tourokuGet() {

		return "micadd";
	}

	@RequestMapping(path = "/micadd", method = RequestMethod.POST)
	public String tourokuPost(String micmonth, String micday, String todo, Model model) {

		String sql = "INSERT INTO todo (user_id,month,day,todo) VALUES (9999,?, ?, ?)";
		jdbcTemplate.update(sql, micmonth, micday, todo);

		return "micadd";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.GET)
	public String editGet() {

		return "micedit";
	}

	@RequestMapping(path = "/micedit", method = RequestMethod.POST)
	public String editPost(String micmonth, String micday, String todo, Model model) {

		String sql = "UPDATE todo SET month=?, day=? WHERE todo = ?";
		jdbcTemplate.update(sql, micmonth, micday, todo);

		return "micedit";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.GET)
	public String deleteGet() {

		return "micdel";
	}

	@RequestMapping(path = "/micdel", method = RequestMethod.POST)
	public String deletePost(String micmonth, String micday, String todo, Model model) {

		String sql = "delete from todo where month = ? and day = ?";
		jdbcTemplate.update(sql, micmonth, micday);

		return "micdel";
	}

}
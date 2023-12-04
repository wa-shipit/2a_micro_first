package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.MicAddDao;
import com.example.demo.entity.Todo;

public class MicAddService {
	public void addTodo(String userid, String tododate, String todotext, JdbcTemplate jdbcTemplate) {
		String[] day = tododate.split("-");
		Todo todo = new Todo(0, userid, day[1], day[2], todotext);
		MicAddDao micAddDao = new MicAddDao();
		micAddDao.insertTodo(todo, jdbcTemplate);
	}
}

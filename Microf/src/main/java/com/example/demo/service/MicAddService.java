package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.MicAddDao;
import com.example.demo.entity.ToDo;

public class MicAddService {
	public void addTodo(String userid, String tododate, String todotext, JdbcTemplate jdbcTemplate) {
		String[] day = tododate.split("-");
		ToDo todo = new ToDo(Long.valueOf(0), userid, day[1], day[2], todotext);
		MicAddDao micAddDao = new MicAddDao();
		micAddDao.insertTodo(todo, jdbcTemplate);
	}
}

package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.MicEditDao;

public class MicEditService {
	public void updateTodo(String id, String month, String day, String todo, JdbcTemplate jdbcTemplate) {
		MicEditDao micEditDao = new MicEditDao();
		micEditDao.updateTodo(id, month, day, todo, jdbcTemplate);
	}
}

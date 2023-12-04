package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MicEditDao {
	public void updateTodo(String id, String month, String day, String todo, JdbcTemplate jdbcTemplate) {
		System.out.println(id);
		String sql = "UPDATE todo SET month = ?, day = ?, todo = ? WHERE id = ?";
		jdbcTemplate.update(sql, month, day, todo, id);
	}
}

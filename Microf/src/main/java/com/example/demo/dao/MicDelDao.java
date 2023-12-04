package com.example.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class MicDelDao {
	public void delexecute(String id, JdbcTemplate jdbcTemplate) {
		String sql = "DELETE FROM todo WHERE id = ?";
		jdbcTemplate.update(sql, id);
		;

	}
}

package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class UtilityDao {
	public List getAllTodo(JdbcTemplate jdbcTemplate) {
		String sql = "SELECT * FROM todo";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		return resultList;
	}

	public Map getOneTodo(String id, JdbcTemplate jdbcTemplate) {
		String sql = "SELECT * FROM todo WHERE id = ?";
		Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, id);
		return resultMap;
	}
}

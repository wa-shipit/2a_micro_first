package com.example.demo.dao;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.entity.Todo;

public class MicAddDao {
	public void insertTodo(Todo todo, JdbcTemplate jdbcTemplate) {
		String sql = "INSERT INTO `todo` VALUES(?,?,?,?,?);";
		Map<String, Object> maxid = jdbcTemplate.queryForMap("SELECT max(id)+1 as a from todo");
		System.out.println(maxid.get("a"));
		jdbcTemplate.update(sql, maxid.get("a"), todo.getUser_id(), todo.getMonth(), todo.getDay(), todo.getTodo());

	}
}

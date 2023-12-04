package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.UtilityDao;
import com.example.demo.entity.ToDo;

public class UtilityService {
	public List getAllTodoList(JdbcTemplate jdbcTemplate) {
		UtilityDao utilityDao = new UtilityDao();
		List<Map<String, Object>> resultList = utilityDao.getAllTodo(jdbcTemplate);

		//Listに詰め替える
		List<ToDo> TodoList = new ArrayList<>();

		for (Map<String, Object> value : resultList) {
			ToDo todo = new ToDo(Long.valueOf((int) value.get("id")), (String) value.get("user_id"),
					(String) value.get("month"),
					(String) value.get("day"), (String) value.get("todo"));
			TodoList.add(todo);
		}
		return TodoList;
	}

	public ToDo getOneTodo(String id, JdbcTemplate jdbcTemplate) {
		UtilityDao utilityDao = new UtilityDao();
		Map<String, Object> resultMap = utilityDao.getOneTodo(id, jdbcTemplate);
		ToDo todo = new ToDo(Long.valueOf((int) resultMap.get("id")), (String) resultMap.get("user_id"),
				(String) resultMap.get("month"),
				(String) resultMap.get("day"), (String) resultMap.get("todo"));
		return todo;

	}
}

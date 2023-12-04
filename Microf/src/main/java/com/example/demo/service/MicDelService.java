package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.dao.MicDelDao;

public class MicDelService {

	public void deltodo(String id, JdbcTemplate jdbcTemplate) {
		MicDelDao micDelDao = new MicDelDao();
		micDelDao.delexecute(id, jdbcTemplate);
	}
}

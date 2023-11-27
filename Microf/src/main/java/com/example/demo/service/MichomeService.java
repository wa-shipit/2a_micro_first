package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.MichomeRepository;

@Service
public class MichomeService {

	@Autowired
	private MichomeRepository michomeRepository;

	public List<ToDo> getAllTodos() {
		return michomeRepository.findAll();
	}

}

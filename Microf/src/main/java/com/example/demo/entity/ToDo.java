package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String userId;
	String month;
	String day;
	String todo;

	// Getter and Setter methods

	public ToDo() {
	}

	public ToDo(Long i, String userId, String month, String day, String todo) {
		super();
		this.id = i;
		this.userId = userId;
		this.month = month;
		this.day = day;
		this.todo = todo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
}

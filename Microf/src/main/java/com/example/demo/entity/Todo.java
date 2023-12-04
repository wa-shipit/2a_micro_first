package com.example.demo.entity;

public class Todo {
	private int id;
	private String user_id;
	private String month;
	private String day;
	private String todo;

	public Todo(int id, String user_id, String month, String day, String todo) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.month = month;
		this.day = day;
		this.todo = todo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

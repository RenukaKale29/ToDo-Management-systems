package com.ToDo_Man_Sys.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MyTodos")
public class MyTodoList {
	@Id
	@Column(name="Todo_id")
	private int id;
	private String subject;
	private String description;
	private String duedate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public MyTodoList(int id, String subject, String description, String duedate) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.duedate = duedate;
	}
	public MyTodoList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package com.ToDo_Man_Sys.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDo_Man_Sys.Entities.MyTodoList;
import com.ToDo_Man_Sys.Repositroy.MyTodoRepository;


@Service
public class MyTodoListService {
	@Autowired
	private MyTodoRepository mytodo;
	
	public void saveMyTodos(MyTodoList todo) {
		mytodo.save(todo);
	}
	
	public List<MyTodoList> getAllMyTodos(){
		return mytodo.findAll();
	}
	
	public void deleteById(int id) {
		mytodo.deleteById(id);
	}
}
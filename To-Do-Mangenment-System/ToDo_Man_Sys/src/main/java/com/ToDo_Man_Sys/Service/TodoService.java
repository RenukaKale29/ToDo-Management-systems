package com.ToDo_Man_Sys.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ToDo_Man_Sys.Entities.ToDo;
import com.ToDo_Man_Sys.Repositroy.TodoRepository;
@Service
public class TodoService {
	@Autowired
	private TodoRepository tRepo;
	
	public void save(ToDo t) {
		tRepo.save(t);
	}
	
	public List<ToDo> getAllTodo(){
		return tRepo.findAll();
	}
	
	public ToDo getTodoById(int id) {
		return tRepo.findById(id).get();
	}
	public void deleteById(int id) {
		tRepo.deleteById(id);
	}

	
		
	}


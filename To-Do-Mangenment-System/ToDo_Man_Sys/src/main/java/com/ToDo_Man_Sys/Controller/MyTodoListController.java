package com.ToDo_Man_Sys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ToDo_Man_Sys.Service.MyTodoListService;

@Controller
public class MyTodoListController {
	@Autowired
	private MyTodoListService service;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/my_todos";
	}
}

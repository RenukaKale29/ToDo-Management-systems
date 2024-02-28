package com.ToDo_Man_Sys.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ToDo_Man_Sys.Entities.ContactForm;
import com.ToDo_Man_Sys.Entities.MyTodoList;
import com.ToDo_Man_Sys.Entities.ToDo;
import com.ToDo_Man_Sys.Service.ContactService;
import com.ToDo_Man_Sys.Service.MyTodoListService;
import com.ToDo_Man_Sys.Service.TodoService;

@Controller
public class ToDoController {
	@Autowired
	private TodoService service;
	
	@Autowired
	private MyTodoListService myTodoService;
	@Autowired
	private ContactService contactService;
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@GetMapping("/todo_register")
	public String bookRegister() {
		return "todoRegister";
	}
	
	@GetMapping("/available_todos")
	public ModelAndView getAllTodo() {
		List<ToDo> list=service.getAllTodo();		
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("todoList","todo",list);
	}
	
	@PostMapping("/save")
	public String addTodo(@ModelAttribute ToDo b) {
		service.save(b);
		return "redirect:/available_todos";
	}
	
	@GetMapping("/my_todos")
	public String getMyTodos(Model model)
	{
		List<MyTodoList>list=myTodoService.getAllMyTodos();
		model.addAttribute("todo",list);
		return "mytodo";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		ToDo b=service.getTodoById(id);
		MyTodoList mb=new MyTodoList(b.getId(),b.getSubject(),b.getDescription(),b.getDuedate());
		myTodoService.saveMyTodos(mb);
		return "redirect:/my_todos";
	}
	
	@RequestMapping("/editTodo/{id}")
	public String editTodo(@PathVariable("id") int id,Model model) {
		ToDo b=service.getTodoById(id);
		model.addAttribute("todo",b);
		return "todoedit";
	}
	@RequestMapping("/deleteTodo/{id}")
	public String deleteTodo(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_todos";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@PostMapping("/submitContactForm")
    public String submitContactForm(@ModelAttribute ContactForm contactForm , Model model) {
        ContactForm contactFormData = new ContactForm();
        contactFormData.setName(contactForm.getName());
        contactFormData.setEmail(contactForm.getEmail());
        contactFormData.setMessage(contactForm.getMessage());
        contactService.save(contactForm);

        // You can also retrieve the saved data if needed
        // List<ContactFormData> allContactFormData = contactFormDataRepository.findAll();
        // model.addAttribute("contactFormDataList", allContactFormData);

        return "index"; // Redirect to a thank you page
    }
}


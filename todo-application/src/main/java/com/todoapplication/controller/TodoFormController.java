package com.todoapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todoapplication.model.TodoItem;
import com.todoapplication.repository.TodoItemRepo;

@Controller
public class TodoFormController {

	
	private final Logger logger = LoggerFactory.getLogger(TodoFormController.class);
	
	@Autowired
	private TodoItemRepo itemRepo;
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		logger.debug("Search todo item");
		TodoItem todoItem=itemRepo
				.findById(id)
				.orElseThrow( ()-> new IllegalArgumentException("To Do Item does id"+id+" not found"));
		model.addAttribute("todo", todoItem);
       return "update-to-do-item";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletetodo(@PathVariable("id") long id) {
		itemRepo
				.findById(id)
				.orElseThrow( ()-> new IllegalArgumentException("To Do Item does id"+id+" not found"));
		     itemRepo.deleteById(id);
		     return "redirect:/";
		
	}
	
	@GetMapping("/addToDo")
	public String showFormToaddToDo(TodoItem item, Model model) {
		model.addAttribute("todo", item);
		return "addToDo";
	}
}

package com.todoapplication.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.todoapplication.model.TodoItem;
import com.todoapplication.repository.TodoItemRepo;
import com.todoapplication.service.TodoService;

@Controller
public class ToDoController {


	private final Logger logger = LoggerFactory.getLogger(ToDoController.class);
	
	@Autowired
	private TodoItemRepo itemRepo;
	@Autowired
	private TodoService service;
	
	@GetMapping("/")
	public ModelAndView index(@Valid TodoItem item) {
		logger.debug("request to get index");
		
		ModelAndView modelAndView= new ModelAndView("index");
//		//for date
		Date date = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
	       String str = formatter.format(date);
		item.setDate(str);
		
	    
	    
		
		//for time
		
		DateFormat t = new SimpleDateFormat("hh:mm:ss a");
       String time = t.format(new Date());
		item.setClock(time);
		
		modelAndView.addObject("TodoItems", itemRepo.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek());
        modelAndView.addObject("time",item);
        modelAndView.addObject("Date",item);
		return modelAndView;
	}
	
	@PostMapping("/todo/{id}")
	public String updateTodoItem(@PathVariable("id") long id, @Valid TodoItem item, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			item.setId(id);
			return "update-to-do-item";
		}
		item.setModifiedDate(Instant.now());
		itemRepo.save(item);
		return "redirect:/";
		
	}
	
	@PostMapping("/todo")
	public String addToDo(@Valid TodoItem item,  Model model, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "addToDo";
		}
		item.setCreatedDate(Instant.now());
		item.setModifiedDate(Instant.now());
		itemRepo.save(item);
		return "redirect:/";
	}
}

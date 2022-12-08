package com.todoapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.todoapplication.model.TodoItem;
import com.todoapplication.repository.TodoItemRepo;

@Component
public class TodoItemConfig implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(TodoItemConfig.class);
	
	@Autowired
	TodoItemRepo itemRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//loadData();
		
	}


//	private void loadData() {
//		// TODO Auto-generated method stub
//		if(itemRepo.count()==0) {
//			TodoItem item= new TodoItem("get the milk");
//			TodoItem item2= new TodoItem("rank the milk");
//			itemRepo.save(item);
//			itemRepo.save(item2);
//		}
//		logger.info("Number of todoItemes: {}",itemRepo.count());
//	}
	

}

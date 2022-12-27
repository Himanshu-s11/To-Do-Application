package com.todoapplication.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.todoapplication.model.TodoItem;
import com.todoapplication.repository.TodoItemRepo;

@Service

public class TodoService {

	@Autowired
	private TodoItemRepo itemRepo;

	
//	public void time() {
//		Thread t= new Thread() {
//			public void run() {	
//			try {
//				while(true) {
//			TodoItem item= new TodoItem();
//			DateFormat t = new SimpleDateFormat("hh:mm:ss a");
//	        String time = t.format(new Date());
//			item.setClock(time);
//		       System.out.println(item.getClock());
//				Thread.sleep(1000);
//			}} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				
//			}
//	};
//	t.start();
//	}
	
	@Scheduled(cron = "0/5 * * * * *")
	public void time() {
		TodoItem item= new TodoItem();
	DateFormat t = new SimpleDateFormat("hh:mm:ss a");
        String time = t.format(new Date());
		item.setClock(time);
		System.out.println(item.getClock());
		itemRepo.save(item);
	}

}

package com.todoapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.todoapplication.model.TodoItem;

public interface TodoItemRepo extends CrudRepository<TodoItem, Long> {
   
}

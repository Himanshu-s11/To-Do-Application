package com.todoapplication.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor

@Entity
@Table(name = "todoList")
public class TodoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//@NotBlank(message = "Description is required")
	//@Size(min = 10, max = 500, message = "at least there should be 10-500 word task")
	private String description;
	private boolean complete;
	private Instant createdDate;
	private Instant modifiedDate;
	private String clock;
	private String date;

	public TodoItem(String description, String clock ,String date) {
		this.description=description;
		this.complete=false;
		this.createdDate=Instant.now();
		this.modifiedDate=Instant.now();
		this.clock=clock;
		this.date=date;
	}
	
	

	@Override
	public String toString() {
		return "TodoItem [id=" + id + ", description=" + description + ", complete=" + complete + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + ", clock=" + clock +", date=" + date +"]";
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isComplete() {
		return complete;
	}



	public void setComplete(boolean complete) {
		this.complete = complete;
	}



	public Instant getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}



	public Instant getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(Instant modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



	public String getClock() {
		return clock;
	}



	public void setClock(String clock) {
		this.clock = clock;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	
	
}

package com.dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table (name = "book")
public class Book2 {

	@Id
	@Column (name = "id")
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	@Column (name = "title")
	private String title;

	@Column (name = "isbn")
	private int isbn;

	@Column (name = "description")
	private String description;


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	
	
}

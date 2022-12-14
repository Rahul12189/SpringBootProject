package com.mybootproject.playground.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/* JPA: Java Persistence API  */
import javax.persistence.Table;

@Entity  //<-- this will tell hibernate to create a table 
@Table(name = "categories") //<-- optional
public class Category {

	@Id //<-- this marked id as primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //<-- auto_increment
	private Long id; 
	
	@Column(nullable = false, length = 99)
	private String name; 
	
	@Column(nullable = false)
	private Integer pref;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPref() {
		return pref;
	}

	public void setPref(Integer pref) {
		this.pref = pref;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String name, Integer pref) {
		super();
		this.id = id;
		this.name = name;
		this.pref = pref;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", pref=" + pref + "]";
	} 
	
	
}

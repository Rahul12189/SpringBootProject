package com.mybootproject.playground.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mybootproject.playground.model.Category;
public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query("select c from Category c where c.pref=?1")
	List<Category> getByPref(Integer pref);

}
/*
Native Query: we write this on DB tables
[select * from category c where c.pref=1]
JPQL: we write this on Entity classes
[select c from Category c where c.pref=1]

?1: first arg of method 
*/
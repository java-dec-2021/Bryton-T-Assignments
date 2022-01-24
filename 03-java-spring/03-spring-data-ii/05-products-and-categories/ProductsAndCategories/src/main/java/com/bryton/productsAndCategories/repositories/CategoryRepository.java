package com.bryton.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bryton.productsAndCategories.models.Category;

public interface CategoryRepository extends CrudRepository <Category, Long> {
	//	Get list of Categories
	List<Category> findAll();
}

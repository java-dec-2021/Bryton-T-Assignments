package com.bryton.productsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bryton.productsAndCategories.models.Product;

public interface ProductRepository extends CrudRepository <Product, Long> {
	
	// findAll() products
	List<Product> findAll();

}

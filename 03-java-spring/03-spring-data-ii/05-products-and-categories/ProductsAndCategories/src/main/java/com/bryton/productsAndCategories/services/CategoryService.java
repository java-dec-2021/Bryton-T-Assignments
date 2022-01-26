package com.bryton.productsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.productsAndCategories.models.Category;
import com.bryton.productsAndCategories.models.Product;
import com.bryton.productsAndCategories.repositories.CategoryRepository;
import com.bryton.productsAndCategories.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryrepo;
	@Autowired
	private ProductRepository productrepo;
	
	//Get me all category
	public List<Category> getAllCategories(){
		return this.categoryrepo.findAll();
	}
	
	//create product
		public Category createCategory(Category category) {
			return this.categoryrepo.save(category);
		}
	
	public Category findCategoryById(Long categoryId) {
		return categoryrepo.findById(categoryId).orElse(null);
	}
	
	public void addProductToCategory(Long productId, Long categoryId) {
		Category category = this.findCategoryById(categoryId);
		Product product = productrepo.findById(productId).get();
		category.getProducts().add(product);
		categoryrepo.save(category);
		}

	public List<Category> findAll() {
		return this.categoryrepo.findAll();
	}
}

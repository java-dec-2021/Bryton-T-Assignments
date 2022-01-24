package com.bryton.productsAndCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryton.productsAndCategories.models.Category;
import com.bryton.productsAndCategories.models.Product;
import com.bryton.productsAndCategories.repositories.CategoryRepository;
import com.bryton.productsAndCategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	//Get all products
	public List<Product> getAllProducts(){
		return this.productRepo.findAll();
	}
	
	//create product
	public Product create(Product product) {
		return this.productRepo.save(product);
	}
	
	//find one product
	public Product findById(Long productId) {
		return productRepo.findById(productId).orElse(null);
	}
	
	public void addCategoryToProduct(Long categoryId, Long productId){
		Product product = this.findById(productId);
		Category category = categoryRepo.findById(categoryId).get();
		product.getCategories().add(category);
		productRepo.save(product);	
		}
	
	public List<Product> findAll(){
		return this.productRepo.findAll();
	}
}
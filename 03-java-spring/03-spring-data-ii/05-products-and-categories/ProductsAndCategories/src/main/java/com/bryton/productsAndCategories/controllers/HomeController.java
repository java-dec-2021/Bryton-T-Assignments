package com.bryton.productsAndCategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bryton.productsAndCategories.models.Category;
import com.bryton.productsAndCategories.models.Product;
import com.bryton.productsAndCategories.services.CategoryService;
import com.bryton.productsAndCategories.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService ProductService;
	@Autowired
	private CategoryService CategoryService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("Products", this.ProductService.getAllProducts());
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String productsHome() {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@ModelAttribute("product") Product product) {
		this.ProductService.create(product);
		return "redirect:/";
	}

	@GetMapping("/products/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long productId, Model model) {
		model.addAttribute("product",ProductService.findById(productId));
		model.addAttribute("categories", CategoryService.findAll());
		return "productPage.jsp";
	}
	@PostMapping("/products/{id}")
	public String createCategory( @PathVariable ("id") Long productId, Model model, @RequestParam("category") Long categoryId ) {
		ProductService.addCategoryToProduct(categoryId,productId);
		return "redirect:/{id}";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute ("category") Category category){
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String createCategory(@ModelAttribute ("category") Category category){
		this.CategoryService.create(category);
		return "redirect:/";
	}
	
	@GetMapping ("/categories/{id}")
	public String addProductToCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("category", CategoryService.findById(id));
		model.addAttribute("products", ProductService.getAllProducts());
		//model.addAttribute("ListOfCategory", categoryService.findAll());
		return "categoryDisplay.jsp";
	}
	@PostMapping("/categories/{id}")
	public String createProduct( @PathVariable ("id") Long categoryId, Model model, @RequestParam("product") Long productId ) {
		CategoryService.addProductToCategory(productId,categoryId);
		return "redirect:/categories/{id}";
	}
}

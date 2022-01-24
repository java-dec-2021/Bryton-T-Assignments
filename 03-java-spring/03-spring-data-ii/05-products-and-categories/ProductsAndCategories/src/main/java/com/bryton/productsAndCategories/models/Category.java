package com.bryton.productsAndCategories.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotNull
//    @Size(min=3, max= 20, message="Category name must be between 3 and 20 characters.")
    private String name;
//    private Date created_at;
//    private Date updated_at;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "category_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    
    private List<Product> productsInCategory;
    
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
//	public Date getCreatedAt() {
//		return created_at;
//	}
//	public void setCreatedAt(Date created_at) {
//		this.created_at = created_at;
//	}
//	public Date getUpdatedAt() {
//		return updated_at;
//	}
//	public void setUpdatedAt(Date updated_at) {
//		this.updated_at = updated_at;
//	}
	public List<Product> getProducts() {
		return productsInCategory;
	}
	public void setProducts(List<Product> products) {
		this.productsInCategory = products;
	}
}

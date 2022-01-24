package com.bryton.productsAndCategories.models;

import java.util.List;

import javax.persistence.Column;
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
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@NotNull
//	@Size(min = 3, max = 20, message = "Product name must be between 3 and 20 characters.")
	private String name;
	private String description;
	private float price;
	@Column(updatable = false)
//	private Date created_at;
//	private Date updated_at;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    
	private List<Category> categorizedProducts;
    
	public Product() {
		super();
	}	

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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
//	public Date getCreated_at() {
//		return created_at;
//	}
//	public void setCreated_at(Date created_at) {
//		this.created_at = created_at;
//	}
//	public Date getUpdated_at() {
//		return updated_at;
//	}
//	public void setUpdated_at(Date updated_at) {
//		this.updated_at = updated_at;
//	}
	public List<Category> getCategories() {
		return categorizedProducts;
	}
	public void setCategories(List<Category> categories) {
		this.categorizedProducts = categories;
	}

}

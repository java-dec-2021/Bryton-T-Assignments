package com.bryton.dojos_and_ninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="Dojos")

public class Dojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    @Column(updatable=false)
    private Date created_at;
    private Date updated_at;
    @OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
    private List<Ninja> ninja;

	public Dojo() {
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
	
	public Date getCreatedAt() {
		return created_at;
	}
	
	public void setCreatedAt(Date created_at) {
		this.created_at = created_at;
	}
	
	public Date getUpdatedAt() {
		return updated_at;
	}
	
	public void setUpdatedAt(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		this.updated_at = new Date();
	}

	@Override
	public String toString() {
		return "Dojo [id= " + id + ", name= " + name + "]";
	}
	
}
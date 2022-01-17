package com.bryton.dojos_and_ninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="Ninjas")

public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String first_name;
    private String last_name;
    private int age;
    private int dojo_id;
    @Column(updatable=false)
    private Date created_at;
    private Date updated_at;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;  

	@Override
	public String toString() {
		return "Ninja [id= " + id + ", First Name= " + first_name + ", Last Name= " + last_name + ", Age= " + age + "]";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDojo_id() {
		return dojo_id;
	}

	public void setDojo_id(int dojo_id) {
		this.dojo_id = dojo_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

    public Dojo getDojo() {
    	return dojo;
    }
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		this.updated_at = new Date();
	}
}

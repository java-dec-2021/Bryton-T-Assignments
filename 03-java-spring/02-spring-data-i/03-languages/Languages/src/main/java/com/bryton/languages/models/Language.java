package com.bryton.languages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="languages")

public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @NotNull
    @Size(min = 2, max = 20)
	private String name;
    @NotNull
    @Size(min = 2, max = 20)
	private String creator;
    @NotNull
	private String version;

	public Language() {
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name +  ", creator=" + creator + ", version=" + version + "]";
	}
	
}

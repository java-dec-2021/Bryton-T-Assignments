package com.bryton.dojo_overflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=5, max=500, message="You must be typed question! ")
	private String question;
	@Column(updatable =false)
	@DateTimeFormat(pattern ="yyyy-MM-DD HH:mm:ss")
	private Date created_at;
	@DateTimeFormat(pattern ="yyyy-MM-DD HH:mm:ss")
	private Date updated_at;
	
	@Transient
	private String temptags;
	
	@OneToMany(mappedBy="question",fetch=FetchType.LAZY)
	private List<Answer> answers;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
			name="tags_questions",
			joinColumns=@JoinColumn(name="question_id"),
			inverseJoinColumns=@JoinColumn(name="tag_id"))
	private List <Tag> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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
	

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question() {
		super();
	}

	public String getTemptags() {
		return temptags;
	}

	public void setTemptags(String temptags) {
		this.temptags = temptags;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", created at=" + created_at + ", updated at=" + updated_at
				+ ", temptags=" + temptags + ", answers=" + answers + ", tags=" + tags + "]";
	}
}

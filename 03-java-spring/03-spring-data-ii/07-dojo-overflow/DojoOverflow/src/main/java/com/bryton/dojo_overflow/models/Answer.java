package com.bryton.dojo_overflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="answers")
public class Answer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min=5, max=500, message="Your answer must be between 5 and 500 characters")
	private String answer;
	@Column(updatable =false)
	@DateTimeFormat(pattern ="yyy-MM-DD HH:mm:ss")
	private Date created_at;
	@DateTimeFormat(pattern ="yyy-MM-DD HH:mm:ss")
	private Date updated_at;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="question_id")
	private Question question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer() {
		super();
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", created at=" + created_at + ", updated at=" + updated_at
				+ ", question=" + question + "]";
	}
}

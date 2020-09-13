package com.enrollment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="dependent")
public class Dependent {
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "full_name", length = 64, nullable = false)
	private String fullName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="enrollee_id", nullable=false)
	private Enrollee enrollee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Enrollee getEnrollee() {
		return enrollee;
	}

	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}
}

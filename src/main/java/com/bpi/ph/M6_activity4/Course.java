package com.bpi.ph.M6_activity4;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "course_name", columnDefinition = "VARCHAR(50)", length = 50)
	private String courseName;
	
	@Column(name = "grade", columnDefinition = "Double", length = (int) 5.2)
	private Double grade;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
	
	

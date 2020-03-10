package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.Grade;
import hr.fer.opp.project.models.enums.GradeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "StudentGrade")
public class StudentGrade implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "studentGradeID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String studentGradeID;

	@Enumerated(EnumType.STRING)
	private Grade grade;

	@Enumerated(EnumType.STRING)
	private GradeType gradeType;

	@Column(name = "comment")
	private String comment;

	@Column(name = "lectureID")
	private String lectureID;

	@Column(name = "studentID")
	private String studentID;

	public StudentGrade() {
	}

	public StudentGrade(Grade grade, GradeType gradeType, String comment, String lectureID, String studentID) {
		this.grade = grade;
		this.gradeType = gradeType;
		this.comment = comment;
		this.lectureID = lectureID;
		this.studentID = studentID;
	}

	public String getStudentGradeID() {
		return studentGradeID;
	}

	public void setStudentGradeID(String studentGradeID) {
		this.studentGradeID = studentGradeID;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public GradeType getGradeType() {
		return gradeType;
	}

	public void setGradeType(GradeType gradeType) {
		this.gradeType = gradeType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLectureID() {
		return lectureID;
	}

	public void setLectureID(String lectureID) {
		this.lectureID = lectureID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
}
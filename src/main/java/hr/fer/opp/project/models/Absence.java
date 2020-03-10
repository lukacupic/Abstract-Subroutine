package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Absence")

public class Absence implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "absenceID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String absenceID;

	@Column(name = "lectureID")
	private String lectureID;

	@Column(name = "studentID")
	private String studentID;

	@Column(name = "justified")
	private Boolean justified;

	@Column(name = "comment")
	private String comment;


	public Absence() {
	}

	public Absence(String lectureID, String studentID, Boolean justified, String comment) {
		this.lectureID = lectureID;
		this.studentID = studentID;
		this.justified = justified;
		this.comment = comment;
	}

	public String getAbsenceID() {
		return absenceID;
	}

	public void setAbsenceID(String absenceID) {
		this.absenceID = absenceID;
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

	public Boolean getJustified() {
		return justified;
	}

	public void setJustified(Boolean justified) {
		this.justified = justified;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
package hr.fer.opp.project.models;

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
@Table(name = "SubjectComponent")
public class SubjectComponent implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subjectComponentID")
	private String subjectComponentID;

	@Column(name = "subjectID")
	private String subjectID;

	@Enumerated(EnumType.STRING)
	private GradeType gradeType;

	public SubjectComponent() {
	}

	public String getSubjectComponentID() {
		return subjectComponentID;
	}

	public void setSubjectComponentID(String subjectComponentID) {
		this.subjectComponentID = subjectComponentID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public GradeType getGradeType() {
		return gradeType;
	}

	public void setGradeType(GradeType gradeType) {
		this.gradeType = gradeType;
	}
}
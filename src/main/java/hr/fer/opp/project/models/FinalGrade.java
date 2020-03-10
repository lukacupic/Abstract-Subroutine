package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.Grade;
import hr.fer.opp.project.models.keys.FinalGradeKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "FinalGrade")
public class FinalGrade implements Serializable {

	private static final long serialVersionUID = -1;

	@EmbeddedId
	private FinalGradeKey key;

	@Enumerated(EnumType.STRING)
	private Grade finalGrade;

	@Column(name = "schoolYear")
	private String schoolYear;

	public FinalGrade() {
	}

	public FinalGrade(FinalGradeKey key, Grade finalGrade, String schoolYear) {
		this.key = key;
		this.finalGrade = finalGrade;
		this.schoolYear = schoolYear;
	}

	public FinalGradeKey getKey() {
		return key;
	}

	public void setKey(FinalGradeKey key) {
		this.key = key;
	}

	public Grade getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(Grade finalGrade) {
		this.finalGrade = finalGrade;
	}


	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
}

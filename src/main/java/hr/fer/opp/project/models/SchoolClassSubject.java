package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SchoolClassSubject")
public class SchoolClassSubject implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "schoolClassSubjectID")
	private String schoolClassSubjectID;

	@Column(name = "schoolClassID")
	private String schoolClassID;

	@Column(name = "subjectID")
	private String subjectID;

	public SchoolClassSubject() {
	}

	public SchoolClassSubject(String schoolClassSubjectID, String schoolClassID, String subjectID) {
		this.schoolClassSubjectID = schoolClassSubjectID;
		this.schoolClassID = schoolClassID;
		this.subjectID = subjectID;
	}

	public String getSchoolClassSubjectID() {
		return schoolClassSubjectID;
	}

	public void setSchoolClassSubjectID(String schoolClassSubjectID) {
		this.schoolClassSubjectID = schoolClassSubjectID;
	}

	public String getSchoolClassID() {
		return schoolClassID;
	}

	public void setSchoolClassID(String schoolClassID) {
		this.schoolClassID = schoolClassID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
}

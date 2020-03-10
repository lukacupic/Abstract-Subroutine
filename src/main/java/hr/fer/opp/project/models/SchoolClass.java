package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SchoolClass")
public class SchoolClass implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "schoolClassID")
	private String schoolClassID;

	@Column(name = "name")
	private String name;

	@Column(name = "year")
	private String year;

	@Column(name = "classProfessorID")
	private String classProfessorID;

	@Column(name = "substituteProfessorID")
	private String substituteProfessorID;

	@Column(name = "schoolID")
	private String schoolID;

	@Column(name = "isArchived")
	private Boolean isArchived;

	public SchoolClass() {
	}

	@PrePersist
	void preInsert() {
		if (this.isArchived == null)
			this.isArchived = new Boolean(false);
	}

	public String getSchoolClassID() {
		return schoolClassID;
	}

	public void setSchoolClassID(String schoolClassID) {
		this.schoolClassID = schoolClassID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getClassProfessorID() {
		return classProfessorID;
	}

	public void setClassProfessorID(String classProfessorID) {
		this.classProfessorID = classProfessorID;
	}

	public String getSubstituteProfessorID() {
		return substituteProfessorID;
	}

	public void setSubstituteProfessorID(String substituteProfessorID) {
		this.substituteProfessorID = substituteProfessorID;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public Boolean getArchived() {
		return isArchived;
	}

	public void setArchived(Boolean archived) {
		isArchived = archived;
	}
}

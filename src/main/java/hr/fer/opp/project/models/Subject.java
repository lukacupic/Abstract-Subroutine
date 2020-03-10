package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "subjectID")
	private String subjectID;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "year")
	private String year;

	public Subject() {
	}

	public Subject(String subjectID, String name, String description, String year) {
		this.subjectID = subjectID;
		this.name = name;
		this.description = description;
		this.year = year;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
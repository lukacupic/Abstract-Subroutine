package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "School")
public class School implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "schoolID")
	private String schoolID;

	@Column(name = "schoolName")
	private String name;

	@Column(name = "address")
	private String address;

	public School() {
	}

	public School(String schoolID, String name, String address) {
		this.schoolID = schoolID;
		this.name = name;
		this.address = address;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

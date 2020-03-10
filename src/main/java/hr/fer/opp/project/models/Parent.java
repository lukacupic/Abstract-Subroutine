package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Parent")
public class Parent implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "parentID")
	private String parentID;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "childID")
	private String childID;

	public Parent() {
	}

	public Parent(String parentID, String firstName, String lastName, String childID) {
		this.parentID = parentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.childID = childID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getChildID() {
		return childID;
	}

	public void setChildID(String childID) {
		this.childID = childID;
	}
}

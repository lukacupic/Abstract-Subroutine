package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.Gender;

import javax.persistence.Id;
import java.io.Serializable;

public class ProfessorInfo implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	private String professorID;

	private String firstName;

	private String lastName;

	private Gender gender;

	private String phoneNumber;

	private boolean isClassTeacher;

	private String imageURL;

	private String schoolName;

	private String schoolAddress;

	public ProfessorInfo() {
	}

	public ProfessorInfo(String professorID, String firstName, String lastName, Gender gender, String phoneNumber,
	                     boolean isClassTeacher, String imageURL, String schoolName, String schoolAddress) {
		this.professorID = professorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.isClassTeacher = isClassTeacher;
		this.imageURL = imageURL;
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isClassTeacher() {
		return isClassTeacher;
	}

	public void setClassTeacher(boolean classTeacher) {
		isClassTeacher = classTeacher;
	}

	public String getImageUrl() {
		return "/image/" + professorID + ".jpg";
	}

	public void setImageUrl(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
}
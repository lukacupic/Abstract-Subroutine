package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.Gender;

import javax.persistence.Id;
import java.util.Date;

public class StudentInfo {


	@Id
	private String studentID;

	private String firstName;

	private String lastName;

	private Gender gender;

	private Date dateOfBirth;

	private String placeOfBirth;

	private String imageURL;

	private String schoolClassID;

	private String parentFirstName;

	private String parentLastName;

	public StudentInfo(String studentID, String firstName, String lastName, Gender gender, Date dateOfBirth, String placeOfBirth, String imageURL, String schoolClassID, String parentFirstName, String parentLastName) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.imageURL = imageURL;
		this.schoolClassID = schoolClassID;
		this.parentFirstName = parentFirstName;
		this.parentLastName = parentLastName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getImageUrl() {
		return "/image/" + studentID + ".jpg";
	}

	public void setImageUrl(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getSchoolClassID() {
		return schoolClassID;
	}

	public void setSchoolClassID(String schoolClassID) {
		this.schoolClassID = schoolClassID;
	}

	public String getParentFirstName() {
		return parentFirstName;
	}

	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}

	public String getParentLastName() {
		return parentLastName;
	}

	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}
}

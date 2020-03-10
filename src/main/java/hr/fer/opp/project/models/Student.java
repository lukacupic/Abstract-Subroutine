package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Student")
public class Student implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "studentID")
	private String studentID;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "dateOfBirth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "placeOfBirth")
	private String placeOfBirth;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Column(name = "schoolClassID")
	private String schoolClassID;

	@Column(name = "isArchived")
	private boolean isArchived;

	public Student() {
	}

	public Student(String studentID, String firstName, String lastName, Gender gender,
	               Date dateOfBirth, String placeOfBirth, String schoolClassID) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.schoolClassID = schoolClassID;
		this.isArchived = false;
	}

	public static StudentInfo getStudentInfo(Student s, Parent p) {
		return new StudentInfo(s.getStudentID(), s.getFirstName(), s.getLastName(), s.getGender(),
				s.getDateOfBirth(), s.getPlaceOfBirth(), s.getImageUrl(),
				s.getSchoolClassID(), p.getFirstName(), p.getLastName());
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

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSchoolClassID() {
		return schoolClassID;
	}

	public void setSchoolClassID(String schoolClassID) {
		this.schoolClassID = schoolClassID;
	}

	public boolean getArchived() {
		return isArchived;
	}

	public void setArchived(boolean archived) {
		isArchived = archived;
	}
}
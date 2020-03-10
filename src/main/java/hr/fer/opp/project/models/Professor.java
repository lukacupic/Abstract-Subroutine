package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.Gender;
import hr.fer.opp.project.models.enums.ProfessorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Professor")
public class Professor implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "professorID")
	private String professorID;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	private ProfessorType type;

	@Column(name = "imageURL")
	private String imageURL;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "schoolID")
	private String schoolID;

	public Professor() {
	}

	public static ProfessorInfo getProfessorInfo(Professor p, School s) {
		return new ProfessorInfo(p.getProfessorID(), p.getFirstName(), p.getLastName(), p.getGender(),
				p.getPhoneNumber(), p.getType() == ProfessorType.CLASS_TEACHER, p.getImageUrl(),
				s.getName(), s.getAddress()
		);
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

	public ProfessorType getType() {
		return type;
	}

	public void setType(ProfessorType type) {
		this.type = type;
	}

	public String getImageUrl() {
		return "/image/" + professorID + ".jpg";
	}

	public void setImageUrl(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}
}
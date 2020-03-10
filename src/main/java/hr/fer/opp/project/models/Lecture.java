package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Lecture")

public class Lecture implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "lectureID")
	private String lectureID;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "startingTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startingTime;

	@Column(name = "endingTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endingTime;

	@Column(name = "lectureRoom")
	private String lectureRoom;

	@Column(name = "schoolClassSubjectID")
	private String schoolClassSubjectID;

	@Column(name = "professorID")
	private String professorID;

	@Column(name = "schoolYear")
	private String schoolYear;

	public Lecture() {
	}


	public Lecture(String lectureID, String name, String description, Date startingTime, Date endingTime,
	               String lectureRoom, String schoolClassSubjectID, String professorID, String schoolYear) {
		this.lectureID = lectureID;
		this.name = name;
		this.description = description;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.lectureRoom = lectureRoom;
		this.schoolClassSubjectID = schoolClassSubjectID;
		this.professorID = professorID;
		this.schoolYear = schoolYear;
	}

	public CalendarItem convertToCalendarItem() {
		return new CalendarItem(name, description, startingTime, endingTime, lectureRoom);
	}

	public String getLectureID() {
		return lectureID;
	}

	public void setLectureID(String lectureID) {
		this.lectureID = lectureID;
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

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	public Date getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(Date endingTime) {
		this.endingTime = endingTime;
	}

	public String getLectureRoom() {
		return lectureRoom;
	}

	public void setLectureRoom(String lectureRoom) {
		this.lectureRoom = lectureRoom;
	}

	public String getSchoolClassSubjectID() {
		return schoolClassSubjectID;
	}

	public void setSchoolClassSubjectID(String schoolClassSubjectID) {
		this.schoolClassSubjectID = schoolClassSubjectID;
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}

	public String getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
}

package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ParentMeeting")
public class ParentMeeting implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "parentMeetingID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String parentMeetingID;

	@Column(name = "startingTime")
	private Date startingTime;

	@Column(name = "endingTime")
	private Date endingTime;

	@Column(name = "lectureRoom")
	private String lectureRoom;

	@Column(name = "professorID")
	private String professorID;

	public ParentMeeting() {
	}

	public CalendarItem convertToCalendarItem() {
		return new CalendarItem("Roditeljski sastanak", "Sastanak roditelja s profesorom",
				startingTime, endingTime, lectureRoom);
	}

	public String getParentMeetingID() {
		return parentMeetingID;
	}

	public void setParentMeetingID(String parentMeetingID) {
		this.parentMeetingID = parentMeetingID;
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

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}
}
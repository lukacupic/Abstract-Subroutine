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
@Table(name = "Consultation")
public class Consultation implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "consultationID")
	private String consultationID;

	@Column(name = "startingTime")
	private Date startingTime;

	@Column(name = "endingTime")
	private Date endingTime;

	@Column(name = "room")
	private String room;

	@Column(name = "professorID")
	private String professorID;

	public Consultation() {
	}

	public Consultation(Date startingTime, Date endingTime, String room, String professorID) {
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.room = room;
		this.professorID = professorID;
	}

	public CalendarItem convertToCalendarItem() {
		return new CalendarItem("Konzultacija", "Konzultacija s profesorom",
				startingTime, endingTime, room
		);
	}

	public String getConsultationID() {
		return consultationID;
	}

	public void setConsultationID(String consultationID) {
		this.consultationID = consultationID;
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

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}
}
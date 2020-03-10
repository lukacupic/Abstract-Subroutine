package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Event implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "eventID")
	private String eventID;

	@Column(name = "description")
	private String description;

	@Column(name = "time")
	private Date time;

	public Event() {
	}

	public Event(String eventID, String description, Date time) {
		this.eventID = eventID;
		this.description = description;
		this.time = time;
	}

	public String getEventID() {
		return eventID;
	}

	public void setEventID(String eventID) {
		this.eventID = eventID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
package hr.fer.opp.project.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

public class CalendarItem implements Serializable {

	private static final long serialVersionUID = -1;

	private String name;

	private String description;

	private Date startingTime;

	private Date endingTime;

	private String location;

	public CalendarItem() {
	}

	public CalendarItem(String name, String description, Date startingTime, Date endingTime, String location) {
		this.name = name;
		this.description = description;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}

package hr.fer.opp.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SchoolNotice")
public class SchoolNotice implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schoolNoticeID")
	private String schoolNoticeID;

	@Column(name = "time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "image")
	private byte[] image;

	@Column(name = "schoolID")
	private String schoolID;

	@Column(name = "isArchived")
	private boolean isArchived;

	public SchoolNotice() {
	}

	public SchoolNotice(Date time, String title, String content, String schoolID) {
		this.time = time;
		this.title = title;
		this.content = content;
		this.schoolID = schoolID;
		this.isArchived = false;
	}

	public String getSchoolNoticeID() {
		return schoolNoticeID;
	}

	public void setSchoolNoticeID(String schoolNoticeID) {
		this.schoolNoticeID = schoolNoticeID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}

	public boolean getIsArchived() {
		return isArchived;
	}

	public void setIsArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
}
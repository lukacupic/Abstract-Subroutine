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
@Table(name = "SubjectNotice")
public class SubjectNotice implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subjectNoticeID")
	private String subjectNoticeID;

	@Column(name = "time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date time;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "subjectID")
	private String subjectID;

	public SubjectNotice() {
	}

	public SubjectNotice(Date time, String title, String content, String subjectID) {
		this.time = time;
		this.title = title;
		this.content = content;
		this.subjectID = subjectID;
	}

	public String getSubjectNoticeID() {
		return subjectNoticeID;
	}

	public void setSubjectNoticeID(String subjectNoticeID) {
		this.subjectNoticeID = subjectNoticeID;
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

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
}
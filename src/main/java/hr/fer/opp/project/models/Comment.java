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
@Table(name = "Comment")
public class Comment implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentID")
	private String commentID;

	@Column(name = "content")
	private String content;

	@Column(name = "time")
	private Date time;

	@Column(name = "professorID")
	private String professorID;

	@Column(name = "studentID")
	private String studentID;

	//todo: change subject and professor -> lecture
	@Column(name = "subjectID")
	private String subjectID;

	public Comment() {
	}

	public Comment(String content, Date time, String professorID, String studentID) {
		this.content = content;
		this.time = time;
		this.professorID = professorID;
		this.studentID = studentID;
	}

	public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
}
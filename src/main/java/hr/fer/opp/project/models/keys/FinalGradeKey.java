package hr.fer.opp.project.models.keys;

import com.fasterxml.jackson.annotation.JsonProperty;
import hr.fer.opp.project.models.FinalGrade;
import hr.fer.opp.project.models.ProfessorSubject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * A composite key, used by the {@link FinalGrade} class.
 * It contains two primary keys: subjectID and studentOIB.
 */
@Embeddable
public class FinalGradeKey implements Serializable {

	private static final long serialVersionUID = -1;

	@Column(name = "subjectID")
	private String subjectID;

	@Column(name = "studentID")
	private String studentID;

	public FinalGradeKey() {
	}

	public FinalGradeKey(String subjectID, String studentID) {
		this.subjectID = subjectID;
		this.studentID = studentID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
}
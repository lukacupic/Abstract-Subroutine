package hr.fer.opp.project.models.keys;

import com.fasterxml.jackson.annotation.JsonProperty;
import hr.fer.opp.project.models.ProfessorSubject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * A composite key, used by the {@link ProfessorSubject} class.
 * It contains two primary keys: professorID and subjectID.
 */
@Embeddable
public class ProfessorSubjectKey implements Serializable {

	private static final long serialVersionUID = -1;

	@Column(name = "professorID")
	private String professorID;

	@Column(name = "subjectID")
	private String subjectID;

	public ProfessorSubjectKey() {
	}

	public ProfessorSubjectKey(String professorID, String subjectID) {
		this.professorID = professorID;
		this.subjectID = subjectID;
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
}
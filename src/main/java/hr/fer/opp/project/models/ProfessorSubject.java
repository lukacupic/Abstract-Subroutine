package hr.fer.opp.project.models;

import hr.fer.opp.project.models.keys.ProfessorSubjectKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ProfessorSubject")
public class ProfessorSubject implements Serializable {

	private static final long serialVersionUID = -1;

	@EmbeddedId
	private ProfessorSubjectKey key;

	@Column(name = "beganLecturing")
	private Date beganLecturing;

	@Column(name = "endsLecturing")
	private Date endsLecturing;

	public ProfessorSubject() {
	}

	public ProfessorSubject(ProfessorSubjectKey key, Date beganLecturing, Date endsLecturing) {
		this.key = key;
		this.beganLecturing = beganLecturing;
		this.endsLecturing = endsLecturing;
	}

	public ProfessorSubjectKey getKey() {
		return key;
	}

	public void setKey(ProfessorSubjectKey key) {
		this.key = key;
	}

	public Date getBeganLecturing() {
		return beganLecturing;
	}

	public void setBeganLecturing(Date beganLecturing) {
		this.beganLecturing = beganLecturing;
	}

	public Date getEndsLecturing() {
		return endsLecturing;
	}

	public void setEndsLecturing(Date endsLecturing) {
		this.endsLecturing = endsLecturing;
	}
}
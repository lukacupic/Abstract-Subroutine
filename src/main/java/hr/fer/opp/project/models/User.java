package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.UserType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	@Column(name = "userID")
	private String userID;

	@Column(name = "email")
	private String email;

	@Column(name = "passwordHash")
	private String passwordHash;

	@Enumerated(EnumType.STRING)
	private UserType userType;

	public User() {
	}

	public User(String userID, String email, String passwordHash, UserType userType) {
		this.userID = userID;
		this.email = email;
		this.passwordHash = passwordHash;
		this.userType = userType;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
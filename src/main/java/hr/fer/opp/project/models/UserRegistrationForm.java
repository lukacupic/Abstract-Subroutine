package hr.fer.opp.project.models;

import hr.fer.opp.project.models.enums.UserType;
import hr.fer.opp.project.util.Util;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "UserRegistrationForm")
public class UserRegistrationForm implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	private String userID;

	private String email;

	private String password;

	private UserType userType;

	public User createUser() {
		return new User(userID, email, Util.getPasswordHash(password), userType);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
package hr.fer.opp.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "UserLoginForm")
public class UserLoginForm implements Serializable {

	private static final long serialVersionUID = -1;

	@Id
	private String email;

	private String password;

	public UserLoginForm() {
	}

	public UserLoginForm(String email, String password) {
		this.email = email;
		this.password = password;
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
}

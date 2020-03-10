package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.User;
import hr.fer.opp.project.models.UserRegistrationForm;
import hr.fer.opp.project.repositories.UserRepository;
import hr.fer.opp.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link UserRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private UserRepository repository;

	/**
	 * Adds a new user to the repository.
	 *
	 * @param form the user registration form, containing the fields used
	 *             for user registration
	 */
	@RequestMapping("/add")
	public void add(@RequestBody UserRegistrationForm form) {
		User u = form.createUser();
		repository.save(u);
	}

	/**
	 * Finds and returns a certain user by the provided email.
	 *
	 * @param email the email of the user
	 * @return the user
	 */
	@RequestMapping("/findByEmail")
	public ResponseEntity findByEmail(@RequestParam("email") String email) {
		User u = repository.findByEmail(email);
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/findByUserID")
	public ResponseEntity findByUserID(@RequestParam("userID") String userID) {
		User u = repository.findByUserID(userID);
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Returns the ID of the user with the provided email.
	 *
	 * @param email the email of the user
	 * @return the user ID
	 */
	@RequestMapping("/findIDByEmail")
	public ResponseEntity findIDByEmail(@RequestParam("email") String email) {
		User u = repository.findByEmail(email);
		if (u != null) {
			return new ResponseEntity<>(u.getUserID(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	// DEPRECATED - replaced by Spring Security login mechanism
	/*
	@RequestMapping("/login")
	public ResponseEntity login(@RequestBody UserLoginForm form) {
		String email = form.getEmail();
		String password = form.getPassword();

		User u = repository.findByEmail(email);

		if (u == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		String actualHash = Util.getPasswordHash(password);
		String expectedHash = u.getPasswordHash();

		if (!actualHash.equals(expectedHash) || !u.getEmail().equals(email)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		session.setAttribute(USER_EMAIL_ATTRIBUTE, email);

		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	*/

	// DEPRECATED - replaced by Spring Security logout mechanism
	/*
	@RequestMapping("/logout")
	public void logout() {
		session.removeAttribute(USER_EMAIL_ATTRIBUTE);
	}
	*/

	/**
	 * Returns the currently logged in user.
	 *
	 * @return currently logged in user
	 */
	@RequestMapping("/getCurrentUser")
	public ResponseEntity getCurrentUser() {
		String email = Util.getCurrentUserEmail();
		if (email != null) {
			return new ResponseEntity<>(repository.findByEmail(email), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}

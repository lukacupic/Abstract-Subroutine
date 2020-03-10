package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Comment;
import hr.fer.opp.project.models.Subject;
import hr.fer.opp.project.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link CommentRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/comment")
public class CommentController extends DefaultController<Comment, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private CommentRepository repository;
}
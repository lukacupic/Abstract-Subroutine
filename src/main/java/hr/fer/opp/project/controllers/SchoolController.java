package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.School;
import hr.fer.opp.project.models.Subject;
import hr.fer.opp.project.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SchoolRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/school")
public class SchoolController extends DefaultController<School, String> {

	/**
	 * The CRUD repository used for handling requests.
	 */
	@Autowired
	private SchoolRepository repository;

	/*
	@RequestMapping("/changeWithNew")
	public Subject getSubjectData(@RequestParam("subjectID") String subjectID) {
		return repository.findOne(subjectID);
	} */
}

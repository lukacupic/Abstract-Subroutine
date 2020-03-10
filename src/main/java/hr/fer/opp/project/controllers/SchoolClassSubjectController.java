package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.SchoolClassSubject;
import hr.fer.opp.project.repositories.SchoolClassSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SchoolClassSubjectRepository}. The controller is used in
 * a servlet like way for mapping certain URLs to their corresponding
 * methods which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/schoolClassSubject")
public class SchoolClassSubjectController extends DefaultController<SchoolClassSubject, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private SchoolClassSubjectRepository repository;
}
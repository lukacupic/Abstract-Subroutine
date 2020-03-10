package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.ProfessorSubject;
import hr.fer.opp.project.models.keys.ProfessorSubjectKey;
import hr.fer.opp.project.repositories.ProfessorSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link ProfessorSubjectRepository}. The controller is used in
 * a servlet like way for mapping certain URLs to their corresponding
 * methods which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/professorSubject")
public class ProfessorSubjectController extends DefaultController<ProfessorSubject, ProfessorSubjectKey> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private ProfessorSubjectRepository repository;
}
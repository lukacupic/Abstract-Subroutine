package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.SubjectComponent;
import hr.fer.opp.project.repositories.SubjectComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SubjectComponentRepository}. The controller is used in a
 * servlet like way for mapping certain URLs to their corresponding
 * methods which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/subjectComponent")
public class SubjectComponentController extends DefaultController<SubjectComponent, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private SubjectComponentRepository repository;

	@RequestMapping("findBySubjectID")
	List<SubjectComponent> findBySubjectID(@RequestParam("subjectID") String subjectID) {
		return repository.findBySubjectID(subjectID);
	}
}
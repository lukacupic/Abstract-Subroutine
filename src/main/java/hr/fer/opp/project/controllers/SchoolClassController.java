package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.SchoolClass;
import hr.fer.opp.project.repositories.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SchoolClassRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/schoolClass")
public class SchoolClassController extends DefaultController<SchoolClass, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private SchoolClassRepository repository;

	@RequestMapping("/findByProfessorID")
	List<SchoolClass> findByProfessorID(@RequestParam("professorID") String professorID) {
		return repository.findByProfessorID(professorID);
	}

	@RequestMapping("/findBySubjectID")
	List<SchoolClass> findBySubjectID(@RequestParam("subjectID") String subjectID) {
		return repository.findBySubjectID(subjectID);
	}
}
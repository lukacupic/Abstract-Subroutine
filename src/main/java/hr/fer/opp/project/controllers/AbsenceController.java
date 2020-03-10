package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Absence;
import hr.fer.opp.project.models.Subject;
import hr.fer.opp.project.repositories.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link AbsenceRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/absence")
public class AbsenceController extends DefaultController<Absence, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private AbsenceRepository repository;

	@RequestMapping("/findByStudentID")
	public List<Absence> findByStudentID(@RequestParam("studentID") String studentID) {
		return repository.findByStudentID(studentID);
	}

	@RequestMapping("/findByStudentIDAndSubjectID")
	public List<Absence> findByStudentIDAndSubjectID(@RequestParam("studentID") String studentID,
	                                                 @RequestParam("subjectID") String subjectID) {
		return repository.findByStudentIDAndSubjectID(studentID, subjectID);
	}

	@RequestMapping("/findByStudentIDAndSubjectIDAndYear")
	public List<Absence> findByStudentIDAndSubjectIDAndYear(@RequestParam("studentID") String studentID,
	                                                        @RequestParam("subjectID") String subjectID,
	                                                        @RequestParam("year") String year) {
		return repository.findByStudentIDAndSubjectIDAndYear(studentID, subjectID, year);
	}

	@RequestMapping("/findByStudentIDAndYear")
	public List<Absence> findByStudentIDAndYear(@RequestParam("studentID") String studentID,
	                                                        @RequestParam("year") String year) {
		return repository.findByStudentIDAndYear(studentID, year);
	}
}
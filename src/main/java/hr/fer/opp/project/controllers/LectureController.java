package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Lecture;
import hr.fer.opp.project.models.Student;
import hr.fer.opp.project.repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link LectureRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/lecture")
public class LectureController extends DefaultController<Lecture, String> {

	/**
	 * The CRUD repository used for handling requests.
	 */
	@Autowired
	private LectureRepository repository;

	@RequestMapping("/findBySubjectID")
	public List<Lecture> findBySubjectID(@RequestParam("subjectID") String subjectID) {
		return repository.findBySubjectID(subjectID);
	}

}

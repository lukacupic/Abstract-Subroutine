
package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.FinalGrade;
import hr.fer.opp.project.models.keys.FinalGradeKey;
import hr.fer.opp.project.repositories.FinalGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link FinalGradeRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/finalGrade")
public class FinalGradeController extends DefaultController<FinalGrade, FinalGradeKey> {

	/**
	 * The CRUD repository used for accessing final grades repository.
	 */
	@Autowired
	private FinalGradeRepository repository;

	@RequestMapping("/getAllFinalGrades")
	public List<FinalGrade> getAllFinalGrades(@RequestParam("studentID") String studentID)  {
		return repository.getAllFinalGrades(studentID);
	}

	@RequestMapping("/getFinalGradeForSubject")
	public FinalGrade getFinalGrade(@RequestParam("studentID") String studentID,
	                                @RequestParam("subjectID") String subjectID)  {
		return repository.getFinalGrade(studentID, subjectID);
	}

	@RequestMapping("/getFinalGradeByYear")
	public List<FinalGrade> getFinalGradesByYear(@RequestParam("studentID") String studentID,
	                                @RequestParam("year") String year)  {
		return repository.getFinalGradeByYear(studentID, year);
	}

}

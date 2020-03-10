package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.StudentGrade;
import hr.fer.opp.project.models.enums.Grade;
import hr.fer.opp.project.models.enums.GradeType;
import hr.fer.opp.project.repositories.StudentGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link StudentGradeRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/studentGrade")
public class StudentGradeController extends DefaultController<StudentGrade, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private StudentGradeRepository repository;

	@RequestMapping("/findByStudentIDAndSubjectID")
	public List<StudentGrade> findByStudentIDAndSubjectID(
			@RequestParam("studentID") String studentID,
			@RequestParam("subjectID") String subjectID) {
		return repository.findByStudentIDAndSchoolClassID(studentID, subjectID);
	}

	@RequestMapping("/findByStudentIDAndSubjectIDAndYear")
	public List<StudentGrade> findByStudentIDAndSubjectIDAndYear(
			@RequestParam("studentID") String studentID,
			@RequestParam("subjectID") String subjectID,
			@RequestParam("year") String year) {
		return repository.findByStudentIDAndSchoolClassIDAndYear(studentID, subjectID, year);
	}


}
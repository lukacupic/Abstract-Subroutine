package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Subject;
import hr.fer.opp.project.repositories.SchoolClassRepository;
import hr.fer.opp.project.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SubjectRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/subject")
public class SubjectController extends DefaultController<Subject, String> {

	/**
	 * The CRUD repository used for accessing subjects.
	 */
	@Autowired
	private SubjectRepository repository;

	@Autowired
	private SchoolClassRepository schoolClassRepository;

	@RequestMapping("/findByProfessorID")
	public List<Subject> findByProfessorID(@RequestParam("professorID") String professorID) {
		return repository.findByProfessorID(professorID);
	}

	@RequestMapping("/findByStudentID")
	public List<Subject> findByStudentID(@RequestParam("studentID") String studentID) {
		return repository.findByStudentID(studentID);
	}

	@RequestMapping("/findByStudentIDAndYear")
	public List<Subject> findByStudentIDAndYear(@RequestParam("studentID") String studentID, @RequestParam("year") String year) {
		return repository.findByStudentIDAndYear(studentID, year);
	}

	@RequestMapping("/findForPreviousYear")
	public List<Subject> findForPreviousYear(@RequestParam("year") String year) {
		return repository.findForPreviousYear(year);
	}

	@RequestMapping("/getSubjectData")
	public Subject getSubjectData(@RequestParam("subjectID") String subjectID) {
		return repository.findOne(subjectID);
	}

	@RequestMapping("/findBySchoolClassIDAndProfessorID")
	public List<Subject> findBySchoolClassIDAndProfessorID(@RequestParam("schoolClassID") String schoolClassID,
	                                                       @RequestParam("professorID") String professorID) {
		return repository.findBySchoolClassIDAndProfessorID(schoolClassID, professorID);
	}

	@RequestMapping("/findByLectureID")
	public Subject findByLectureID(@RequestParam("lectureID") String lectureID) {
		return repository.findByLectureID(lectureID);
	}
}
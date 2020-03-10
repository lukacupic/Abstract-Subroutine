package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.*;
import hr.fer.opp.project.models.enums.UserType;
import hr.fer.opp.project.repositories.ParentRepository;
import hr.fer.opp.project.repositories.ProfessorRepository;
import hr.fer.opp.project.repositories.StudentRepository;
import hr.fer.opp.project.repositories.UserRepository;
import hr.fer.opp.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link StudentRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 * <p>
 * An example of mapping a HTTP GET request to a method is performed
 * as follows:
 * <pre>
 * {@literal @}RequestMapping("/getAll")
 * public Iterable<Student> getAll() {
 *     return repository.findAll();
 * }
 * </pre>
 * The example illustrates the mapping of a URL to a method, which means
 * that after performing a HTTP request to <code>"/getAll"</code>
 * the <code>getAll()</code> method will be called to handle the request.
 * <p>
 * If one is to process a POST request, instead of using the <pre>@RequestParam("OIB")
 * </pre> annotation, <pre>@RequestBody</pre> is used to specify that the
 * incoming request is a HTTP POST request, coming from the request's body
 * instead of the parameters.
 * <p>
 * The default root mapped by this controller is <code>"/api/student"</code>,
 * mapped at the class level.
 */
@RestController
@RequestMapping("/api/student")
public class StudentController extends DefaultController<Student, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private StudentRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ParentRepository parentRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@RequestMapping("/findByLastName")
	public List<Student> findByLastName(@RequestParam("lastName") String lastName) {
		return repository.findByLastName(lastName);
	}

	@RequestMapping("/findBySchoolClassID")
	public List<Student> findBySchoolClassID(@RequestParam("schoolClassID") String schoolClassID) {
		return repository.findBySchoolClassID(schoolClassID);
	}

	@RequestMapping("/getStudentData")
	public StudentInfo getStudentData() {
		String currentUser = Util.getCurrentUserEmail();
		User user = userRepository.findByEmail(currentUser);
		if (user.getUserType() == UserType.PARENT) {
			// todo: more than one child ?
			Student student = repository.findByParentID(user.getUserID());
			Parent parent = parentRepository.findOne(user.getUserID());
			return Student.getStudentInfo(student, parent);
		} else {
			Student student = repository.findOne(user.getUserID());
			Parent parent = parentRepository.findByStudentID(user.getUserID());
			return Student.getStudentInfo(student, parent);
		}
	}

	@RequestMapping("/findByParentID")
	public Student findByParentID(@RequestParam("parentID") String parentID) {
		return repository.findByParentID(parentID);
	}

	@RequestMapping("/getStudentProfessors")
	public List<Professor> getStudentProfessors() {
		String currentUser = Util.getCurrentUserEmail();
		User user = userRepository.findByEmail(currentUser);
		if (user.getUserType() == UserType.STUDENT) {
			return professorRepository.getStudentProfessors(user.getUserID());
		} else if (user.getUserType() == UserType.PARENT) {
			Student student = repository.findByParentID(user.getUserID());
			return professorRepository.getStudentProfessors(student.getStudentID());
		} else {
			return null;
		}
	}
}
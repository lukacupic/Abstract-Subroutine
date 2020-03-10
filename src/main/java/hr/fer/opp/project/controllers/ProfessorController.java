package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.*;
import hr.fer.opp.project.models.enums.Grade;
import hr.fer.opp.project.models.keys.FinalGradeKey;
import hr.fer.opp.project.repositories.*;
import hr.fer.opp.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link ProfessorRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/professor")
public class ProfessorController extends DefaultController<Professor, String> {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private AbsenceRepository absenceRepository;

	@Autowired
	private StudentGradeRepository studentGradeRepository;

	@Autowired
	private FinalGradeRepository finalGradeRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@RequestMapping("/getProfessorInfo")
	public ProfessorInfo getProfessorInfo(@RequestParam("professorID") String professorID) {
		Professor p = professorRepository.findOne(professorID);
		School s = schoolRepository.findByProfessorID(professorID);
		return Professor.getProfessorInfo(p, s);
	}

	@RequestMapping("/getAbsences")
	public List<Absence> getAbsences(@RequestParam("professorID") String professorID) {
		return absenceRepository.getAbsences(professorID);
	}

	@RequestMapping("/getUnjustifiedAbsences")
	public List<Absence> getUnjustifiedAbsences(@RequestParam("professorID") String professorID) {
		return absenceRepository.getUnjustifiedAbsences(professorID);
	}

	@RequestMapping("/justifyAbsence")
	public void justifyAbsence(@RequestParam("studentID") String studentID,
	                           @RequestParam("lectureID") String lectureID,
	                           @RequestParam("comment") String comment) {
		Absence a = absenceRepository.findAbsence(studentID, lectureID);
		a.setJustified(true);
		a.setComment(comment);
		absenceRepository.save(a);
	}

	@RequestMapping("/setAbsence")
	public void setAbsence(@RequestParam("studentID") String studentID,
	                       @RequestParam("lectureID") String lectureID) {
		Absence a = new Absence(lectureID, studentID, false, null);
		absenceRepository.save(a);
	}

	@RequestMapping("/addGrade")
	public void addGrade(@RequestBody StudentGrade grade) {
		studentGradeRepository.save(grade);
	}

	@RequestMapping("/addFinalGrade")
	public void setAbsence(@RequestParam("studentID") String studentID,
	                       @RequestParam("subjectID") String subjectID,
	                       @RequestParam("grade") Grade grade) {
		Subject subject = subjectRepository.findOne(subjectID);
		FinalGrade finalGrade = new FinalGrade(new FinalGradeKey(subjectID, studentID), grade, subject.getYear());
		finalGradeRepository.save(finalGrade);
	}

	@RequestMapping("/getProfessorData")
	public Professor getProfessorData(@RequestParam("professorID") String professorID) {
		return professorRepository.findOne(professorID);
	}

	@RequestMapping("/findClassTeacherForCurrentParent")
	public Professor findClassTeacherForCurrentParent() {
		User u = getUserForEmail();
		return professorRepository.findClassTeacherForCurrentParent(u.getUserID());
	}

	@RequestMapping("/findSubstituteForCurrentParent")
	public Professor findSubstituteForCurrentParent() {
		User u = getUserForEmail();
		return professorRepository.findSubstituteForCurrentParent(u.getUserID());
	}

	@RequestMapping("/deleteGrade")
	public void deleteGrade(@RequestParam("gradeID") String gradeID) {
		studentGradeRepository.delete(gradeID);
	}

	private User getUserForEmail() {
		String email = Util.getCurrentUserEmail();
		return userRepository.findByEmail(email);
	}
}
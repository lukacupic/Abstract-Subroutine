package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Professor;
import hr.fer.opp.project.models.ProfessorSubject;
import hr.fer.opp.project.models.SchoolClass;
import hr.fer.opp.project.models.SchoolNotice;
import hr.fer.opp.project.models.Student;
import hr.fer.opp.project.models.Subject;
import hr.fer.opp.project.models.enums.ProfessorType;
import hr.fer.opp.project.models.keys.ProfessorSubjectKey;
import hr.fer.opp.project.repositories.ProfessorRepository;
import hr.fer.opp.project.repositories.ProfessorSubjectRepository;
import hr.fer.opp.project.repositories.SchoolClassRepository;
import hr.fer.opp.project.repositories.SchoolNoticeRepository;
import hr.fer.opp.project.repositories.StudentRepository;
import hr.fer.opp.project.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests rellevant to the
 * system administrator. The controller is used in a servlet-like
 * way for mapping certain URLs to their corresponding methods which
 * handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {


	@Autowired
	private SchoolNoticeRepository schoolNoticeRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SchoolClassRepository schoolClassRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProfessorSubjectRepository professorSubjectRepository;

	@RequestMapping("/addNotice")
	public void addNotice(@RequestBody SchoolNotice notice) {
		schoolNoticeRepository.save(notice);
	}


	@RequestMapping("/deleteNotice")
	public void deleteNotice(@RequestParam("noticeID") String noticeID) {
		schoolNoticeRepository.delete(noticeID);
	}


	@RequestMapping("/getAllSubjects")
	public List<Subject> getAllSubjects() {
		return (List<Subject>) subjectRepository.findAll();
	}

	@RequestMapping("/getAllStudents")
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@RequestMapping("/getAllProfessors")
	public List<Professor> getAllProfessors() {
		return (List<Professor>) professorRepository.findAll();
	}


	@RequestMapping("/getClassesBySubject")
	public List<SchoolClass> getClassesBySubject(@RequestParam("subjectID") String subjectID) {
		return schoolClassRepository.findBySubjectID(subjectID);
	}

	@RequestMapping("/addSubject")
	public void addSubject(@RequestBody Subject subject) {
		subjectRepository.save(subject);
	}

	@RequestMapping("/deleteSubject")
	public void deleteSubject(@RequestParam("subjectID") String subjectID) {
		subjectRepository.delete(subjectID);
	}

	@RequestMapping("/addProfessor")
	public void addProfessor(@RequestBody Professor professor) {
		professorRepository.save(professor);
	}

	@RequestMapping("/changeProfessor")
	public void changeProfessor(@RequestBody Professor professor) {
		professorRepository.save(professor);
	}

	@RequestMapping("/deleteProfessor")
	public void deleteProfessor(@RequestParam("professorID") String professorID) {
		professorRepository.delete(professorID);
	}

	@RequestMapping("/addSchoolClass")
	public void addSchoolClass(@RequestBody SchoolClass schoolClass) {
		schoolClassRepository.save(schoolClass);
	}

	@RequestMapping("/deleteSchoolClass")
	public void deleteSchoolClass(@RequestParam("schoolClassID") String schoolClassID) {
		schoolClassRepository.delete(schoolClassID);
	}

	@RequestMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		studentRepository.save(student);
	}

	@RequestMapping("/changeClassProfessor")
	public void changeClassProfessor(@RequestParam("schoolClassID") String schoolClassID,
	                                 @RequestParam("classProfessorID") String classProfessorID) {
		SchoolClass schoolClass = schoolClassRepository.findOne(schoolClassID);
		Professor oldProfessor = professorRepository.findOne(schoolClass.getClassProfessorID());
		Professor newProfessor = professorRepository.findOne(classProfessorID);

		schoolClass.setClassProfessorID(classProfessorID);
		oldProfessor.setType(ProfessorType.PROFESSOR);
		newProfessor.setType(ProfessorType.CLASS_TEACHER);
		professorRepository.save(newProfessor);
		schoolClassRepository.save(schoolClass);
	}

	@RequestMapping("/setClassProfessor")
	public void setClassProfessor(@RequestParam("schoolClassID") String schoolClassID,
	                              @RequestParam("professorID") String professorID) {
		SchoolClass schoolClass = schoolClassRepository.findOne(schoolClassID);
		Professor professor = professorRepository.findOne(professorID);

		schoolClass.setClassProfessorID(professorID);
		professor.setType(ProfessorType.CLASS_TEACHER);
		professorRepository.save(professor);
		schoolClassRepository.save(schoolClass);
	}

	@RequestMapping("/setSubjectProfessor")
	public void setSubjectProfessor(@RequestParam("professorID") String professorID,
	                                @RequestParam("subjectID") String subjectID) {
		ProfessorSubject ps = new ProfessorSubject();
		ps.setKey(new ProfessorSubjectKey(professorID, subjectID));
		professorSubjectRepository.save(ps);
	}

	@RequestMapping("/archiveStudent")
	public void archiveStudent(@RequestParam("studentID") String studentID) {
		Student student = studentRepository.findOne(studentID);
		student.setArchived(true);
		studentRepository.save(student);
	}

	@RequestMapping("/archiveSchoolNotice")
	public void archiveSchoolNotice(@RequestParam("schoolNoticeID") String schoolNoticeID) {
		SchoolNotice schoolNotice = schoolNoticeRepository.findOne(schoolNoticeID);
		schoolNotice.setIsArchived(true);
		schoolNoticeRepository.save(schoolNotice);
	}

	@RequestMapping("/archiveSchoolClass")
	public void archiveSchoolClass(@RequestParam("schoolClassID") String schoolClassID) {
		SchoolClass schoolClass = schoolClassRepository.findOne(schoolClassID);
		schoolClass.setArchived(true);
		schoolClassRepository.save(schoolClass);
	}

}
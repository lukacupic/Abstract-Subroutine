package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.StudentGrade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link StudentGrade} objects. This repository contains custom methods
 * used for persisting {@link StudentGrade} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface StudentGradeRepository extends CrudRepository<StudentGrade, String> {

	@Query("SELECT g"
			+ " FROM StudentGrade g, Lecture l, SchoolClassSubject scs"
			+ " WHERE g.studentID = :studentID"
			+ " AND g.lectureID = l.lectureID"
			+ " AND l.schoolClassSubjectID = scs.schoolClassSubjectID"
			+ " AND scs.subjectID = :subjectID")
	List<StudentGrade> findByStudentIDAndSchoolClassID(
			@Param("studentID") String studentID, @Param("subjectID") String subjectID
	);

	@Query("SELECT g"
			+ " FROM StudentGrade g, Lecture l, SchoolClassSubject scs"
			+ " WHERE g.studentID = :studentID"
			+ " AND g.lectureID = l.lectureID"
			+ " AND l.schoolClassSubjectID = scs.schoolClassSubjectID"
			+ " AND scs.subjectID = :subjectID"
			+ " AND l.schoolYear = :year")
	List<StudentGrade> findByStudentIDAndSchoolClassIDAndYear(
			@Param("studentID") String studentID, @Param("subjectID") String subjectID, @Param("year") String year
	);
}
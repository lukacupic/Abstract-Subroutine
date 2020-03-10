package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Absence;
import hr.fer.opp.project.models.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Absence} objects. This repository contains custom methods
 * used for persisting {@link Absence} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface AbsenceRepository extends CrudRepository<Absence, String> {

	@Query("SELECT a " +
			"FROM Absence a, Lecture l " +
			"WHERE a.lectureID = l.lectureID " +
			"AND l.professorID = :professorID")
	List<Absence> getAbsences(@Param("professorID") String professorID);


	@Query("SELECT a " +
			"FROM Absence a, Lecture l " +
			"WHERE a.lectureID = l.lectureID " +
			"AND l.professorID = :professorID " +
			"AND a.justified = false " +
			"AND a.comment = null")
	List<Absence> getUnjustifiedAbsences(@Param("professorID") String professorID);

	@Query("SELECT a " +
			"FROM Absence a " +
			"WHERE a.studentID = :studentID " +
			"AND a.lectureID = :lectureID")
	Absence findAbsence(@Param("studentID") String studentID, @Param("lectureID") String lectureID);

	@Query("SELECT a " +
			"FROM Absence a " +
			"WHERE a.studentID = :studentID")
	List<Absence> findByStudentID(@Param("studentID") String studentID);

	@Query("SELECT a " +
			"FROM Absence a, Lecture l, SchoolClassSubject scs " +
			"WHERE a.studentID = :studentID " +
			"AND a.lectureID = l.lectureID " +
			"AND l.schoolClassSubjectID = scs.schoolClassSubjectID " +
			"AND scs.subjectID = :subjectID")
	List<Absence> findByStudentIDAndSubjectID(@Param("studentID") String studentID,
	                                          @Param("subjectID") String subjectID);

	@Query("SELECT a " +
			"FROM Absence a, Lecture l, SchoolClassSubject scs " +
			"WHERE a.studentID = :studentID " +
			"AND a.lectureID = l.lectureID " +
			"AND l.schoolClassSubjectID = scs.schoolClassSubjectID " +
			"AND scs.subjectID = :subjectID" +
			" AND l.schoolYear = :year")
	List<Absence> findByStudentIDAndSubjectIDAndYear(@Param("studentID") String studentID,
	                                          @Param("subjectID") String subjectID,
	                                                 @Param("year") String year);

	@Query("SELECT a " +
			"FROM Absence a, Lecture l " +
			"WHERE a.studentID = :studentID " +
			"AND a.lectureID = l.lectureID " +
			" AND l.schoolYear = :year")
	List<Absence> findByStudentIDAndYear(@Param("studentID") String studentID,
	                                                 @Param("year") String year);
}
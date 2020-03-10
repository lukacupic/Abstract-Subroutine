package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Lecture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence mechanism used for CRUD operations on a collection
 * of {@link Lecture} objects. This repository contains custom methods
 * used for persisting {@link Lecture} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface LectureRepository extends CrudRepository<Lecture, String> {

	@Query("SELECT l FROM Lecture l, SchoolClassSubject scs, Student s"
			+ " WHERE s.studentID = :studentID"
			+ " AND scs.schoolClassID = s.schoolClassID"
			+ " AND l.schoolClassSubjectID = scs.schoolClassSubjectID"
	)
	List<Lecture> findByStudentID(@Param("studentID") String studentID);

	@Query("SELECT l FROM Lecture l WHERE l.professorID = :professorID")
	List<Lecture> findByProfessorID(@Param("professorID") String professorID);

	@Query("SELECT l " +
			"FROM Lecture l, SchoolClassSubject scs " +
			"WHERE l.schoolClassSubjectID = scs.schoolClassSubjectID " +
			"AND scs.subjectID = :subjectID ")
	List<Lecture> findBySubjectID(@Param("subjectID") String subjectID);
}
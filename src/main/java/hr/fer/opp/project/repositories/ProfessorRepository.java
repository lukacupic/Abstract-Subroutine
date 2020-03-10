package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Professor} objects. This repository contains custom methods
 * used for persisting {@link Professor} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface ProfessorRepository extends CrudRepository<Professor, String> {

	@Query("SELECT prof"
			+ " FROM Parent p, Student s, SchoolClass sc, Professor prof"
			+ " WHERE p.parentID = :parentID"
			+ " AND p.childID = s.studentID"
			+ " AND s.schoolClassID = sc.schoolClassID"
			+ " AND sc.classProfessorID = prof.professorID")
	Professor findClassTeacherForCurrentParent(@Param("parentID") String parentID);

	@Query("SELECT prof"
			+ " FROM Parent p, Student s, SchoolClass sc, Professor prof"
			+ " WHERE p.parentID = :parentID"
			+ " AND p.childID = s.studentID"
			+ " AND s.schoolClassID = sc.schoolClassID"
			+ " AND sc.substituteProfessorID = prof.professorID")
	Professor findSubstituteForCurrentParent(@Param("parentID") String parentID);

	@Query("SELECT prof FROM Professor prof, Student s, ProfessorSubject ps, SchoolClassSubject scs " +
			"WHERE s.studentID = :userID AND " +
			"s.schoolClassID = scs.schoolClassID AND " +
			"ps.key.subjectID = scs.subjectID AND ps.key.professorID = prof.professorID")
	List<Professor> getStudentProfessors(@Param("userID") String userID);
}
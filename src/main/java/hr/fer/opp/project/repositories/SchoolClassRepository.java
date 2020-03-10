package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.SchoolClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link SchoolClass} objects. This repository contains custom methods
 * used for persisting {@link SchoolClass} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SchoolClassRepository extends CrudRepository<SchoolClass, String> {

	@Query("SELECT sc"
			+ " FROM SchoolClass sc, ProfessorSubject ps, SchoolClassSubject scs"
			+ " WHERE ps.key.professorID = :professorID"
			+ " AND ps.key.subjectID = scs.subjectID"
			+ " AND scs.schoolClassID = sc.schoolClassID")
	List<SchoolClass> findByProfessorID(@Param("professorID") String professorID);


	@Query("SELECT sc"
			+ " FROM SchoolClassSubject scs, SchoolClass sc"
			+ " WHERE scs.subjectID = :subjectID "
			+ " AND scs.schoolClassID = sc.schoolClassID")
	List<SchoolClass> findBySubjectID(@Param("subjectID") String subjectID);
}
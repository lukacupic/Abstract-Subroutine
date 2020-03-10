package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * A persistence mechanism used for CRUD operations on a collection
 * of {@link School} objects. This repository contains custom methods
 * used for persisting {@link School} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SchoolRepository extends CrudRepository<School, String> {

	@Query("SELECT s"
			+ " FROM School s, Professor p"
			+ " WHERE p.professorID = :professorID"
			+ " AND p.schoolID = s.schoolID")
	School findByProfessorID(@Param("professorID") String professorID);
}
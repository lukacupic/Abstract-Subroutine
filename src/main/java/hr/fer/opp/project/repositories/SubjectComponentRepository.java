package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.SubjectComponent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link SubjectComponent} objects. This repository contains custom
 * methods used for persisting {@link SubjectComponent} objects, along
 * with some default methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SubjectComponentRepository extends CrudRepository<SubjectComponent, String> {

	@Query("SELECT sc FROM SubjectComponent sc WHERE sc.subjectID = :subjectID")
	List<SubjectComponent> findBySubjectID(@Param("subjectID") String subjectID);
}
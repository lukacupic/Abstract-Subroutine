package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.ParentMeeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link ParentMeeting} objects. This repository contains custom methods
 * used for persisting {@link ParentMeeting} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface ParentMeetingRepository extends CrudRepository<ParentMeeting, String> {

	@Query("SELECT pm FROM ParentMeeting pm WHERE pm.professorID = :professorID")
	List<ParentMeeting> findByProfessorID(@Param("professorID") String professorID);
}
package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Parent;
import hr.fer.opp.project.models.ParentMeeting;
import hr.fer.opp.project.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Parent} objects. This repository contains custom methods
 * used for persisting {@link Parent} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface ParentRepository extends CrudRepository<Parent, String> {

	@Query("SELECT p " +
			"FROM Parent p, Student s " +
			"WHERE p.childID = s.studentID " +
			"AND s.studentID = :studentID ")
	Parent findByStudentID(@Param("studentID") String studentID);
}
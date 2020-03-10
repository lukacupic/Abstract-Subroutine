package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Student} objects. This repository contains custom methods
 * used for persisting {@link Student} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface StudentRepository extends CrudRepository<Student, String> {

	/**
	 * Fetches a collection of {@link Student}, uniquely identified
	 * by their {@link Student#lastName} attribute.
	 *
	 * @param lastName the last name to search the students by
	 * @return a list of students with the specified last name
	 */
	List<Student> findByLastName(String lastName);

	/**
	 * Similar to {@link #findByLastName(String)}, but instead of
	 * relying on Spring's underlying query mechanisms, this method
	 * uses a JPQL query to fetch from the repository.
	 *
	 * @param lastName lastName the last name to search the students by
	 * @return a list of students with the specified last name
	 * @implNote accessing a method parameter from the query is done by
	 * writing <code>:param</code> which accesses the method parameter
	 * defined with <code>@Param</code> annotation
	 */
	@Deprecated
	@Query("SELECT s FROM Student s WHERE s.lastName = :lastName")
	List<Student> findByLastNameQuery(@Param("lastName") String lastName);

	@Query("SELECT s FROM Student s WHERE s.schoolClassID = :schoolClassID")
	List<Student> findBySchoolClassID(@Param("schoolClassID") String schoolClassID);

	@Query("SELECT s " +
			"FROM Student s, Parent p " +
			"WHERE p.childID = s.studentID " +
			"AND p.parentID = :parentID ")
	Student findByParentID(@Param("parentID") String parentID);
}
package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.FinalGrade;
import hr.fer.opp.project.models.keys.FinalGradeKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link FinalGrade} objects. This repository contains custom methods
 * used for persisting {@link FinalGrade} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface FinalGradeRepository extends CrudRepository<FinalGrade, FinalGradeKey> {


	@Query("SELECT fg " +
			"FROM FinalGrade fg " +
			"WHERE fg.key.studentID = :studentID")
	List<FinalGrade> getAllFinalGrades(@Param("studentID") String studentID);

	@Query("SELECT fg " +
			"FROM FinalGrade fg " +
			"WHERE fg.key.studentID = :studentID " +
			"AND fg.key.subjectID = :subjectID")
	FinalGrade getFinalGrade(@Param("studentID") String studentID, @Param("subjectID") String subjectID);

	@Query("SELECT fg " +
			"FROM FinalGrade fg " +
			"WHERE fg.key.studentID = :studentID " +
			"AND fg.schoolYear = :year")
	List<FinalGrade> getFinalGradeByYear(@Param("studentID") String studentID, @Param("year") String year);
}

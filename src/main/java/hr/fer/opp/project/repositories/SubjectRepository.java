package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Subject} objects. This repository contains custom methods
 * used for persisting {@link Subject} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SubjectRepository extends CrudRepository<Subject, String> {

	/**
	 * Fetches a collection of subjects held by a professor specified by their ID.
	 *
	 * @param professorID the professor's ID
	 * @return a list of subjects held by the specified professor
	 */
	@Query("SELECT s"
			+ " FROM Subject s, ProfessorSubject ps"
			+ " WHERE s.subjectID = ps.key.subjectID"
			+ " AND ps.key.professorID = :professorID")
	List<Subject> findByProfessorID(@Param("professorID") String professorID);

	@Query("SELECT su "
			+ " FROM Student st, SchoolClassSubject scs, Subject su"
			+ " WHERE st.studentID = :studentID"
			+ " AND st.schoolClassID = scs.schoolClassID"
			+ " AND scs.subjectID = su.subjectID")
	List<Subject> findByStudentID(@Param("studentID") String studentID);

	@Query("SELECT su "
			+ " FROM Student st, SchoolClassSubject scs, Subject su"
			+ " WHERE st.studentID = :studentID"
			+ " AND st.schoolClassID = scs.schoolClassID"
			+ " AND scs.subjectID = su.subjectID"
			+ " AND su.year = :year")
	List<Subject> findByStudentIDAndYear(@Param("studentID") String studentID, @Param("year") String year);

	@Query("SELECT s " +
			"FROM Subject s " +
			"WHERE year = :year")
	List<Subject> findForPreviousYear(@Param("year") String year);

	@Query("SELECT s"
			+ " FROM Subject s, ProfessorSubject ps, SchoolClassSubject scs"
			+ " WHERE s.subjectID = scs.subjectID"
			+ " AND scs.subjectID = ps.key.subjectID"
			+ " AND scs.schoolClassID = :schoolClassID"
			+ " AND ps.key.professorID = :professorID")
	List<Subject> findBySchoolClassIDAndProfessorID(@Param("schoolClassID") String schoolClassID,
	                                                @Param("professorID") String professorID);

	@Query("SELECT s FROM Subject s, SchoolClassSubject scs, Lecture l"
			+ " WHERE l.lectureID = :lectureID"
			+ " AND l.schoolClassSubjectID = scs.schoolClassSubjectID"
			+ " AND scs.subjectID = s.subjectID")
	Subject findByLectureID(@Param("lectureID") String lectureID);
}
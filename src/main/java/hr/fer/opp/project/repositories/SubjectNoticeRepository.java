package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.SubjectNotice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link SubjectNotice} objects. This repository contains custom
 * methods used for persisting {@link SubjectNotice} objects, along
 * with some default methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SubjectNoticeRepository extends CrudRepository<SubjectNotice, String> {

	@Query ("SELECT sn " +
			"FROM SubjectNotice sn " +
			"WHERE sn.subjectID = :subjectID")
	List<SubjectNotice> getSubjectNotices(@Param("subjectID") String subjectID);
}
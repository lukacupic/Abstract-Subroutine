package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.SchoolNotice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link SchoolNotice} objects. This repository contains custom
 * methods used for persisting {@link SchoolNotice} objects, along
 * with some default methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SchoolNoticeRepository extends CrudRepository<SchoolNotice, String> {

	@Query("SELECT n FROM SchoolNotice n ORDER BY n.time DESC")
	List<SchoolNotice> getAllNotifications();
}
package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Consultation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.nio.file.Path;
import java.util.List;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Consultation} objects. This repository contains custom methods
 * used for persisting {@link Consultation} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface ConsultationRepository extends CrudRepository<Consultation, String> {

	List<Consultation> findByProfessorID(@Param("professorID") String professorID);
}
package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.ProfessorSubject;
import hr.fer.opp.project.models.keys.ProfessorSubjectKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link ProfessorSubject} objects. This repository contains custom
 * methods used for persisting {@link ProfessorSubject} objects, along
 * with some default methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface ProfessorSubjectRepository extends CrudRepository<ProfessorSubject, ProfessorSubjectKey> {
}
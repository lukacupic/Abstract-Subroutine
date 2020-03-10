package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.SchoolClassSubject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * A persistence repository used for CRUD operations on a collection of
 * {@link SchoolClassSubject} objects. This repository contains custom
 * methods used for persisting {@link SchoolClassSubject} objects, along
 * with some default methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface SchoolClassSubjectRepository extends CrudRepository<SchoolClassSubject, String> {
}
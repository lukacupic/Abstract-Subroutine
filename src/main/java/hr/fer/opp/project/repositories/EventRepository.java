package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Event} objects. This repository contains custom methods
 * used for persisting {@link Event} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface EventRepository extends CrudRepository<Event, String> {
}
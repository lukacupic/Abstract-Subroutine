package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link Comment} objects. This repository contains custom methods
 * used for persisting {@link Comment} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface CommentRepository extends CrudRepository<Comment, String> {
}
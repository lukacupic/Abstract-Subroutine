package hr.fer.opp.project.repositories;

import hr.fer.opp.project.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * A persistence repository used for CRUD operations on a collection
 * of {@link User} objects. This repository contains custom methods
 * used for persisting {@link User} objects, along with some default
 * methods, as defined in the {@link CrudRepository}.
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String> {

	User findByEmail(@Param("email") String email);

	User findByUserID(@Param("userID") String userID);
}
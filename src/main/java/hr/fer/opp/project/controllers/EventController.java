package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Event;
import hr.fer.opp.project.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link EventRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/event")
public class EventController extends DefaultController<Event, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private EventRepository repository;
}
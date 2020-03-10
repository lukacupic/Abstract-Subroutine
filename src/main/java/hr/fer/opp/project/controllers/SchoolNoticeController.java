package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Professor;
import hr.fer.opp.project.models.School;
import hr.fer.opp.project.models.SchoolNotice;
import hr.fer.opp.project.repositories.SchoolNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SchoolNoticeRepository}. The controller is used in a servlet
 * like way for mapping certain URLs to their corresponding methods
 * which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/schoolNotice")
public class SchoolNoticeController extends DefaultController<SchoolNotice, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private SchoolNoticeRepository repository;


	@RequestMapping("/getAllNotifications")
	public List<SchoolNotice> getAllNotifications() {
		return repository.getAllNotifications();
	}

}
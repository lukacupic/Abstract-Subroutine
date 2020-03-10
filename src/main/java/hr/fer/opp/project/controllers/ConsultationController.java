package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Consultation;
import hr.fer.opp.project.models.Subject;
import hr.fer.opp.project.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link ConsultationRepository}. The controller is used in a
 * servlet like way for mapping certain URLs to their corresponding
 * methods which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/consultation")
public class ConsultationController extends DefaultController<Consultation, String> {

	/**
	 * The CRUD repository used for accessing students.
	 */
	@Autowired
	private ConsultationRepository repository;

	@RequestMapping("/getAllConsultations")
	public List<Consultation> getAllConsultations() {
		return (List<Consultation>) repository.findAll();
	}

}
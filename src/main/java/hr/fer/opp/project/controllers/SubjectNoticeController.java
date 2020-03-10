package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.SubjectNotice;
import hr.fer.opp.project.repositories.SubjectNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * {@link SubjectNoticeRepository}. The controller is used in a
 * servlet like way for mapping certain URLs to their corresponding
 * methods which handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/subjectNotice")
public class SubjectNoticeController extends DefaultController<SubjectNotice, String> {

	/**
	 * The CRUD repository used for accessing subject notices.
	 */
	@Autowired
	private SubjectNoticeRepository repository;

	/*
	@RequestMapping("/getSubjectNotices")
	public List<SubjectNotice> getSubjectNotices(@RequestParam("subjectID") String subjectID)  {
		return repository.getSubjectNotices(subjectID);
	}

	@RequestMapping("/addSubjectNotice")
	public void addSubjectNotice(@RequestBody SubjectNotice subjectNotice)  {
		repository.save(subjectNotice);
	} */
}
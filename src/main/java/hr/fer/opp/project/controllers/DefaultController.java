package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * A default, template controller which contains some generic methods
 * which can be used by other controllers through the inheritance of
 * this class.
 *
 * @param <T>  the model managed by this controller (e.g. {@link Student}
 * @param <ID> the ID of the model {@param <T>} (i.e. the primary key)
 */
public abstract class DefaultController<T, ID extends Serializable> {

	@Autowired
	private CrudRepository<T, ID> repository;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity add(@RequestBody T student) {
		repository.save(student);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/findByID")
	public ResponseEntity findByID(@RequestParam("ID") ID ID) {
		T t = repository.findOne(ID);
		if (t != null) {
			return new ResponseEntity<>(t, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/getAll")
	public Iterable<T> getAll() {
		return repository.findAll();
	}

	@RequestMapping("/delete")
	public ResponseEntity delete(@RequestParam("ID") ID ID) {
		repository.delete(ID);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/clear")
	public ResponseEntity clear() {
		repository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

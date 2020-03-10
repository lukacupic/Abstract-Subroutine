package hr.fer.opp.project.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * media files. The controller is used in a servlet like-way for
 * mapping certain URLs to their corresponding methods which handle
 * the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/media")
public class MediaController {

	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/image/findByName")
	public void findImageByName(HttpServletResponse response, @RequestParam("filename") String filename) {
		response.setContentType("image/jpeg");
		try {
			copyToResponseStream(response, "static/image/" + filename + ".jpg");
		} catch (IOException e) {
		}
	}

	@RequestMapping("/pdf/findByName")
	public void findPDFByName(HttpServletResponse response, @RequestParam("filename") String filename) {
		response.setContentType("application/pdf");
		try {
			copyToResponseStream(response, "static/pdf/" + filename + ".pdf");
		} catch (IOException e) {
		}
	}

	private void copyToResponseStream(HttpServletResponse response, String url) throws IOException {
		//todo: if there's a place in the code where something breaks, it's probably here
		InputStream is = new ClassPathResource(url).getInputStream();
		IOUtils.copy(is, response.getOutputStream());
	}
}
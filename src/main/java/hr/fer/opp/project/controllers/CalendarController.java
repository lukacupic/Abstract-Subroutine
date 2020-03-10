package hr.fer.opp.project.controllers;

import hr.fer.opp.project.models.*;
import hr.fer.opp.project.models.enums.UserType;
import hr.fer.opp.project.repositories.*;
import hr.fer.opp.project.util.CalendarUtil;
import hr.fer.opp.project.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A mechanism for handling incoming HTTP requests regarding the
 * calendar. The controller is used in a servlet-like way for
 * mapping certain URLs to their corresponding methods which
 * handle the requests.
 *
 * @see StudentController for more detailed description
 */
@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

	/**
	 * The session context of the currently logged-in user.
	 */
	@Autowired
	private HttpSession session;

	@Autowired
	private LectureRepository lectureRepository;

	@Autowired
	private ParentMeetingRepository parentMeetingRepository;

	@Autowired
	private ConsultationRepository consultationRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * Fetches the calendar data for the currently logged-in user.
	 * The method internally resolves the type of the user and
	 * returns the calendar data specific to that user.
	 *
	 * @return the calendar data for the currently logged-in user
	 */
	@RequestMapping("/getCalendarData")
	public Map<String, List<CalendarItem>> getCalendarData(
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate) {
		String email = Util.getCurrentUserEmail();
		User u = userRepository.findByEmail(email);

		Map<String, List<CalendarItem>> map;

		if (u.getUserType() == UserType.STUDENT) {
			map = findByStudentID(u.getUserID(), fromDate, toDate);

		} else if (u.getUserType() == UserType.PARENT) {
			Student student = studentRepository.findByParentID(u.getUserID());
			map = findByStudentID(student.getStudentID(), fromDate, toDate);

		} else if (u.getUserType() == UserType.PROFESSOR) {
			map = findByProfessorID(u.getUserID(), fromDate, toDate);

		} else {
			//map = findByAdminID(u.getUserID(), fromDate, toDate);
			map = null;
		}
		return map;
	}

	private Map<String, List<CalendarItem>> findByStudentID(String studentID, String fromDate, String toDate) {
		List<Lecture> lectures = lectureRepository.findByStudentID(studentID);

		List<CalendarItem> items = CalendarUtil.convertLecturesToCalendarItems(lectures);

		if (fromDate != null && toDate != null) {
			items = CalendarUtil.filterCalendarItems(items, fromDate, toDate);
		}

		return CalendarUtil.mapCalendarItems(items);
	}

	private Map<String, List<CalendarItem>> findByProfessorID(String professorID, String fromDate, String toDate) {
		List<CalendarItem> items = new ArrayList<>();

		List<Lecture> ls = lectureRepository.findByProfessorID(professorID);
		items.addAll(CalendarUtil.convertLecturesToCalendarItems(ls));

		List<ParentMeeting> pms = parentMeetingRepository.findByProfessorID(professorID);
		items.addAll(CalendarUtil.convertParentMeetingsToCalendarItems(pms));

		List<Consultation> cs = consultationRepository.findByProfessorID(professorID);
		items.addAll(CalendarUtil.convertConsultationsToCalendarItems(cs));

		if (fromDate != null && toDate != null) {
			items = CalendarUtil.filterCalendarItems(items, fromDate, toDate);
		}

		return CalendarUtil.mapCalendarItems(items);
	}
}
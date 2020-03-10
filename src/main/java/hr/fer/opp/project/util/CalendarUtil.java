package hr.fer.opp.project.util;

import hr.fer.opp.project.models.CalendarItem;
import hr.fer.opp.project.models.Consultation;
import hr.fer.opp.project.models.Lecture;
import hr.fer.opp.project.models.ParentMeeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A utility class containing some commonly used methods while working
 * with the Calendar.
 */
public class CalendarUtil {

	/**
	 * Creates and returns a map which holds {@code String, List<CalendarItem>}
	 * pairs, where the String represents a date, and List<CalendarItem> represents
	 * a list of events happening on that date.
	 *
	 * @param items a list of items to map
	 * @return a map which maps each date to one or more calendar items occurring
	 * on that date
	 */
	public static Map<String, List<CalendarItem>> mapCalendarItems(List<CalendarItem> items) {
		items.sort(Comparator.comparing(CalendarItem::getStartingTime));

		Map<String, List<CalendarItem>> map = new HashMap<>();
		items.forEach(item -> {
			String date = new java.sql.Date(item.getStartingTime().getTime()).toString();
			List<CalendarItem> currentItems = map.computeIfAbsent(date, k -> new ArrayList<>());
			currentItems.add(item);
		});
		return map;
	}

	/**
	 * Converts the given {@link Lecture}s to a list of {@link CalendarItem}s.
	 *
	 * @param lectures the lectures to convert
	 * @return a list of {@link CalendarItem} objects
	 */
	public static List<CalendarItem> convertLecturesToCalendarItems(List<Lecture> lectures) {
		return lectures.stream().map(Lecture::convertToCalendarItem).collect(Collectors.toList());
	}

	/**
	 * Converts the given {@link ParentMeeting}s to a list of {@link CalendarItem}s.
	 *
	 * @param parentMeetings the parent meetings to convert
	 * @return a list of {@link CalendarItem} objects
	 */
	public static List<CalendarItem> convertParentMeetingsToCalendarItems(List<ParentMeeting> parentMeetings) {
		return parentMeetings.stream().map(ParentMeeting::convertToCalendarItem).collect(Collectors.toList());
	}

	/**
	 * Converts the given {@link Consultation}s to a list of {@link CalendarItem}s.
	 *
	 * @param consultations the consultations to convert
	 * @return a list of {@link CalendarItem} objects
	 */
	public static List<CalendarItem> convertConsultationsToCalendarItems(List<Consultation> consultations) {
		return consultations.stream().map(Consultation::convertToCalendarItem).collect(Collectors.toList());
	}

	/**
	 * Extracts and returns those calendar items which satisfy the given time interval.
	 * In other words, the methods returns only those items that happen after the fromDate
	 * and before the toDate.
	 *
	 * @param items    the items to filter
	 * @param fromDate the beginning date of the interval
	 * @param toDate   the starting date of the interval
	 * @return a filtered list of given calendar items
	 */
	public static List<CalendarItem> filterCalendarItems(List<CalendarItem> items, String fromDate, String toDate) {
		Calendar cFrom = getCalendarFor(parseDate(fromDate));
		Calendar cTo = getCalendarFor(parseDate(toDate));
		cTo.add(Calendar.DAY_OF_MONTH, 1);

		return items.stream().filter(item -> {
			Calendar c = Calendar.getInstance();
			c.clear();
			c.setTime(item.getStartingTime());
			return c.equals(cFrom) || c.equals(cTo) || (c.after(cFrom) && c.before(cTo));
		}).collect(Collectors.toList());
	}

	/**
	 * Parses the given date in the format "YYYY-MM-DD" and returns an
	 * int[] representation.
	 *
	 * @param date the date to parse
	 * @return an int[] representation of the given date
	 */
	private static int[] parseDate(String date) {
		return Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
	}

	/**
	 * Returns a {@link Calendar} object corresponding to the given date.
	 * The first value of the array is the year, the second is the month
	 * and the third is the day.
	 *
	 * @param date the date to convert to a calendar object
	 * @return a calendar representation of the given date array
	 */
	private static Calendar getCalendarFor(int[] date) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(date[0], date[1] - 1, date[2]);
		return c;
	}
}

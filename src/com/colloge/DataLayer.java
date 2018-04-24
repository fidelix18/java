package com.colloge;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.colloge.beans.Course;
import com.colloge.beans.Instructor;
import com.colloge.beans.Lecturer;
import com.colloge.beans.Professor;
import com.colloge.beans.Researcher;
import com.colloge.beans.Student;
import com.colloge.constants.Experty;

public class DataLayer {

	static {

		initInstructor();
		initStudents();
		initCourses();
	}

	private static List<Instructor> initInstructor() {

		instructors = new ArrayList<>();

		{
			Instructor instructor = new Professor();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.PROGRRAMING);
			experties.add(Experty.IOT);

			instructor.setId(1);
			instructor.setName("Ruther Ford");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("rurher.ford@Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		{
			Instructor instructor = new Professor();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.PROGRRAMING);
			experties.add(Experty.IOT);

			instructor.setId(2);
			instructor.setName("Albert Einstein ");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("albert.einstein @Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		{
			Instructor instructor = new Professor();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.PROGRRAMING);
			experties.add(Experty.IOT);

			instructor.setId(3);
			instructor.setName("Khalid Mughal");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("khalid.mughal@Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		{
			Instructor instructor = new Lecturer();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.DATABASE);
			experties.add(Experty.AI);

			instructor.setId(4);
			instructor.setName("C.J. Date");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("date@Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		{
			Instructor instructor = new Lecturer();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.AI);
			experties.add(Experty.IOT);

			instructor.setId(5);
			instructor.setName("Kathy Siera");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("siera.kathy@Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		{
			Instructor instructor = new Lecturer();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.AI);
			experties.add(Experty.NETWORKING);

			instructor.setId(6);
			instructor.setName("Berts Bate");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("bate.berts@Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		{
			Instructor instructor = new Researcher();

			Set<Experty> experties = new HashSet<>();
			experties.add(Experty.PROGRRAMING);
			experties.add(Experty.DATABASE);

			instructor.setId(7);
			instructor.setName("Berts Bate");
			instructor.setAddress("3/33 bac nss");
			instructor.setEmail("shadab.khan@Hertfordshire.com");
			instructor.setExperties(experties);

			instructors.add(instructor);
		}

		return instructors;

	}

	private static void initStudents() {
		students = new ArrayList<>();
		{
			Student student = new Student();
			student.setId(1);
			student.setName("Tom");
			student.setEmail("tom.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());

			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(2);
			student.setName("John");
			student.setEmail("test@test.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());

			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(3);
			student.setName("katreena");
			student.setEmail("katreena.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());

			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(4);
			student.setName("Gram");
			student.setEmail("gram.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());

			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(5);
			student.setName("Laila");
			student.setEmail("laila.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());

			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(6);
			student.setName("saira");
			student.setEmail("saira.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());
			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(7);
			student.setName("Ryan");
			student.setEmail("ryan.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());
			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(8);
			student.setName("Steev");
			student.setEmail("steev.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());
			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(9);
			student.setName("Jack");
			student.setEmail("jack.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());
			students.add(student);

		}
		{
			Student student = new Student();
			student.setId(10);
			student.setName("Juli");
			student.setEmail("juli.student@Hertfordshire.com");
			student.setPassword("1234");

			student.setCourses(new HashSet<>());
			students.add(student);

		}

	}

	private static void initCourses() {
		courses = new ArrayList<>();
		{
			Course course = new Course();
			course.setId(1);
			course.setName("Introduction of Database");
			course.setExperty(Experty.DATABASE);
			course.setInstructor(getInstructerRandom(Experty.DATABASE));
			course.setRoom("A15");
			course.setSeats(10);
			course.setTiming("01-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(2);
			course.setName("Introduction of Networking");
			course.setExperty(Experty.NETWORKING);
			course.setInstructor(getInstructerRandom(Experty.NETWORKING));
			course.setRoom("A16");
			course.setSeats(10);
			course.setTiming("01-Feb-2018 14:15 - 17:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(3);
			course.setName("Introduction of Artificial Intelligence");
			course.setExperty(Experty.AI);
			course.setInstructor(getInstructerRandom(Experty.AI));
			course.setRoom("A13");
			course.setSeats(10);
			course.setTiming("02-Feb-2018 14:15 - 17:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(4);
			course.setName("Artificial Intelligence and its Applications");
			course.setExperty(Experty.AI);
			course.setInstructor(getInstructerRandom(Experty.AI));
			course.setRoom("A14");
			course.setSeats(10);
			course.setTiming("02-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(5);
			course.setName("Roboticts using Artificial Intelligence");
			course.setExperty(Experty.AI);
			course.setInstructor(getInstructerRandom(Experty.AI));
			course.setRoom("A17");
			course.setSeats(10);
			course.setTiming("05-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(6);
			course.setName("Introduction of Internet of Things.");
			course.setExperty(Experty.IOT);
			course.setInstructor(getInstructerRandom(Experty.AI));
			course.setRoom("A15");
			course.setSeats(10);
			course.setTiming("05-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(6);
			course.setName("Introduction of Programing Using Java.");
			course.setExperty(Experty.PROGRRAMING);
			course.setInstructor(getInstructerRandom(Experty.AI));
			course.setRoom("A15");
			course.setSeats(10);
			course.setTiming("06-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(7);
			course.setName("Raspberry Pi and its applications");
			course.setExperty(Experty.IOT);
			course.setInstructor(getInstructerRandom(Experty.IOT));
			course.setRoom("A13");
			course.setSeats(10);
			course.setTiming("06-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}
		{
			Course course = new Course();
			course.setId(8);
			course.setName("Web Applications using Java");
			course.setExperty(Experty.PROGRRAMING);
			course.setInstructor(getInstructerRandom(Experty.PROGRRAMING));
			course.setRoom("A17");
			course.setSeats(10);
			course.setTiming("06-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}

		{
			Course course = new Course();
			course.setId(9);
			course.setName("Adhocs Mobile Networking");
			course.setExperty(Experty.NETWORKING);
			course.setInstructor(getInstructerRandom(Experty.NETWORKING));
			course.setRoom("A16");
			course.setSeats(10);
			course.setTiming("06-Feb-2018 09:15 - 12:15");

			courses.add(course);

		}

	}

	public static List<Course> getCourses() {

		return courses;
	}

	public static List<Instructor> getInstructors() {
		return instructors;
	}

	public static List<Student> getStudents() {
		return students;
	}

	public static List<Instructor> getInstructors(String filter, String key) {

		List<Instructor> filteredInstructors = new ArrayList<>();

		for (Instructor instructor : instructors) {

			if (filter.equals("ID")) {

				String idStr = String.valueOf(instructor.getId());

				if (idStr.equals(key)) {
					filteredInstructors.add(instructor);
				}

			} else if (filter.equals("NAME")) {

				String patternString = ".*" + key + ".*";

				Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

				Matcher matcher = pattern.matcher(instructor.getName());

				if (matcher.matches()) {
					filteredInstructors.add(instructor);
				}

			} else if (filter.equals("EXPERTY")) {

				String patternString = ".*" + key + ".*";

				Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

				Set<Experty> experties = instructor.getExperties();

				for (Experty experty : experties) {

					Matcher matcher = pattern.matcher(experty.getName());

					if (matcher.matches()) {
						filteredInstructors.add(instructor);
					}

				}

			}

		}

		return filteredInstructors;
	}

	public static List<Course> getCourses(String filter, String key) {

		List<Course> filteredCourses = new ArrayList<>();

		for (Course course : courses) {

			if (filter.equals("ID")) {

				String idStr = String.valueOf(course.getId());

				if (idStr.equals(key)) {
					filteredCourses.add(course);
				}

			} else if (filter.equals("NAME")) {

				String patternString = ".*" + key + ".*";

				Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

				Matcher matcher = pattern.matcher(course.getName());

				if (matcher.matches()) {
					filteredCourses.add(course);
				}

			} else if (filter.equals("EXPERTY")) {

				String patternString = ".*" + key + ".*";

				Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

				Experty experty = course.getExperty();

				Matcher matcher = pattern.matcher(experty.getName());

				if (matcher.matches()) {
					filteredCourses.add(course);
				}

			} else if (filter.equals("TIMING")) {

				String patternString = ".*" + key + ".*";

				Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

				Matcher matcher = pattern.matcher(course.getTiming());

				if (matcher.matches()) {
					filteredCourses.add(course);
				}

			} else if (filter.equals("INSTRUCTOR")) {

				String patternString = ".*" + key + ".*";

				Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

				Matcher matcher = pattern.matcher(course.getInstructor().getName());

				if (matcher.matches()) {
					filteredCourses.add(course);
				}

			}

		}

		return filteredCourses;
	}

	public static Student findStudent(String email, String password) {

		for (Student student : students) {

			if (email.equals(student.getEmail()) && password.equals(student.getPassword())) {

				return student;
			}
		}

		return null;
	}

	public static Course findCourse(long id) {

		for (Course course : courses) {

			if (id == course.getId()) {

				return course;
			}
		}

		return null;
	}

	public static List<Instructor> getInstructers(Experty experty) {

		List<Instructor> instructors = new ArrayList<>();

		for (Instructor instructor : instructors) {

			if (instructor.getExperties().contains(experty)) {

				instructors.add(instructor);
			}

		}

		return instructors;

	}

	public static Instructor getInstructerRandom(Experty experty) {

		List<Instructor> instructors = getInstructers(experty);

		if (instructors.size() <= 0) {
			return DataLayer.instructors.get(0);
		}

		int bounds = instructors.size() - 1;

		int index = new Random().nextInt(bounds);

		return instructors.get(index);

	}

	public static Instructor findInstructer(Experty experty) {

		for (Instructor instructor : instructors) {

			for (Experty exp : instructor.getExperties()) {

				if (experty == exp) {

					return instructor;
				}
			}
		}

		return null;

	}

	static private List<Instructor> instructors;

	static private List<Student> students;

	static private List<Course> courses;

}

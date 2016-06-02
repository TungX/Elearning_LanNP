package com.hust.soict.elearning_lannp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.CoursesService;
import com.hust.soict.elearning_lannp.server.model.ServerCourses;
import com.hust.soict.elearning_lannp.shared.model.Category;
import com.hust.soict.elearning_lannp.shared.model.Course;

public class CoursesServiceImpl extends RemoteServiceServlet implements CoursesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<Course> getCourses() {
		ServerCourses courses = new ServerCourses();
		return courses.getCourses(0);
	}

	@Override
	public ArrayList<Course> getCourses(int user_id) {
		ServerCourses courses = new ServerCourses();
		return courses.getCourses(user_id);
	}

	@Override
	public ArrayList<Course> getCourses(Category user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course add(Course course) {
		ServerCourses courses = new ServerCourses();
		return courses.insert(course);
	}

	@Override
	public Course update(Course course) {
		ServerCourses courses = new ServerCourses();
		return courses.update(course);
	}

	@Override
	public boolean destroy(Course course) {
		ServerCourses courses = new ServerCourses();
		return courses.destroy(course.getId());
	}

	@Override
	public Course getCourse(int id) {
		// TODO Auto-generated method stub
		ServerCourses courses = new ServerCourses();
		Course result = courses.getCourse(id);
		return result;
	}

}

package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Category;
import com.hust.soict.elearning_lannp.shared.model.Course;

@RemoteServiceRelativePath("coursesservice")
public interface CoursesService extends RemoteService {
	ArrayList<Course> getCourses();

	ArrayList<Course> getCourses(int user_id);

	ArrayList<Course> getCourses(Category category);
	
	Course getCourse(int id);

	Course add(Course course);

	Course update(Course course);

	boolean destroy(Course course);
}

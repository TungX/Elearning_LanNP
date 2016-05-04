package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.Category;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.User;

public interface CoursesServiceAsync {

	void addCourse(Course course, AsyncCallback<Course> callback);

	void destroyCourse(Course course, AsyncCallback<Boolean> callback);

	void getCourses(AsyncCallback<ArrayList<Course>> callback);

	void getCourses(User user, AsyncCallback<ArrayList<Course>> callback);

	void getCourses(Category user, AsyncCallback<ArrayList<Course>> callback);

	void updateCourse(Course course, AsyncCallback<Course> callback);

	void getCourse(int id, AsyncCallback<Course> callback);

}

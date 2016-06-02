package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.Category;
import com.hust.soict.elearning_lannp.shared.model.Course;

public interface CoursesServiceAsync {

	void add(Course course, AsyncCallback<Course> callback);

	void destroy(Course course, AsyncCallback<Boolean> callback);

	void getCourses(AsyncCallback<ArrayList<Course>> callback);

	void getCourses(int user_id, AsyncCallback<ArrayList<Course>> callback);

	void getCourses(Category user, AsyncCallback<ArrayList<Course>> callback);

	void update(Course course, AsyncCallback<Course> callback);

	void getCourse(int id, AsyncCallback<Course> callback);

}

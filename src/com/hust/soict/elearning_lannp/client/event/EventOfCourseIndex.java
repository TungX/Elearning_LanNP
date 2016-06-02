package com.hust.soict.elearning_lannp.client.event;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.CoursesService;
import com.hust.soict.elearning_lannp.client.service.CoursesServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.*;

public class EventOfCourseIndex {
	private CourseIndex page;
	private CoursesServiceAsync coursesServiceAsync;

	public EventOfCourseIndex(CourseIndex page) {
		this.page = page;
		this.coursesServiceAsync = GWT.create(CoursesService.class);
	}

	public void loadCourses() {
		coursesServiceAsync.getCourses(new AsyncCallback<ArrayList<Course>>() {
			@Override
			public void onSuccess(ArrayList<Course> result) {
				// TODO Auto-generated method stub
				page.setCourses(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Sorry, please contact with us");
			}
		});
		try {
			if (Store.user.getType() != 1)
				page.hideAddCourse();
		} catch (Exception e) {
			page.hideAddCourse();
		}
	}

	public void loadCourses(int user_id) {
		coursesServiceAsync.getCourses(new AsyncCallback<ArrayList<Course>>() {
			@Override
			public void onSuccess(ArrayList<Course> result) {
				// TODO Auto-generated method stub
				page.setCourses(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Sorry, please contact with us");
			}
		});
		try {
			if (Store.user.getType() != 1)
				page.hideAddCourse();
		} catch (Exception e) {
			page.hideAddCourse();
		}
	}
}

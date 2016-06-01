package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.CoursesService;
import com.hust.soict.elearning_lannp.client.service.CoursesServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseRightBar;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.*;

public class EventOfCourse extends Event {
	private CoursesServiceAsync coursesServiceAsync;
	private CourseLeftBar leftbar;
	private CourseRightBar rightbar;
	private Course course;
	private EventOfCourse self;

	public EventOfCourse(CourseLeftBar leftbar, CourseRightBar rightbar, int course_id) {
		this.leftbar = leftbar;
		this.rightbar = rightbar;
		this.coursesServiceAsync = GWT.create(CoursesService.class);
		this.self = this;
		loadCourseInfo(course_id);
	}

	public void loadCourseInfo(int course_id) {
		this.coursesServiceAsync.getCourse(course_id, new AsyncCallback<Course>() {
			@Override
			public void onSuccess(Course result) {
				// TODO Auto-generated method stub
				loadCourse(result, self);
				setCourse(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
	}

	public void update(Course course) {
		this.coursesServiceAsync.update(course, new AsyncCallback<Course>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Course result) {
				rightbar.loadCourseInfo(result);
			}
		});
	}

	public Course getCourse() {
		return this.course;
	}

	private void setCourse(Course course) {
		Store.setCourse(course);
		this.course = course;
	}

	public void loadCourse(Course result, EventOfCourse event) {
		this.course = result;
		rightbar.loadCourseInfo(result, event);
		leftbar.setCourse(result);
		leftbar.setLectures(result.getLectures());
		leftbar.setAssignments(result.getAssignments());
	}

	@Override
	public void delete(int id) {
		this.coursesServiceAsync.destroy(this.course, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(Boolean result) {
				History.newItem("courses");
			}
		});
	}
}

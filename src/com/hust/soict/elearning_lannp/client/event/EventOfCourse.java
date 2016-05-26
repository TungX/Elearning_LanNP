package com.hust.soict.elearning_lannp.client.event;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Breadcrumbs;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.CoursesService;
import com.hust.soict.elearning_lannp.client.service.CoursesServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseRightBar;
import com.hust.soict.elearning_lannp.shared.model.*;

public class EventOfCourse extends Event {
	private CoursesServiceAsync coursesServiceAsync;
	private CourseLeftBar leftbar;
	private CourseRightBar rightbar;
	private Breadcrumbs breadCrumbs;
	private Course course;
	private EventOfCourse self;

	public EventOfCourse(CourseLeftBar leftbar, CourseRightBar rightbar,
			Breadcrumbs breadCrumbs, int course_id) {
		this.course = new Course(course_id);
		this.leftbar = leftbar;
		this.rightbar = rightbar;
		this.breadCrumbs = breadCrumbs;
		this.coursesServiceAsync = GWT.create(CoursesService.class);
		this.self = this;
	}

	public void loadCourseInfo() {
		this.coursesServiceAsync.getCourse(this.course.getId(),
				new AsyncCallback<Course>() {
					@Override
					public void onSuccess(Course result) {
						// TODO Auto-generated method stub
						loadCourse(result, self);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
					}
				});
	}

	public void delete() {
		this.coursesServiceAsync.destroy(this.course,
				new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(Boolean result) {
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
				breadCrumbs.clear();
				breadCrumbs.add(new AnchorListItem(result.getName()));
			}
		});
	}

	public Course getCourse() {
		return this.course;
	}

	public void loadCourse(Course result, EventOfCourse event) {
		course = result;
		rightbar.loadCourseInfo(result, event);
		leftbar.setCourse(result);
		breadCrumbs.add(new AnchorListItem(result.getName()));
		leftbar.setLectures(result.getLectures());
		leftbar.setAssignments(result.getAssignments());
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Window.alert("delete course " + id);
	}
}

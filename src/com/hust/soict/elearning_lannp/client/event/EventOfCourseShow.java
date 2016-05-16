package com.hust.soict.elearning_lannp.client.event;

import java.util.ArrayList;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.AssignmentService;
import com.hust.soict.elearning_lannp.client.service.AssignmentServiceAsync;
import com.hust.soict.elearning_lannp.client.service.CoursesService;
import com.hust.soict.elearning_lannp.client.service.CoursesServiceAsync;
import com.hust.soict.elearning_lannp.client.service.LecturesService;
import com.hust.soict.elearning_lannp.client.service.LecturesServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseRightBar;
import com.hust.soict.elearning_lannp.shared.model.*;

public class EventOfCourseShow {
	private LecturesServiceAsync lecturesServiceAsync;
	private AssignmentServiceAsync assignmentServiceAsync;
	private CoursesServiceAsync coursesServiceAsync;
	private CourseLeftBar leftbar;
	private CourseRightBar rightbar;
	private Course course;

	public EventOfCourseShow(CourseLeftBar leftbar, CourseRightBar rightbar, int course_id) {
		this.course = new Course(course_id);
		this.leftbar = leftbar;
		this.rightbar = rightbar;
		this.lecturesServiceAsync = GWT.create(LecturesService.class);
		this.assignmentServiceAsync = GWT.create(AssignmentService.class);
		this.coursesServiceAsync = GWT.create(CoursesService.class);
	}

	public void loadLectures() {
		this.lecturesServiceAsync.getLectures(this.course.getId(),
				new AsyncCallback<ArrayList<Lecture>>() {

					@Override
					public void onSuccess(ArrayList<Lecture> result) {
						// TODO Auto-generated method stub
						leftbar.setLectures(result);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Sorry, please contact with us! Thanks");
					}
				});
	}

	public void loadAssignments() {
		this.assignmentServiceAsync.getAssignmentOfCourse(this.course.getId(),
				new AsyncCallback<ArrayList<Assignment>>() {

					@Override
					public void onSuccess(ArrayList<Assignment> result) {
						// TODO Auto-generated method stub
						leftbar.setAssignments(result);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
	}

	public void loadCourseName() {
		this.coursesServiceAsync.getCourse(this.course.getId(), new AsyncCallback<Course>() {

			@Override
			public void onSuccess(Course result) {
				// TODO Auto-generated method stub
				// rightBar.setCourseInfo(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void loadCourseInfo() {
		this.coursesServiceAsync.getCourse(this.course.getId(), new AsyncCallback<Course>() {

			@Override
			public void onSuccess(Course result) {
				// TODO Auto-generated method stub
				course = result;
				rightbar.setCourseInfo(result);
				leftbar.setCourse(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}
	
	public Course getCourse() {
		return this.course;
	}
}

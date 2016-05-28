package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.LecturesService;
import com.hust.soict.elearning_lannp.client.service.LecturesServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseRightBar;
import com.hust.soict.elearning_lannp.client.ui.lectures.LectureForm;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class EventOfLecuture extends Event {
	private LecturesServiceAsync lecturesServic;
	private LectureForm form;
	private CourseLeftBar leftBar;
	private CourseRightBar rightBar;
	private EventOfLecuture self;
	private Course course;

	public EventOfLecuture() {
		this.lecturesServic = GWT.create(LecturesService.class);
		this.self = this;
	}

	public void setForm(LectureForm form) {
		this.form = form;
	}

	public void setRightBar(CourseRightBar rightBar) {
		this.rightBar = rightBar;
	}

	public void setLeftBar(CourseLeftBar leftBar) {
		this.leftBar = leftBar;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void doCreate(Lecture lecture) {
		// Lecture lecture = new Lecture(name, description, password,
		// course_id);
		lecturesServic.add(lecture, new AsyncCallback<Lecture>() {

			@Override
			public void onSuccess(Lecture result) {
				form.hide();
				if (result == null) {
					Window.alert("Error when insert");
				} else {
					leftBar.addLecture(result);
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("errors, please contact with us");
			}
		});
	}

	public void doUpdate(Lecture lecture) {
		lecturesServic.update(lecture, new AsyncCallback<Lecture>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Lecture result) {
				// TODO Auto-generated method stub
				rightBar.loadLectureInfo(result);
				form.hide();
			}
		});
	}

	public void show(int lecture_id) {
		lecturesServic.getLecture(lecture_id, new AsyncCallback<Lecture>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Lecture result) {
				rightBar.loadLectureInfo(result, self, leftBar);
			}
		});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		lecturesServic.destroy(id, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				History.newItem("courses/"+course.getId());
			}
		});
	}
}

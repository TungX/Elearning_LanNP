package com.hust.soict.elearning_lannp.client.ui.courses;

import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.ui.asignments.Assignment_index;
import com.hust.soict.elearning_lannp.client.ui.attach_files.FileAttaches;
import com.hust.soict.elearning_lannp.client.ui.lectures.Lecture_index;
import com.hust.soict.elearning_lannp.client.ui.shared.PanelDescription;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class CourseRightBar extends Composite {

	private static CourseRightBarUiBinder uiBinder = GWT
			.create(CourseRightBarUiBinder.class);

	interface CourseRightBarUiBinder extends UiBinder<Widget, CourseRightBar> {
	}

	public CourseRightBar() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Text txtCourseName;
	@UiField
	PanelDescription panelDescription;
	@UiField
	Div content;

	public void loadCourseInfo(Course course) {
		txtCourseName.setText(course.getName());
		panelDescription.setUser(course.getUser());
		panelDescription.setContent(course.getDescription());
		Lecture_index lectures = new Lecture_index();
		lectures.setLectures(course.getLectures());
		this.content.add(lectures);
		Assignment_index assignments = new Assignment_index();
		assignments.setAssignments(course.getAssignments());
		this.content.add(assignments);
	}

	public void setLecture(Lecture lecture) {
		FileAttaches fas = new FileAttaches();
		fas.addFiles(lecture.getAttachFiles());
	}
}

package com.hust.soict.elearning_lannp.client.ui.courses;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.*;

public class CourseLeftBar extends Composite {

	private static Course_left_barUiBinder uiBinder = GWT
			.create(Course_left_barUiBinder.class);

	interface Course_left_barUiBinder extends UiBinder<Widget, CourseLeftBar> {
	}

	public CourseLeftBar() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	ListGroup lectures;
	@UiField
	ListGroup assignments;
	@UiField
	ListGroupItem itemAssignmentEmpty;
	@UiField
	ListGroupItem itemLectureEmpty;
//	@UiField
//	Anchor txtCourseName;

	public void addLecture(Lecture lecture) {
		ListGroupItem item = new ListGroupItem();
		Hyperlink link = new Hyperlink(lecture.getName(), "courses/"
				+ lecture.getCourseId() + "/lectures/" + lecture.getId());
		item.add(link);
		lectures.add(item);
	}

//	public void setCourseName(Course course) {
//		txtCourseName.setText(course.getName());
//		txtCourseName.setHref("#courses/" + course.getId());
//	}

	public void setLectures(ArrayList<Lecture> olectures) {
		for (Lecture lecture : olectures)
			addLecture(lecture);
		itemLectureEmpty.setVisible(olectures.isEmpty());
	}

	public void addAssinment(Assignment assignment) {
		ListGroupItem item = new ListGroupItem();
		Hyperlink link = new Hyperlink(assignment.getName(), "courses/"
				+ assignment.getCourseId() + "/assignments/" + assignment.getId());
		item.add(link);
		assignments.add(item);
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		for (Assignment assignment : assignments)
			addAssinment(assignment);
		itemAssignmentEmpty.setVisible(assignments.isEmpty());
	}
}

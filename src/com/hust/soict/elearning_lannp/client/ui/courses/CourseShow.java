package com.hust.soict.elearning_lannp.client.ui.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfCourseShow;

public class CourseShow extends Composite {

	private static Course_showUiBinder uiBinder = GWT
			.create(Course_showUiBinder.class);

	interface Course_showUiBinder extends UiBinder<Widget, CourseShow> {
	}

	public CourseShow() {
		initWidget(uiBinder.createAndBindUi(this));
		EventOfCourseShow event = new EventOfCourseShow(leftbar, rightcontent);
		event.loadLectures();
		event.loadAssignments();
		event.loadCourseName();
		event.loadCourseInfo();
	}

	@UiField
	CourseLeftBar leftbar;
	@UiField
	CourseRightBar rightcontent;
}

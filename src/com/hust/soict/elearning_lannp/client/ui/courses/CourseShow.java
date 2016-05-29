package com.hust.soict.elearning_lannp.client.ui.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfAssignment;

public class CourseShow extends Composite {

	private static Course_showUiBinder uiBinder = GWT.create(Course_showUiBinder.class);

	interface Course_showUiBinder extends UiBinder<Widget, CourseShow> {
	}

	public CourseShow() {
		initWidget(uiBinder.createAndBindUi(this));
		// new EventOfCourse(leftbar, rightcontent,
		// breadCrumbs, 1);
		// Course course = new Course(1);
		// EventOfLecuture event = new EventOfLecuture();
		// event.setRightBar(this.rightcontent);
		// event.setLeftBar(this.leftbar);
		// event.setCourse(course);
		// event.show(13);
		EventOfAssignment event = new EventOfAssignment(leftbar, null);
		event.setRightBar(rightcontent);
		event.show(4);
	}

	@UiField
	CourseLeftBar leftbar;
	@UiField
	CourseRightBar rightcontent;

}

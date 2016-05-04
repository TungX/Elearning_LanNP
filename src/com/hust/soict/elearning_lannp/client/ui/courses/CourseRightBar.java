package com.hust.soict.elearning_lannp.client.ui.courses;

import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.Course;

public class CourseRightBar extends Composite {

	private static CourseRightBarUiBinder uiBinder = GWT
			.create(CourseRightBarUiBinder.class);

	interface CourseRightBarUiBinder extends UiBinder<Widget, CourseRightBar> {
	}

	public CourseRightBar() {
		initWidget(uiBinder.createAndBindUi(this));
		txtDescription
				.setText("I am new to GWT and can not find an answer to this: I have got a nice UIBinder for a TextBox, it works, I have UIHandler working with it, ok. But what if I want to show a value from this TextBox all over my HTML? Is there a way to declare one variable to reuse this value all over HTML, or should i declare new Label with new ui:field name every time I want to show the value on one html page, and fill every such a Label with UIHandler (wich I could do right away, but this seems really boring)?");
	}

	@UiField
	Text txtCourseName;
	@UiField
	Text txtDescription;
	@UiField
	Text txtTeacherName;

	public void setCourseInfo(Course course) {
		txtCourseName.setText(course.getName());
		txtTeacherName.setText(course.getUser().getDisplayName());
		txtDescription.setText(course.getDescription());
	}
}

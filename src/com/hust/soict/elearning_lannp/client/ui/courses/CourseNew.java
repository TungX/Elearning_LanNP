package com.hust.soict.elearning_lannp.client.ui.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CourseNew extends Composite {

	private static Course_newUiBinder uiBinder = GWT.create(Course_newUiBinder.class);

	interface Course_newUiBinder extends UiBinder<Widget, CourseNew> {
	}

	public CourseNew() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

package com.hust.soict.elearning_lannp.client.ui.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CourseDestroy extends Composite {

	private static Course_destroyUiBinder uiBinder = GWT.create(Course_destroyUiBinder.class);

	interface Course_destroyUiBinder extends UiBinder<Widget, CourseDestroy> {
	}

	public CourseDestroy() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

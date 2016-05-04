package com.hust.soict.elearning_lannp.client.ui.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CourseEdit extends Composite {

	private static Course_editUiBinder uiBinder = GWT.create(Course_editUiBinder.class);

	interface Course_editUiBinder extends UiBinder<Widget, CourseEdit> {
	}

	public CourseEdit() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

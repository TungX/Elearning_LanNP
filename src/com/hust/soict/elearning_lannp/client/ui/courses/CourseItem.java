package com.hust.soict.elearning_lannp.client.ui.courses;

import org.gwtbootstrap3.client.ui.*;
import org.gwtbootstrap3.client.ui.html.Text;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.hust.soict.elearning_lannp.shared.model.Course;

public class CourseItem extends Composite {

	private static Course_itemUiBinder uiBinder = GWT
			.create(Course_itemUiBinder.class);

	interface Course_itemUiBinder extends UiBinder<Widget, CourseItem> {
	}

	public CourseItem() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Heading txtTitle;

	@UiField
	Text txtDescription;

	public void setContent(Course course) {		
		Hyperlink link = new Hyperlink(course.getName(), "courses/"+course.getId());
		txtTitle.add(link);
		txtDescription.setText(course.getDescription());
	}
}

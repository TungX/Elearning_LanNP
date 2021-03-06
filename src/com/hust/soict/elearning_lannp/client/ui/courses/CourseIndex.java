package com.hust.soict.elearning_lannp.client.ui.courses;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfCourse;
import com.hust.soict.elearning_lannp.client.event.EventOfCourseIndex;
import com.hust.soict.elearning_lannp.shared.model.Course;

public class CourseIndex extends Composite {
	private EventOfCourseIndex event;
	private static Course_indexUiBinder uiBinder = GWT.create(Course_indexUiBinder.class);

	interface Course_indexUiBinder extends UiBinder<Widget, CourseIndex> {
	}

	@UiField
	PanelGroup courses;

	public CourseIndex() {
		initWidget(uiBinder.createAndBindUi(this));
		event = new EventOfCourseIndex(this);
	}

	void addCourse(Course course) {
		CourseItem item = new CourseItem();
		item.setContent(course);
		courses.add(item);
	}

	public void setCourses(ArrayList<Course> courses) {
		for (Course course : courses) {
			addCourse(course);
		}
	}

	public CourseIndex loadCourse() {
		this.courses.clear();
		event.loadCourses();
		return this;
	}

	public CourseIndex loadCourse(int user_id) {
		this.courses.clear();
		event.loadCourses(user_id);
		return this;
	}

	@UiField
	Anchor linkAddCourse;

	@UiHandler("linkAddCourse")
	void onLinkAddCourseClick(ClickEvent e) {
		CourseForm form = new CourseForm(new EventOfCourse(), new Course());
		form.setTitle("Add course");
		form.show();
	}

	public void hideAddCourse() {
		this.linkAddCourse.setVisible(false);
	}

	public void showAddCourse() {
		this.linkAddCourse.setVisible(true);
	}
}

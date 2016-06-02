package com.hust.soict.elearning_lannp.client.ui.courses;

import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Breadcrumbs;
import org.gwtbootstrap3.client.ui.html.Div;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfAssignment;
import com.hust.soict.elearning_lannp.client.event.EventOfCourse;
import com.hust.soict.elearning_lannp.client.event.EventOfLecuture;
import com.hust.soict.elearning_lannp.client.ui.asignments.AssignmentForm;
import com.hust.soict.elearning_lannp.client.ui.asignments.Assignment_index;
import com.hust.soict.elearning_lannp.client.ui.attach_files.FileAttaches;
import com.hust.soict.elearning_lannp.client.ui.lectures.LectureForm;
import com.hust.soict.elearning_lannp.client.ui.lectures.Lecture_index;
import com.hust.soict.elearning_lannp.client.ui.shared.PanelDescription;
import com.hust.soict.elearning_lannp.shared.model.Assignment;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class CourseRightBar extends Composite {

	private static CourseRightBarUiBinder uiBinder = GWT.create(CourseRightBarUiBinder.class);

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
	@UiField
	Breadcrumbs breadCrumbs;

	public void clearContent() {
		this.content.clear();
	}

	public void loadCourseInfo(Course course, EventOfCourse event) {
		CourseForm form = new CourseForm(event, course);
		form.setTitle("Add " + course.getName());
		clearContent();
		txtCourseName.setText(course.getName());
		panelDescription.setUser(course.getUser());
		panelDescription.setContent(course.getDescription());
		panelDescription.setForm(form);
		panelDescription.setId(course.getId());
		panelDescription.setEvent(event);
		panelDescription.setTitleDelete("Delete " + course.getName());
		Lecture_index lectures = new Lecture_index();
		lectures.setLectures(course.getLectures());
		this.content.add(lectures);
		Assignment_index assignments = new Assignment_index();
		assignments.setAssignments(course.getAssignments());
		this.content.add(assignments);
		loadBreadcrumbs(course);
	}

	public void loadCourseInfo(Course course) {
		txtCourseName.setText(course.getName());
		panelDescription.setContent(course.getDescription());
		loadBreadcrumbs(course);

	}

	public FileAttaches setLecture(Lecture lecture) {
		FileAttaches fas = new FileAttaches();
		fas.addFiles(lecture.getAttachFiles());
		return fas;
	}

	public void loadLectureInfo(Lecture lecture, EventOfLecuture event, CourseLeftBar leftBar) {
		LectureForm form = new LectureForm(leftBar, lecture);
		form.setEvent(event);
		clearContent();
		form.setTitle("Update " + lecture.getName());
		txtCourseName.setText(lecture.getName());
		panelDescription.setUser(lecture.getCourse().getUser());
		panelDescription.setContent(lecture.getDescription());
		panelDescription.setForm(form);
		panelDescription.setId(lecture.getId());
		panelDescription.setEvent(event);
		panelDescription.setTitleDelete("Delete " + lecture.getName());
		FileAttaches fas = setLecture(lecture);
		fas.loadInfo(lecture.getCourse().getUser().getId(), lecture.getId());
		content.add(fas);
		event.setForm(form);
		loadBreadcrumbs(lecture);
	}

	public void loadLectureInfo(Lecture lecture) {
		txtCourseName.setText(lecture.getName());
		panelDescription.setContent(lecture.getDescription());
		loadBreadcrumbs(lecture);
	}

	public void loadAssignmentInfo(Assignment assignment, EventOfAssignment event, CourseLeftBar leftbar) {
		clearContent();
		AssignmentForm form = new AssignmentForm(leftbar);
		form.setAssignment(assignment);
		form.setEvent(event);
		event.setForm(form);
		event.setAssignment(assignment);
		txtCourseName.setText(assignment.getName());
		panelDescription.setUser(assignment.getCourse().getUser());
		panelDescription.setContent(assignment.getDescription());
		panelDescription.setForm(form);
		panelDescription.setId(assignment.getId());
		panelDescription.setEvent(event);
		panelDescription.setTitleDelete("Delete " + assignment.getName());
		loadBreadcrumbs(assignment);
	}

	public void loadAssignmentInfo(Assignment assignment) {
		panelDescription.setContent(assignment.getDescription());
		txtCourseName.setText(assignment.getName());
		loadBreadcrumbs(assignment);
	}

	private void loadBreadcrumbs(Course course) {
		breadCrumbs.clear();
		AnchorListItem itemCourse = new AnchorListItem(course.getName());
		itemCourse.setHref("#courses/" + course.getId());
		breadCrumbs.add(itemCourse);
	}

	private void loadBreadcrumbs(Lecture lecture) {
		loadBreadcrumbs(lecture.getCourse());
		AnchorListItem itemCourse = new AnchorListItem(lecture.getName());
		itemCourse.setHref("#courses/" + lecture.getCourse().getId() + "/lectures/" + lecture.getId());
		breadCrumbs.add(itemCourse);
	}

	private void loadBreadcrumbs(Assignment assignment) {
		loadBreadcrumbs(assignment.getCourse());
		AnchorListItem itemCourse = new AnchorListItem(assignment.getName());
		itemCourse.setHref("#courses/" + assignment.getCourse().getId() + "/lectures/" + assignment.getId());
		breadCrumbs.add(itemCourse);
	}
}

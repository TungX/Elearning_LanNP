package com.hust.soict.elearning_lannp.client.ui.courses;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfUser;
import com.hust.soict.elearning_lannp.client.ui.asignments.AssignmentForm;
import com.hust.soict.elearning_lannp.client.ui.lectures.LectureForm;
import com.hust.soict.elearning_lannp.client.ui.shared.FormDelete;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.*;

public class CourseLeftBar extends Composite {

	private Course course;
	private EventOfUser event;

	private static Course_left_barUiBinder uiBinder = GWT.create(Course_left_barUiBinder.class);

	interface Course_left_barUiBinder extends UiBinder<Widget, CourseLeftBar> {
	}

	public CourseLeftBar() {
		initWidget(uiBinder.createAndBindUi(this));
		this.course = new Course();
	}

	@UiField
	ListGroup lectures;
	@UiField
	ListGroup assignments;
	@UiField
	ListGroupItem itemAssignmentEmpty;
	@UiField
	ListGroupItem itemLectureEmpty;
	@UiField
	Anchor addLecture;
	@UiField
	Anchor addAssignment;
	@UiField
	Anchor btnHome;
	@UiField
	Anchor btnLeave;
	@UiField
	Anchor btnJoin;
	@UiField
	Panel panelLeave;
	@UiField
	Panel panelJoin;

	public void setEvent(EventOfUser event) {
		this.event = event;
	}

	public void checkAdmin() {
		if (Store.user.isTeacher() || Store.isAdmin()) {
			this.panelLeave.removeFromParent();
			this.panelJoin.removeFromParent();
		} else {
			this.addAssignment.getParent().removeFromParent();
			this.addLecture.getParent().removeFromParent();
			joinCourse(Store.isInCourse());
		}
	}

	@UiHandler("btnJoin")
	void onBtnJoinClick(ClickEvent e) {
		this.event.join(Store.user.getId(), Store.course.getId());
		joinCourse(true);
	}

	@UiHandler("btnLeave")
	void onBtnLeaveClick(ClickEvent e) {
		FormDelete form = new FormDelete(event, 0);
		form.setTitle("Leave " + Store.course.getName());
		form.show();
	}

	@UiHandler("btnHome")
	void onBtnHomeClick(ClickEvent e) {
		History.newItem("courses/" + this.course.getId());
	}

	@UiHandler("addLecture")
	void onItemAddLecutureClick(ClickEvent e) {
		LectureForm addLecture = new LectureForm(this, new Lecture(this.course));
		addLecture.setTitle(this.course.getName() + "/Add Lecture");
		addLecture.show();
	}

	@UiHandler("addAssignment")
	void onItemAddAssignmentClick(ClickEvent e) {
		AssignmentForm addAssignment = new AssignmentForm(this);
		addAssignment.setTitleModal(this.course.getName() + "/Add Assignment");
		addAssignment.show();
	}

	public void joinCourse(boolean value) {
		this.panelJoin.setVisible(!value);
		this.panelLeave.setVisible(value);
	}

	public void addLecture(Lecture lecture) {
		ListGroupItem item = new ListGroupItem();
		Hyperlink link = new Hyperlink(lecture.getName(),
				"courses/" + lecture.getCourseId() + "/lectures/" + lecture.getId());
		item.add(link);
		lectures.add(item);
	}

	public void setLectures(ArrayList<Lecture> olectures) {
		this.lectures.clear();
		this.lectures.add(itemAssignmentEmpty);
		for (Lecture lecture : olectures)
			addLecture(lecture);
		itemLectureEmpty.setVisible(olectures.isEmpty() && !Store.isAdmin());
	}

	public void addAssinment(Assignment assignment) {
		ListGroupItem item = new ListGroupItem();
		Hyperlink link = new Hyperlink(assignment.getName(),
				"courses/" + assignment.getCourseId() + "/assignments/" + assignment.getId());
		item.add(link);
		assignments.add(item);
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments.clear();
		this.assignments.add(itemAssignmentEmpty);
		for (Assignment assignment : assignments)
			addAssinment(assignment);
		itemAssignmentEmpty.setVisible(assignments.isEmpty() && !Store.isAdmin());
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}

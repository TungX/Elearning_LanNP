package com.hust.soict.elearning_lannp.client.ui.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfAssignment;
import com.hust.soict.elearning_lannp.client.event.EventOfComment;
import com.hust.soict.elearning_lannp.client.event.EventOfCourse;
import com.hust.soict.elearning_lannp.client.event.EventOfLecuture;
import com.hust.soict.elearning_lannp.client.event.EventOfUser;
import com.hust.soict.elearning_lannp.client.ui.comments.Comments;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.Comment;
import com.hust.soict.elearning_lannp.shared.model.Course;

public class CourseShow extends Composite {

	private static Course_showUiBinder uiBinder = GWT
			.create(Course_showUiBinder.class);
	private EventOfComment eventOfComment;

	interface Course_showUiBinder extends UiBinder<Widget, CourseShow> {
	}

	public CourseShow() {
		initWidget(uiBinder.createAndBindUi(this));
		this.eventOfComment = new EventOfComment();
	}

	@UiField
	CourseLeftBar leftbar;
	@UiField
	CourseRightBar rightcontent;
	@UiField
	Comments comments;

	public void showCourse(int id) {
		comments.loadForm(eventOfComment);
		new EventOfCourse(leftbar, rightcontent, id);
		Store.loadInfoComment(Comment.COURSE, id);
		eventOfComment.loadComment();
	}

	public void showLecture(Course course, int id) {
		EventOfLecuture event = new EventOfLecuture();
		event.setRightBar(this.rightcontent);
		event.setLeftBar(this.leftbar);
		event.setCourse(course);
		event.show(id);
		Store.loadInfoComment(Comment.LECTURE, id);
		eventOfComment.loadComment();
	}

	public void showAssignment(int id) {
		EventOfAssignment event = new EventOfAssignment(leftbar, null);
		event.setRightBar(rightcontent);
		event.show(id);
		Store.loadInfoComment(Comment.ASSIGNMENT, id);
		eventOfComment.loadComment();
	}

	public void setEventOfUser(EventOfUser event) {
		leftbar.setEvent(event);
	}
}

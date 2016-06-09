package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.AssignmentService;
import com.hust.soict.elearning_lannp.client.service.AssignmentServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.asignments.AssignmentForm;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseRightBar;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.Assignment;
import com.hust.soict.elearning_lannp.shared.model.Course;

public class EventOfAssignment extends Event {
	private CourseLeftBar leftBar;
	private AssignmentForm form;
	private AssignmentServiceAsync assignmentService;
	private CourseRightBar rightBar;
	private EventOfAssignment self;
	private Assignment assignment;

	public EventOfAssignment(CourseLeftBar leftBar, AssignmentForm form) {
		this.leftBar = leftBar;
		this.form = form;
		this.assignmentService = GWT.create(AssignmentService.class);
		this.self = this;
		this.assignment = new Assignment();
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public void setCourse(Course course) {
		this.assignment.setCourse(course);
		this.assignment.setCourseId(course.getId());
	}

	public void setForm(AssignmentForm form) {
		this.form = form;
	}

	public void setRightBar(CourseRightBar rightBar) {
		this.rightBar = rightBar;
	}

	public void doCreate(Assignment assignment) {
		assignment.setCourseId(Store.course.getId());
		this.assignmentService.addAssignment(assignment,
				new AsyncCallback<Assignment>() {

					@Override
					public void onSuccess(Assignment result) {
						// TODO Auto-generated method stub
						leftBar.addAssinment(result);
						form.hide();
						History.newItem("courses/" + result.getCourseId()
								+ "/assignments/" + result.getId());
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("errors, please contact with us");
					}
				});
	}

	public void doUpdate(Assignment assignment) {
		this.assignmentService.updateAssignment(assignment,
				new AsyncCallback<Assignment>() {

					@Override
					public void onSuccess(Assignment result) {
						// TODO Auto-generated method stub
						rightBar.loadAssignmentInfo(result);
						form.hide();
						leftBar.updateUi(result);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
	}

	public void show(int id) {
		this.assignmentService.getAssignment(id,
				new AsyncCallback<Assignment>() {

					@Override
					public void onSuccess(Assignment result) {
						// TODO Auto-generated method stub
						rightBar.loadAssignmentInfo(result, self, leftBar);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
	}

	@Override
	public void delete(int id) {
		this.assignmentService.destroyAssigment(id, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				History.newItem("Courses/" + assignment.getCourseId());
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}
}

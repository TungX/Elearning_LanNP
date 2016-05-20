package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.AssignmentService;
import com.hust.soict.elearning_lannp.client.service.AssignmentServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.asignments.FormAssignment;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.shared.model.Assignment;

public class EventOfAssignment {
	private CourseLeftBar leftBar;
	private FormAssignment form;
	private AssignmentServiceAsync assignmentService;
	public EventOfAssignment (CourseLeftBar leftBar, FormAssignment form) {
		this.leftBar = leftBar;
		this.form = form;
		this.assignmentService = GWT.create(AssignmentService.class);
	}
	
	public void doSave(String name, String description, String deadline, int course_id){
		Assignment assignment = new Assignment(name, description, deadline, course_id);
		this.assignmentService.addAssignment(assignment, new AsyncCallback<Assignment>() {
			
			@Override
			public void onSuccess(Assignment result) {
				// TODO Auto-generated method stub
				leftBar.addAssinment(result);
				form.hideModal();
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("errors, please contact with us");
			}
		});
	}
}

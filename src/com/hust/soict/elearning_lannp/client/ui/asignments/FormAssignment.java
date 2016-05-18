package com.hust.soict.elearning_lannp.client.ui.asignments;

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class FormAssignment extends Composite {

	private static FormAssignmentUiBinder uiBinder = GWT.create(FormAssignmentUiBinder.class);

	interface FormAssignmentUiBinder extends UiBinder<Widget, FormAssignment> {
	}

	public FormAssignment() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
	}
	
	@UiField Modal modalAddAssignment;
	
	public void showModal() {
		modalAddAssignment.show();
	}
	
	public void hideModal() {
		modalAddAssignment.hide();
	}
	
	public void setTitleModal(String title){
		modalAddAssignment.setTitle(title);
	}
}

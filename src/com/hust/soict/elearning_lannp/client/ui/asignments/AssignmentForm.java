package com.hust.soict.elearning_lannp.client.ui.asignments;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfAssignment;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.shared.model.Assignment;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;

public class AssignmentForm extends FormInputAbastract {

	private static FormAssignmentUiBinder uiBinder = GWT.create(FormAssignmentUiBinder.class);
	private EventOfAssignment event;
	private Assignment assignment;

	interface FormAssignmentUiBinder extends UiBinder<Widget, AssignmentForm> {
	}

	public AssignmentForm(CourseLeftBar leftBar, Assignment assignment) {
		initWidget(uiBinder.createAndBindUi(this));
		this.event = new EventOfAssignment(leftBar, this);
		RootPanel.get().add(this);
		this.assignment = assignment;
		loadAssignment();
	}

	@UiField
	Modal modalAddAssignment;
	@UiField
	Button btnSave;
	@UiField
	TextBox txtName;
	@UiField
	TextArea txtDescription;
	
	public void setEvent(EventOfAssignment event){
		this.event = event;
	}

	public void setTitleModal(String title) {
		this.modalAddAssignment.setTitle(title);
	}

	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e) {
		String name = txtName.getText();
		String description = txtDescription.getText().replaceAll("\n", "<br/>");
		this.assignment.setName(name);
		this.assignment.setDescription(description);
		if (assignment.getId() == 0)
			event.doCreate(assignment);
		else
			event.doUpdate(assignment);
	}

	public void loadAssignment() {
		this.txtName.setText(assignment.getName());
		this.txtDescription.setText(assignment.getDescription().replace("<br/>", "\n"));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.modalAddAssignment.show();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		this.modalAddAssignment.hide();
	}
}
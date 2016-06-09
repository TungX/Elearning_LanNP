package com.hust.soict.elearning_lannp.client.ui.asignments;

import java.util.HashMap;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.hust.soict.elearning_lannp.client.event.EventOfAssignment;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.shared.model.Assignment;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;

public class AssignmentForm extends FormInputAbastract {

	private static FormAssignmentUiBinder uiBinder = GWT
			.create(FormAssignmentUiBinder.class);
	private EventOfAssignment event;
	private Assignment assignment;

	interface FormAssignmentUiBinder extends UiBinder<Widget, AssignmentForm> {
	}

	public AssignmentForm(CourseLeftBar leftBar) {
		initWidget(uiBinder.createAndBindUi(this));
		this.event = new EventOfAssignment(leftBar, this);
		RootPanel.get().add(this);
		this.assignment = new Assignment();
		loadAssignment();
		this.errors = new HashMap<String, Span>();
		this.errors.put("name", requiredName);
		this.errors.put("password_confirm", requiredDescription);
	}

	@UiField
	Modal modalAddAssignment;
	@UiField
	Button btnSave;
	@UiField
	TextBox txtName;
	@UiField
	TextArea txtDescription;
	@UiField
	Span requiredName;
	@UiField
	Span requiredDescription;

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
		loadAssignment();
	}

	public void setEvent(EventOfAssignment event) {
		this.event = event;
	}

	public void setTitleModal(String title) {
		this.modalAddAssignment.setTitle(title);
	}

	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e) {
		this.clearError();
		String name = txtName.getText();
		String description = txtDescription.getText().replaceAll("\n", "<br/>");
		this.assignment.setName(name);
		this.assignment.setDescription(description);
		if (!this.assignment.validate()) {
			this.printError(this.assignment.getErros());
			return;
		}
		if (assignment.getId() == 0)
			event.doCreate(assignment);
		else
			event.doUpdate(assignment);
	}

	public void loadAssignment() {
		this.txtName.setText(assignment.getName());
		this.txtDescription.setText(assignment.getDescription().replace(
				"<br/>", "\n"));
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
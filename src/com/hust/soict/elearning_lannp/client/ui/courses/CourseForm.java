package com.hust.soict.elearning_lannp.client.ui.courses;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfCourse;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;

public class CourseForm extends FormInputAbastract {

	private static FormUiBinder uiBinder = GWT.create(FormUiBinder.class);
	private EventOfCourse event;
	private Course course;

	interface FormUiBinder extends UiBinder<Widget, CourseForm> {
	}

	public CourseForm(EventOfCourse event, Course course) {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		this.event = event;
		this.course = course;
		this.txtDescription.setText(course.getDescription().replaceAll("<br/>", "\n"));
		this.txtName.setText(course.getName());
	}

	@UiField
	TextBox txtName;
	@UiField
	TextArea txtDescription;
	@UiField
	Input txtPassword;
	@UiField
	Modal modalInputCourse;
	@UiField
	Button btnSave;

	@Override
	public void show() {
		this.modalInputCourse.show();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		this.modalInputCourse.hide();
	}

	public void setTitle(String title) {
		this.modalInputCourse.setTitle(title);
	}
	
	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e){
		String name = txtName.getText();
		String description = txtDescription.getText().replaceAll("\n", "<br/>");
		String password = txtPassword.getText();
		course.updateInfo(name, description, password);
		event.update(course);
		hide();
	}

}

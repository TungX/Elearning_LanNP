package com.hust.soict.elearning_lannp.client.ui.lectures;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfLecuture;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;

public class FormLecture extends Composite {

	private static FormAddLectureUiBinder uiBinder = GWT
			.create(FormAddLectureUiBinder.class);
	private EventOfLecuture event;
	private int course_id;

	interface FormAddLectureUiBinder extends UiBinder<Widget, FormLecture> {
	}

	public FormLecture(CourseLeftBar leftBar, int course_id) {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		event = new EventOfLecuture();
		this.course_id = course_id;
		event.setForm(this);
		event.setLeftBar(leftBar);
	}

	@UiField
	TextBox txtName;
	@UiField
	TextArea txtDescription;
	@UiField
	Input txtPassword;
	@UiField
	Modal modalAddLecture;

	public void showModal() {
		this.modalAddLecture.show();
	}

	public void setTitleModal(String title) {
		this.modalAddLecture.setTitle(title);
	}

	public void hideModal() {
		this.modalAddLecture.hide();
	}

	@UiField
	Button btnSave;

	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e) {
		event.doCreate(txtName.getText(), txtDescription.getText(), txtPassword.getText(), this.course_id);
	}
}

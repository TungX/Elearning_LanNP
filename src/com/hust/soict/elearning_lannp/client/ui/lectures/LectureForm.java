package com.hust.soict.elearning_lannp.client.ui.lectures;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfLecuture;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class LectureForm extends FormInputAbastract {

	private static FormAddLectureUiBinder uiBinder = GWT.create(FormAddLectureUiBinder.class);
	private EventOfLecuture event;
	private Lecture lecture;

	interface FormAddLectureUiBinder extends UiBinder<Widget, LectureForm> {
	}

	public LectureForm(CourseLeftBar leftBar, Lecture lecture) {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		this.event = new EventOfLecuture();
		event.setForm(this);
		this.lecture = lecture;
		event.setLeftBar(leftBar);
		this.txtName.setText(this.lecture.getName());
		this.txtDescription.setText((this.lecture.getDescription()).replaceAll("<br/>", "\n"));
		this.txtPassword.setText(this.lecture.getPassword());
	}

	@UiField
	TextBox txtName;
	@UiField
	TextArea txtDescription;
	@UiField
	Input txtPassword;
	@UiField
	Modal modalLecture;
	
	public void setEvent(EventOfLecuture event){
		this.event = event;
	}

	public void setTitle(String title) {
		this.modalLecture.setTitle(title);
	}

	@UiField
	Button btnSave;

	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e) {
		String name = txtName.getText();
		String description = txtDescription.getText().replaceAll("\n", "<br/>");
		String password = txtPassword.getText();
		this.lecture.setInfo(name, description, password);
		if (this.lecture.getId() == 0)
			event.doCreate(this.lecture);
		else
			event.doUpdate(this.lecture);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.modalLecture.show();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		this.modalLecture.hide();
	}
}

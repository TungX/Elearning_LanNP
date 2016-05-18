package com.hust.soict.elearning_lannp.client.ui.courses;

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class FormLecture extends Composite {

	private static FormAddLectureUiBinder uiBinder = GWT
			.create(FormAddLectureUiBinder.class);

	interface FormAddLectureUiBinder extends UiBinder<Widget, FormLecture> {
	}

	public FormLecture() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
	}
	@UiField Modal modalAddLecture;
	public void showModal() {
		this.modalAddLecture.show();
	}
	
	public void setTitleModal(String title) {
		this.modalAddLecture.setTitle(title);
	}
	
	public void hideModal() {
		this.modalAddLecture.hide();
	}
}

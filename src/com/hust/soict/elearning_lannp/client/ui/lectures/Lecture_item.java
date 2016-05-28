package com.hust.soict.elearning_lannp.client.ui.lectures;

import org.gwtbootstrap3.client.ui.Anchor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class Lecture_item extends Composite {

	private static Lecture_itemUiBinder uiBinder = GWT
			.create(Lecture_itemUiBinder.class);

	interface Lecture_itemUiBinder extends UiBinder<Widget, Lecture_item> {
	}

	public Lecture_item() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Anchor url;

	public void setLecture(Lecture lecture) {
		this.url.setText(lecture.getName());
		this.url.setHref("#courses/" + lecture.getCourseId() + "/lectures/"
				+ lecture.getId());
	}
}

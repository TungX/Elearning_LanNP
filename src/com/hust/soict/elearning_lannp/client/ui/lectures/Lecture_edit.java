package com.hust.soict.elearning_lannp.client.ui.lectures;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Lecture_edit extends Composite {

	private static Lecture_editUiBinder uiBinder = GWT
			.create(Lecture_editUiBinder.class);

	interface Lecture_editUiBinder extends UiBinder<Widget, Lecture_edit> {
	}

	public Lecture_edit() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

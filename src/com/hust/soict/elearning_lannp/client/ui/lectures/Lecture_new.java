package com.hust.soict.elearning_lannp.client.ui.lectures;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Lecture_new extends Composite {

	private static Lecture_newUiBinder uiBinder = GWT
			.create(Lecture_newUiBinder.class);

	interface Lecture_newUiBinder extends UiBinder<Widget, Lecture_new> {
	}

	public Lecture_new() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

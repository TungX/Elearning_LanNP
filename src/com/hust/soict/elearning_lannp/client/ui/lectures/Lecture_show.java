package com.hust.soict.elearning_lannp.client.ui.lectures;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Lecture_show extends Composite {

	private static Lecture_showUiBinder uiBinder = GWT
			.create(Lecture_showUiBinder.class);

	interface Lecture_showUiBinder extends UiBinder<Widget, Lecture_show> {
	}

	public Lecture_show() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

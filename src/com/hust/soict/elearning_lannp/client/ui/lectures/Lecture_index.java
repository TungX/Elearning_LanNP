package com.hust.soict.elearning_lannp.client.ui.lectures;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Lecture_index extends Composite {

	private static Lectures_indexUiBinder uiBinder = GWT
			.create(Lectures_indexUiBinder.class);

	interface Lectures_indexUiBinder extends UiBinder<Widget, Lecture_index> {
	}

	public Lecture_index() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

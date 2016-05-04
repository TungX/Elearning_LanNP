package com.hust.soict.elearning_lannp.client.ui.lectures;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Lecture_item extends Composite {

	private static Lecture_itemUiBinder uiBinder = GWT
			.create(Lecture_itemUiBinder.class);

	interface Lecture_itemUiBinder extends UiBinder<Widget, Lecture_item> {
	}

	public Lecture_item() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

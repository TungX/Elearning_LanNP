package com.hust.soict.elearning_lannp.client.ui.lectures;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.PanelGroup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class Lecture_index extends Composite {

	private static Lectures_indexUiBinder uiBinder = GWT
			.create(Lectures_indexUiBinder.class);

	interface Lectures_indexUiBinder extends UiBinder<Widget, Lecture_index> {
	}

	public Lecture_index() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField PanelGroup lectures;
	
	public void setLectures(ArrayList<Lecture> lectures){
		for(Lecture lecture: lectures){
			addLecture(lecture);
		}
	}
	
	public void addLecture(Lecture lecture){
		Lecture_item item = new Lecture_item();
		item.setLecture(lecture);
		this.lectures.add(item);
	}
}

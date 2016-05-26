package com.hust.soict.elearning_lannp.client.ui.asignments;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.PanelGroup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.Assignment;

public class Assignment_index extends Composite {

	private static Assignment_indexUiBinder uiBinder = GWT
			.create(Assignment_indexUiBinder.class);

	interface Assignment_indexUiBinder extends
			UiBinder<Widget, Assignment_index> {
	}

	public Assignment_index() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	PanelGroup assignments;

	public void setAssignments(ArrayList<Assignment> assignments) {
		for (Assignment assignment : assignments) {
			addAssignment(assignment);
		}
	}

	public void addAssignment(Assignment assignment) {
		Assignment_item item = new Assignment_item();
		item.setLecture(assignment);
		this.assignments.add(item);
	}
}

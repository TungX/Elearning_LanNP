package com.hust.soict.elearning_lannp.client.ui.asignments;

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.PanelBody;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.Assignment;

public class Assignment_item extends Composite {

	private static Assignment_itemUiBinder uiBinder = GWT
			.create(Assignment_itemUiBinder.class);

	interface Assignment_itemUiBinder extends UiBinder<Widget, Assignment_item> {
	}

	public Assignment_item() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Anchor url;
	@UiField
	Anchor btnContent;
	@UiField
	Text description;
	@UiField
	PanelBody body;

	public void setLecture(Assignment assignment) {
		this.url.setText(assignment.getName());
		this.url.setHref("#courses/" + assignment.getCourseId()
				+ "/assignments/" + assignment.getId());
		this.description.setText(assignment.getDescription());
	}

	@UiHandler("btnContent")
	void onBtnContent(ClickEvent e) {
		if (this.body.isVisible()) {
			this.body.setVisible(false);
		} else {
			this.body.setVisible(true);
		}
	}
}

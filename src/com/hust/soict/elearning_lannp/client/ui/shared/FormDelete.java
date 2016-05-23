package com.hust.soict.elearning_lannp.client.ui.shared;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.Event;

public class FormDelete extends Composite {

	private static FormDeleteUiBinder uiBinder = GWT
			.create(FormDeleteUiBinder.class);
	private Event event;

	interface FormDeleteUiBinder extends UiBinder<Widget, FormDelete> {
	}

	public FormDelete(Event event) {
		initWidget(uiBinder.createAndBindUi(this));
		this.event = event;
	}

	@UiField
	Modal modalDelete;
	@UiField
	Text content;
	@UiField
	Button btnOk;

	public void show() {
		this.modalDelete.show();
	}

	public void hide() {
		this.modalDelete.hide();
	}

	public void setTitle(String title) {
		this.modalDelete.setTitle(title);
	}

	public void setContent(String content) {
		this.content.setText(content);
	}

	@UiHandler("btnOk")
	void onBtnOkClick(ClickEvent e) {
		this.event.delete();
		this.modalDelete.hide();
	}
}

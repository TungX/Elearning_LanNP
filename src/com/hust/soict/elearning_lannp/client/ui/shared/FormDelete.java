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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.Event;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class FormDelete extends Composite {

	private static FormDeleteUiBinder uiBinder = GWT
			.create(FormDeleteUiBinder.class);
	private Event event;
	private AttachFile attachFile;

	interface FormDeleteUiBinder extends UiBinder<Widget, FormDelete> {
	}

	public FormDelete(Event event, AttachFile attachFile) {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		this.event = event;
		this.attachFile = attachFile;
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
		this.event.delete(attachFile.getId());
		this.modalDelete.hide();
	}
}

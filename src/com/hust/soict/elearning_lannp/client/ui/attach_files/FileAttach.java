package com.hust.soict.elearning_lannp.client.ui.attach_files;

import org.gwtbootstrap3.client.ui.Anchor;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfAttachFile;
import com.hust.soict.elearning_lannp.client.ui.shared.FormDelete;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class FileAttach extends Composite {

	private static FileAttachUiBinder uiBinder = GWT.create(FileAttachUiBinder.class);
	private AttachFile attachFile;
	interface FileAttachUiBinder extends UiBinder<Widget, FileAttach> {
	}

	public FileAttach() {
		initWidget(uiBinder.createAndBindUi(this));
		this.attachFile = null;
	}

	@UiField
	Anchor url;
	@UiField
	Anchor btnRemove;
	@UiField
	Anchor btnEdit;

	public void setFile(AttachFile file) {
		url.setHref(file.getPath());
		url.setText(file.getName());
		this.attachFile = file;
	}
	
	@UiHandler("btnEdit")
	void onBtnEditClick(ClickEvent e){
		AttachForm form = new AttachForm(this);
		form.setAttachFile(attachFile);
		form.show();
	}
	
	@UiHandler("btnRemove")
	void onBtnRemoveClick(ClickEvent e) {
		EventOfAttachFile event = new EventOfAttachFile(this, null);
		FormDelete form = new FormDelete(event, attachFile);
		form.show();
	}
}

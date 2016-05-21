package com.hust.soict.elearning_lannp.client.ui.attach_files;

import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class AttachForm extends Composite {
	private AttachFile attachFile;
	private static AttachFormUiBinder uiBinder = GWT.create(AttachFormUiBinder.class);

	interface AttachFormUiBinder extends UiBinder<Widget, AttachForm> {
	}

	public AttachForm() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		attachForm.setAction(GWT.getModuleBaseURL() + "fileupload");
		attachForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		attachForm.setMethod(FormPanel.METHOD_POST);
		this.attachFile = null;
		addEventUploadFileChange();
	}

	@UiField
	FormPanel attachForm;
	@UiField
	Modal modalAttachFile;
	@UiField
	TextBox txtName;
	@UiField
	TextBox txtPath;
	@UiField
	FileUpload uploadFile;

	public void submit() {
		attachForm.submit();
	}

	public void show() {
		loadInfo();
		this.modalAttachFile.show();
	}

	public void hide() {
		this.modalAttachFile.hide();
	}

	public void setTitle(String title) {
		this.modalAttachFile.setTitle(title);
	}

	public void setAttachFile(AttachFile attachFile) {
		this.attachFile = attachFile;
		loadInfo();
	}

	private void loadInfo() {
		if (this.attachFile != null) {
			this.setTitle("Edit " + this.attachFile.getName());
			this.txtName.setText(this.attachFile.getName());
			this.txtPath.setText(this.attachFile.getPath());
		}
	}
	
	private void addEventUploadFileChange(){
		this.uploadFile.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				String filename = uploadFile.getFilename();
				filename = filename.substring(filename.lastIndexOf("\\"));
				txtPath.setText("uploads"+filename);
			}
		});
	}
}

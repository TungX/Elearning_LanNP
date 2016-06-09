package com.hust.soict.elearning_lannp.client.ui.attach_files;

import java.util.HashMap;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfAttachFile;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;

public class AttachForm extends FormInputAbastract {
	private AttachFile attachFile;
	private FileAttach fA;
	private FileAttaches fas;
	private static AttachFormUiBinder uiBinder = GWT
			.create(AttachFormUiBinder.class);
	private EventOfAttachFile event;

	interface AttachFormUiBinder extends UiBinder<Widget, AttachForm> {
	}

	public AttachForm(FileAttach fa) {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		attachForm.setAction(GWT.getModuleBaseURL() + "fileupload");
		attachForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		attachForm.setMethod(FormPanel.METHOD_POST);
		this.attachFile = null;
		this.fA = fa;
		this.event = new EventOfAttachFile(fA, this);
		addEventUploadFileChange();
		this.errors = new HashMap<String, Span>();
		this.errors.put("name", requiredName);
		this.errors.put("path", requiredPath);
	}

	@UiField
	Span requiredName;
	@UiField
	Span requiredPath;
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
	@UiField
	Button btnSave;

	public void setFileAttaches(FileAttaches attach_files, AttachFile af) {
		this.fas = attach_files;
		this.attachFile = af;
	}

	public void submit() {
		if (!uploadFile.getFilename().isEmpty())
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
		if (this.attachFile.getId() != 0) {
			this.setTitle("Edit " + this.attachFile.getName());
			this.txtName.setText(this.attachFile.getName());
			this.txtPath.setText(this.attachFile.getPath());
		}
	}

	private void addEventUploadFileChange() {
		this.uploadFile.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				String filename = uploadFile.getFilename();
				if (filename.contains("\\"))
					filename = filename.substring(filename.lastIndexOf("\\") + 1);
				txtPath.setText("uploads/" + filename);
			}
		});
	}

	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e) {
		clearError();
		this.attachFile.setName(txtName.getText());
		this.attachFile.setPath(txtPath.getText());
		if (!this.attachFile.validate()) {
			printError(this.attachFile.getErros());
			return;
		}
		submit();
		if (this.attachFile.getId() == 0)
			this.event.doSave(attachFile, fas);
		else
			this.event.doSave(this.attachFile);
	}
}

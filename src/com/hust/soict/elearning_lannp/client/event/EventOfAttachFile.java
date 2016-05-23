package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.AttachFileService;
import com.hust.soict.elearning_lannp.client.service.AttachFileServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.attach_files.AttachForm;
import com.hust.soict.elearning_lannp.client.ui.attach_files.FileAttach;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class EventOfAttachFile {
	private FileAttach fileAttach;
	private AttachForm form;
	private AttachFileServiceAsync attachFileServiceAsync;

	public EventOfAttachFile(FileAttach fileAttach, AttachForm form) {
		this.fileAttach = fileAttach;
		this.form = form;
		this.attachFileServiceAsync = GWT.create(AttachFileService.class);
	}

	public void doSave(AttachFile attachFile) {
		this.attachFileServiceAsync.update(attachFile,
				new AsyncCallback<AttachFile>() {

					@Override
					public void onSuccess(AttachFile result) {
						fileAttach.setFile(result);
						form.hide();
					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Sorry, this attach file is errors! Pleas contact with us"
								+ caught.getMessage());
					}
				});
	}

}

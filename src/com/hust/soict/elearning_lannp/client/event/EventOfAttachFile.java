package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.AttachFileService;
import com.hust.soict.elearning_lannp.client.service.AttachFileServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.attach_files.AttachForm;
import com.hust.soict.elearning_lannp.client.ui.attach_files.FileAttach;
import com.hust.soict.elearning_lannp.client.ui.attach_files.FileAttaches;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class EventOfAttachFile extends Event {
	private FileAttach fileAttach;
	private AttachForm form;
	private AttachFileServiceAsync attachFileServiceAsync;
	private FileAttaches fileAttaches;

	public EventOfAttachFile(FileAttach fileAttach, AttachForm form) {
		this.fileAttach = fileAttach;
		this.form = form;
		this.attachFileServiceAsync = GWT.create(AttachFileService.class);
	}

	public void doSave(AttachFile attachFile) {
		this.attachFileServiceAsync.update(attachFile, new AsyncCallback<AttachFile>() {

			@Override
			public void onSuccess(AttachFile result) {
				fileAttach.setFile(result);
				form.hide();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Sorry, this attach file is errors! Pleas contact with us");
			}
		});
	}

	public void doSave(AttachFile attachFile, FileAttaches fas) {
		this.fileAttaches = fas;
		this.attachFileServiceAsync.add(attachFile, new AsyncCallback<AttachFile>() {

			@Override
			public void onSuccess(AttachFile result) {
				fileAttaches.addFile(result);
				form.hide();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Sorry, this attach file is errors! Pleas contact with us");
			}
		});
	}

	@Override
	public void delete(int id) {
		this.attachFileServiceAsync.destroy(id, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("Sorry, this attach file is errors! Pleas contact with us");
			}

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub
				fileAttach.removeFromParent();
			}
		});
	}

}

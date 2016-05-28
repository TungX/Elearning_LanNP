package com.hust.soict.elearning_lannp.client.ui.attach_files;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.PanelGroup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class FileAttaches extends Composite {

	private static FileAttachesUiBinder uiBinder = GWT.create(FileAttachesUiBinder.class);

	interface FileAttachesUiBinder extends UiBinder<Widget, FileAttaches> {
	}

	public FileAttaches() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	PanelGroup attach_files;
	
	public void addFiles(ArrayList<AttachFile> files) {
		for(AttachFile file: files) {
			addFile(file);
		}
	}
	
	public void addFile(AttachFile file) {
		FileAttach attach = new FileAttach();
		attach.setFile(file);
		attach_files.add(attach);
		attach_files.setId("attac_file_"+file.getId());
	}
}

package com.hust.soict.elearning_lannp.client.ui.attach_files;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.PanelGroup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;

public class FileAttaches extends Composite {

	private static FileAttachesUiBinder uiBinder = GWT.create(FileAttachesUiBinder.class);
	private int user_id;
	private int lecture_id;

	interface FileAttachesUiBinder extends UiBinder<Widget, FileAttaches> {
	}

	public FileAttaches() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	PanelGroup attach_files;
	@UiField
	Anchor linkAddFile;

	public void loadInfo(int user_id, int lecture_id) {
		this.user_id = user_id;
		this.lecture_id = lecture_id;
	}

	public void addFiles(ArrayList<AttachFile> files) {
		for (AttachFile file : files) {
			addFile(file);
		}
	}

	public void addFile(AttachFile file) {
		FileAttach attach = new FileAttach();
		attach.setFile(file);
		attach_files.add(attach);
		attach_files.setId("attac_file_" + file.getId());
	}

	@UiHandler("linkAddFile")
	void onLinAddFileClick(ClickEvent e) {
		AttachForm form = new AttachForm(new FileAttach());
		AttachFile af = new AttachFile();
		af.setLectureId(lecture_id);
		af.setUserId(user_id);
		form.setFileAttaches(this, af);
		form.setAttachFile(af);
		form.setTitle("Add file");
		form.show();
	}
}

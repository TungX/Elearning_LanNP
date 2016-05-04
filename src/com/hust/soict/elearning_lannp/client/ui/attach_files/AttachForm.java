package com.hust.soict.elearning_lannp.client.ui.attach_files;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Widget;

public class AttachForm extends Composite {

	private static AttachFormUiBinder uiBinder = GWT
			.create(AttachFormUiBinder.class);

	interface AttachFormUiBinder extends UiBinder<Widget, AttachForm> {
	}

	public AttachForm() {
		initWidget(uiBinder.createAndBindUi(this));
		attachForm.setAction(GWT.getModuleBaseURL() + "fileupload");
		attachForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		attachForm.setMethod(FormPanel.METHOD_POST);
	}

	@UiField
	FormPanel attachForm;
	
	public void submit() {
		attachForm.submit();
	}
}

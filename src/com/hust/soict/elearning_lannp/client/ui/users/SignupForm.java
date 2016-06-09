package com.hust.soict.elearning_lannp.client.ui.users;

import java.util.HashMap;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.InlineRadio;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfUser;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;
import com.hust.soict.elearning_lannp.shared.model.User;

public class SignupForm extends FormInputAbastract {

	private static SignupFormUiBinder uiBinder = GWT
			.create(SignupFormUiBinder.class);
	private EventOfUser event;
	private User user;

	interface SignupFormUiBinder extends UiBinder<Widget, SignupForm> {
	}

	public SignupForm() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		this.user = new User();
		this.uploadFile.getElement().setAttribute("accept", "image/*");
		avatarForm.setAction(GWT.getModuleBaseURL() + "fileupload");
		avatarForm.setEncoding(FormPanel.ENCODING_MULTIPART);
		avatarForm.setMethod(FormPanel.METHOD_POST);
		this.errors = new HashMap<String, Span>();
		this.errors.put("email", requiredEmail);
		this.errors.put("name", requiredName);
		this.errors.put("password", requiredPassword);
		this.errors.put("password_confirm", requiredPasswordConfirm);
	}

	@UiField
	Modal modalSignUp;
	@UiField
	TextBox txtName;
	@UiField
	TextBox txtEmail;
	@UiField
	Input txtPassword;
	@UiField
	Input txtPasswordConfirmation;
	@UiField
	FileUpload uploadFile;
	@UiField
	InlineRadio radioStudent;
	@UiField
	Button btnSave;
	@UiField
	FormPanel avatarForm;
	@UiField
	FlowPanel panelRadio;
	@UiField
	Span requiredName;
	@UiField
	Span requiredEmail;
	@UiField
	Span requiredPassword;
	@UiField
	Span requiredPasswordConfirm;

	public void show() {
		modalSignUp.show();
	}

	public void submit() {
		if (!uploadFile.getFilename().isEmpty())
			avatarForm.submit();
	}

	@Override
	public void hide() {
		modalSignUp.hide();
	}

	public void setTitle(String title) {
		this.modalSignUp.setTitle(title);
	}

	public void setEvent(EventOfUser event) {
		this.event = event;
	}

	public void setUser(User user) {
		this.txtEmail.setText(user.getEmail());
		this.txtName.setText(user.getDisplayName());
		this.panelRadio.removeFromParent();
		this.user = user;
	}

	@UiHandler("btnSave")
	void onBtnSaveClick(ClickEvent e) {
		this.clearError();
		String name = this.txtName.getText();
		String email = this.txtEmail.getText();
		String password = this.txtPassword.getText();
		String password_confirm = this.txtPasswordConfirmation.getText();
		String filename = uploadFile.getFilename();
		int type = this.radioStudent.getValue() ? 0 : 1;
		this.user.setInfo(email, password, password_confirm, name, type,
				filename);
		if (!this.user.validate()) {
			this.printError(this.user.getErros());
			return;
		}

		if (this.user.getId() == 0) {
			this.event.doCreate(user);
		} else {
			this.event.doUpdate(user);
		}
		submit();
	}
}

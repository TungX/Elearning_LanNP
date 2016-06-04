package com.hust.soict.elearning_lannp.client.ui.users;

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.FormInputAbastract;

public class SignupForm extends FormInputAbastract {

	private static SignupFormUiBinder uiBinder = GWT.create(SignupFormUiBinder.class);

	interface SignupFormUiBinder extends UiBinder<Widget, SignupForm> {
	}

	public SignupForm() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
	}

	@UiField
	Modal modalSignUp;

	public void show() {
		modalSignUp.show();
	}

	@Override
	public void hide() {
		modalSignUp.hide();
	}

	public void setTitle(String title) {
		this.modalSignUp.setTitle(title);
	}
}

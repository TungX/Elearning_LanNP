package com.hust.soict.elearning_lannp.client.ui.users;

import org.gwtbootstrap3.client.ui.Modal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class User_new extends Composite {

	private static SignupFormUiBinder uiBinder = GWT
			.create(SignupFormUiBinder.class);

	interface SignupFormUiBinder extends UiBinder<Widget, User_new> {
	}

	public User_new() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
	}
	
	@UiField Modal modalSignUp;
	public void showModal(){
		modalSignUp.show();
	}

}

package com.hust.soict.elearning_lannp.client.ui.login;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.Elearning_LanNP;
import com.hust.soict.elearning_lannp.client.event.EventOfUser;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.client.ui.users.SignupForm;

public class LoginForm extends Composite {
	private EventOfUser event;
	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, LoginForm> {
	}

	public LoginForm(NavTab nav) {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		event = new EventOfUser(this, nav);
	}

	@UiField
	Modal modalLogin;

	public void showModal() {
		modalLogin.show();
	}

	public void hideModal() {
		modalLogin.hide();
	}

	@UiHandler("urlSignUp")
	void onUrlSignUpClick(ClickEvent e) {
		this.modalLogin.hide();
		SignupForm signupForm = new SignupForm();
		signupForm.show();
	}

	@UiField
	Button btnLogin;

	@UiField
	Input txtPassword;
	@UiField
	TextBox txtEmail;
	@UiField
	CheckBox isAutoLogin;

	@UiHandler("btnLogin")
	void onBtnLogin(ClickEvent e) {
		String email = txtEmail.getValue();
		String password = txtPassword.getValue();
		event.doLogin(email, password, isAutoLogin.getValue());
	}
	
	public void setCourseIndex(CourseIndex courseIndex, Elearning_LanNP homepage){
		event.setCourseIndex(courseIndex);
		event.setHomePage(homepage);
	}
}

package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.SessionService;
import com.hust.soict.elearning_lannp.client.service.SessionServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.login.LoginForm;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.shared.model.User;

public class EventOfLogin {
	private SessionServiceAsync sessionService;
	private NavTab nav;
	private LoginForm form;

	public EventOfLogin(LoginForm loginForm, NavTab nav) {
		sessionService = GWT.create(SessionService.class);
		this.nav = nav;
		this.form = loginForm;
	}

	public void doLogin(String email, String password) {
		sessionService.loginServer(email, password, new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("errors, please check code");
			}

			@Override
			public void onSuccess(User result) {
				if (result == null) {
					Window.alert("can't login");
				} else {
					nav.hideTagLogin();
					nav.showProperty();
					nav.setProperty(result);
					form.hideModal();
				}
			}
		});
	}
}

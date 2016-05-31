package com.hust.soict.elearning_lannp.client.event;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.SessionService;
import com.hust.soict.elearning_lannp.client.service.SessionServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.login.LoginForm;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.User;

public class EventOfLogin {
	final private long DURATION = 1000 * 60 * 60 * 24 * 14;
	private SessionServiceAsync sessionService;
	private NavTab nav;
	private LoginForm form;
	private User user;

	public EventOfLogin(LoginForm loginForm, NavTab nav) {
		sessionService = GWT.create(SessionService.class);
		this.nav = nav;
		this.form = loginForm;
		this.user = new User();
	}

	public void doLogin(String email, String password, boolean isAutoLogin) {
		if (isAutoLogin) {
			this.user.setAutoLogin(isAutoLogin);
			this.user.setPassword(password);
		}

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
					if (user.isAutoLogin()) {
						Date expires = new Date(System.currentTimeMillis() + DURATION);
						Cookies.setCookie("id", result.getId() + "", expires);
						Cookies.setCookie("password", user.getPassword(), expires);
						Cookies.setCookie("isAutoLogin", "1", expires);
					}
					user = result;
					Store.setUser(user);
				}
			}
		});
	}

	public void loginWithCookies() {
		if (Cookies.getCookie("isAutoLogin") != "1")
			return;
		try {
			int id = Integer.parseInt(Cookies.getCookie("id"));
			String password = Cookies.getCookie("password");
			sessionService.loginWithCookies(id, password, new AsyncCallback<User>() {

				@Override
				public void onSuccess(User result) {
					// TODO Auto-generated method stub
					user = result;
					nav.hideTagLogin();
					nav.showProperty();
					nav.setProperty(result);
					Store.setUser(result);
					return;
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Store.setUser(null);
					return;
				}
			});
		} catch (Exception e) {
			Store.setUser(null);
			return;
		}
	}
}

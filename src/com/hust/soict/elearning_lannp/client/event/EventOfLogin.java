package com.hust.soict.elearning_lannp.client.event;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.SessionService;
import com.hust.soict.elearning_lannp.client.service.SessionServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
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
	private CourseIndex courseIndex;

	public void setCourseIndex(CourseIndex courseIndex) {
		this.courseIndex = courseIndex;
	}

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
		try {
			if (Store.user.getType() != 1)
				this.courseIndex.hideAddCourse();
			else
				this.courseIndex.showAddCourse();
		} catch (Exception e) {
			this.courseIndex.hideAddCourse();
		}
	}

	public void autoLogin() {
		this.sessionService.loginFromSessionServer(new AsyncCallback<User>() {

			@Override
			public void onSuccess(User result) {
				// TODO Auto-generated method stub
				if (result != null) {
					loadUserInfo(result);
					return;
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("login fail");
			}
		});
		loginWithCookies();
	}

	public void loginWithCookies() {
		if (Cookies.getCookie("isAutoLogin") != "1") {
			Store.setUser(null);
			return;
		}
		try {
			int id = Integer.parseInt(Cookies.getCookie("id"));
			String password = Cookies.getCookie("password");
			sessionService.loginWithCookies(id, password, new AsyncCallback<User>() {

				@Override
				public void onSuccess(User result) {
					// TODO Auto-generated method stub
					loadUserInfo(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Store.setUser(null);
				}
			});
		} catch (Exception e) {
			Store.setUser(null);
		}
		try {
			if (Store.user.getType() != 1)
				this.courseIndex.hideAddCourse();
			else
				this.courseIndex.showAddCourse();
		} catch (Exception e) {
			this.courseIndex.hideAddCourse();
		}
	}

	public void logout() {
		sessionService.logout(new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				nav.changeDisplayName("User");
				nav.disableProperty();
				nav.hideProperty();
				nav.showTagLogin();
				Store.setUser(null);
				Cookies.removeCookie("isAutoLogin");
				Cookies.removeCookie("id");
				Cookies.removeCookie("password");
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
		this.courseIndex.hideAddCourse();
	}

	private void loadUserInfo(User user) {
		nav.hideTagLogin();
		nav.showProperty();
		nav.setProperty(user);
		Store.setUser(user);
		
	}
	
	private void loadCourseAdd(User user){
		try {
			if (user.getType() != 1)
				this.courseIndex.hideAddCourse();
			else
				this.courseIndex.showAddCourse();
		} catch (Exception e) {
			this.courseIndex.hideAddCourse();
		}
	}
}
